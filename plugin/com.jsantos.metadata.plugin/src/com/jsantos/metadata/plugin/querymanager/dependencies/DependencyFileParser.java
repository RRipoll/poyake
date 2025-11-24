package com.jsantos.metadata.plugin.querymanager.dependencies;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

import com.jsantos.metadata.plugin.querymanager.parser.CaseChangingCharStream;
import com.jsantos.metadata.plugin.querymanager.parser.SQLParserListener;
import com.jsantos.metadata.plugin.querymanager.parser.TreeUtils;
import com.jsantos.metadataplugin.parser.sqlserver.TSqlLexer;
import com.jsantos.metadataplugin.parser.sqlserver.TSqlParser;

public class DependencyFileParser {
	

	public ArrayList<IPath> parseSqlFiles(String projectName, ArrayList<String> functionNames) throws CoreException {
		ArrayList<IPath> dependencyFileLocations = new ArrayList<>();
		for (IResource resource:new ResourceCollector().collectResources(projectName)) {
			//System.out.println(resource.getName());
			//System.out.println(resource.getLocation());
			System.out.println(resource.getLocationURI().toString());
			String sql = readFile(resource.getLocation().toString());
			//System.out.println(sql);
			
			if (parse(sql, functionNames)) {
				if (!dependencyFileLocations.contains(resource.getFullPath()))
					dependencyFileLocations.add(resource.getFullPath());
			}
		}
		return dependencyFileLocations;
	}
	
	boolean parse(String sql, ArrayList<String> functionNames) {
		TSqlParser p = null;
		TSqlLexer lexer;
		CaseChangingCharStream in = new CaseChangingCharStream(CharStreams.fromString(sql), true);
		
        lexer = new TSqlLexer(in);
        p = new TSqlParser(new CommonTokenStream(lexer));
        p.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
            }
        });
        SQLParserListener parseListener = new SQLParserListener(); 
        p.addParseListener(parseListener);
        p.setBuildParseTree(true);
        RuleContext tree =p.tsql_file();
        
        System.out.println("=========================== Parse Tree: ================================");
        System.out.println(TreeUtils.toPrettyTree(tree, Arrays.asList(p.getRuleNames())));
        
        Collection<ParseTree> matches = XPath.findAll(tree, "//create_or_alter_function/func_proc_name_schema", p);
		for(ParseTree match:matches) {
			for (String functionName:functionNames)
			  if (match.getText().equalsIgnoreCase(functionName))
				  return true;
		}
		return false;
	}
	
	static String readFile(String path) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, Charset.defaultCharset());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
