package com.jsantos.template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
//@Slf4j

public class FileExportService  {
	
	
	Configuration tplConfig;
	
	public FileExportService(TemplateLoader templateLoader) {
		tplConfig= new Configuration(Configuration.VERSION_2_3_25);
		tplConfig.setTemplateLoader(templateLoader);
	}
	
	public String renderTemplate(TemplateData templateData) throws ApiException {
		String result;
		try (StringWriter writer = new StringWriter();) {
			Template tpl = tplConfig.getTemplate(templateData.getTemplateTypeId().toString());
			tpl.process(templateData.getData(), writer);
			result = writer.toString();
		} catch (IOException e) {
			////log.error(e.getMessage());
			throw new ApiException(ApiError.IO_ERROR, "Cannot access the template " + templateData.getTemplateTypeId() , e);
		} catch (TemplateException e) {
			////log.error(e.getMessage());
			throw new ApiException(ApiError.PARSING_ERROR, "Error ocurred parsing Template", e);
		}
		return result;
	}
	
	
	public File generatePDF(TemplateData templateData) throws ApiException {
		File temp;

		try {
			temp = File.createTempFile("tpl_", ".pdf");
		} catch (IOException e) {
			////log.error(e.getMessage());
			throw new ApiException(ApiError.IO_ERROR, "Cannot create temporal file", e);
		}

		try (PdfWriter outputFile = new PdfWriter(temp); PdfDocument pdfDocument = new PdfDocument(outputFile);) {
			pdfDocument.setDefaultPageSize(PageSize.LETTER);
			ConverterProperties converterProperties = new ConverterProperties();
			 String templ=this.renderTemplate(templateData);
			HtmlConverter.convertToPdf(templ, pdfDocument, converterProperties);
			return temp;
		} catch (IOException e) {
			////log.error(e.getMessage());
			throw new ApiException(ApiError.IO_ERROR, "Cannot access the template", e);
		}
	}
	
	public File doMerge(List<File> pdfFiles) throws ApiException {

		Document document = new Document();
		PdfCopy copy = null;
		File temp = null;
		try {
			temp = File.createTempFile("mergedPdf_", ".pdf");
			copy = new PdfCopy(document, new FileOutputStream(temp.getPath()));
		} catch (DocumentException | IOException e) {
			////log.error(e.getMessage());
			throw new ApiException(ApiError.IO_ERROR, "Cannot create document", e);
		}
		document.open();
		for (File file : pdfFiles) {
			PdfReader pdfReader = null;
			try {
				URL url = file.toURI().toURL();
				pdfReader = new PdfReader(url);
				copy.addDocument(pdfReader);
				copy.freeReader(pdfReader);
			} catch (IOException | DocumentException ioe) {
				////log.error(ioe.getMessage());
				throw new ApiException(ApiError.IO_ERROR, "Cannot copy document", ioe);
			}
			pdfReader.close();
		}
		document.close();
		return new File(temp.getPath());
	}
	
	public File generatePDFFromHTML(String html) throws ApiException {
		File temp;
		try {
			temp = File.createTempFile("tpl_", ".pdf");
		} catch (IOException e) {
			////log.error(e.getMessage());
			throw new ApiException(ApiError.IO_ERROR, "Cannot create temporal file", e);
		}

		try (PdfWriter outputFile = new PdfWriter(temp); PdfDocument pdfDocument = new PdfDocument(outputFile);) {
			pdfDocument.setDefaultPageSize(PageSize.LETTER);
			ConverterProperties converterProperties = new ConverterProperties();
			HtmlConverter.convertToPdf(html, pdfDocument, converterProperties);
			return temp;
		} catch (IOException e) {
			////log.error(e.getMessage());
			throw new ApiException(ApiError.IO_ERROR, "Cannot access the template", e);
		}
	}

	public Configuration getTplConfig() {
		return tplConfig;
	}

	public void setTplConfig(Configuration tplConfig) {
		this.tplConfig = tplConfig;
	}
}
