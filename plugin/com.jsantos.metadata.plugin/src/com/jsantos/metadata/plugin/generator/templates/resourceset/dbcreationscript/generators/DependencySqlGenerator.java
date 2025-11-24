package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;

import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.eclipse.emf.common.util.URI;

import com.jsantos.metadata.plugin.util.EclipseFileUtil;

public class DependencySqlGenerator {
	ArrayList<Long> dependencies = new ArrayList<>();

	void render(StringBuffer out, URI uri, String fileName) {
		try {
			String fileContents =EclipseFileUtil.readProjectFile(uri);
			Checksum crc32 = new CRC32();
			byte[] bytes = fileContents.getBytes();
			crc32.update(bytes, 0, bytes.length);
			Long checksum =  crc32.getValue();
			if (!dependencies.contains(checksum)) {
				dependencies.add(checksum);
				out.append("--- Start Dependency file: " + fileName + " ---------------\r\n");
				out.append(fileContents);
				out.append("\r\n--- End of Dependency file: " + fileName + "\r\n\r\n");
				out.append("; -- Generated Statement \r\n\r\n");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
