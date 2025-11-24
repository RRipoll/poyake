package com.jsantos.metadata.plugin.querymanager.entityrenderer;

import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.querymanager.parser.SQLParser;
import com.jsantos.metadata.plugin.querymanager.resolver.Resolver;
import com.jsantos.metadata.plugin.querymanager.resolver.ResolverColumn;
import com.jsantos.metadata.plugin.querymanager.resolver.ResolverColumnStatus;

public class ViewAndQueryEntityRenderer {

	public static String render(Resolver resolver, SQLParser parser, IResource sqlFileResource, String sql, ArrayList<IPath> dependencyFileLocations) {
		StringBuffer out = new StringBuffer();
		out.append("FROMSQLFILE '" + sqlFileResource.getFullPath() + "'\r\n");
		if (null != dependencyFileLocations) {
			for (IPath path:dependencyFileLocations) 
				out.append("SQLFILEDEPENDENCY '" + path + "'\r\n");
		}
		out.append("\r\n");
		if (null == parser.getFullyQualifiedViewName()) {
			out.append("SQLQUERY ");
			out.append(" ENTITY ");
			out.append(FilenameUtils.removeExtension(sqlFileResource.getName()));
		}
		else {
			out.append("VIEW ");
			out.append(" ENTITY ");
			out.append(parser.getFullyQualifiedViewName());
		}
		out.append(" {\r\n");
		for (ResolverColumn column:resolver.getResolverColumns()) {
			out.append("\t" + column.getAttributeName());
			if (column.getStatus() == ResolverColumnStatus.SOLVED || column.getStatus()==ResolverColumnStatus.EXPANDED) {
				out.append(" " + column.getSameAsAttribute().getType().getName());
				if (null !=column.getSameAsAttribute().getLength()) { 
					out.append("(" + column.getSameAsAttribute().getLength());
					if (null != column.getSameAsAttribute().getScale())
						out.append("," + column.getSameAsAttribute().getScale());
					out.append(")");
				}
				out.append(" SAMEAS " + ((Entity)column.getSameAsAttribute().eContainer()).getName() + "." + column.getSameAsAttribute().getName());
			}
			if (column.getStatus() == ResolverColumnStatus.EXPRESSION) {
				if (null != column.getDataTypeFromJDBC())
					out.append(" " + column.getDataTypeFromJDBC());
				else
					out.append(" TYPE_UNKNOWN_PLEASE_SET ");
			}
			out.append("\r\n");
		}
		
		if (null == parser.getFullyQualifiedViewName()) {
			out.append("\r\n\tQUERYSOURCE\r\n<<<\r\n");
			out.append(sql);
			out.append("\r\n>>>\r\n\r\n");
		}
		
		out.append("}");
		out.append("\r\n\r\n/*\r\n");
		out.append("================= Parser Information   ======================== \r\n"); 
		String parserResults = parser.logParserResults(); 
		out.append( parserResults + "\r\n\n");
		out.append("================= Resolver Information ======================== \r\n"); 
		out.append(resolver.logInfo());
		out.append("\r\n");
		out.append("================= Parse Tree ======================== \r\n"); 
		out.append(parser.parseTreeToPrettyString());
		out.append("*/\r\n");
		return out.toString();

	}


}
