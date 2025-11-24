package com.jsantos.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsantos.metadata.common.StorageFileDTO;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;




@RestController
@RequestMapping("/rest/api/file")
//@Slf4j


public class FileController {

	
	
	
	
	//@ApiOperation(value = "Download file", notes = "Download file")
	@GetMapping(path = "/{fileStorageId}/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public byte[] downloadFileStorageById(@PathVariable Long fileStorageId, HttpServletResponse response) throws ApiException {
		//log.info("*** downloadFileStorageById: {}", fileStorageId);
		try {
			StorageFileDTO storageFileDTO = (StorageFileDTO) new StorageFileDTO().findByPk(fileStorageId);
			response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + storageFileDTO.getFileName());
			response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Expires", "0");
	        
	        InputStream in = new FileInputStream(storageFileDTO.getLocation());
	        return IOUtils.toByteArray(in);
		} catch (Exception e) {
			throw new ApiException(ApiError.IO_ERROR, "Error getting file from server", e);
		}
	}
	
}
