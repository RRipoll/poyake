package com.jsantos.rest.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsantos.orm.MainDb;
import com.jsantos.orm.DBUtil.SQLScriptRunner;
import com.jsantos.orm.exceptions.ApiException;

import io.swagger.annotations.ApiOperation;


@RestController

@RequestMapping("/rest/api/development/system")


public class SystemController {
	
	
	/*
	@ApiOperation(value = "Get Posting Date.", notes = "Get Posting Date.")
	@GetMapping("/posting-date")
	public PostingDateDTO getPostingDate() throws ApiException {

		try {
			PostingDateDTO postingDateDTO = new PostingDateDTO();
			
			postingDateDTO.setPostingDate(postingDateDTO.getPostingDate());
			return postingDateDTO;
		} catch (DataAccessException e) {
			throw new ApiException(ApiError.DB_BAD_SQL);
		}
	}
	
	@ApiOperation(value = "Set PostingDate", notes = "Update PostingDate")
	@PutMapping("/posting-date")
	public PostingDateDTO setPostingDate(@RequestBody Date postingDate) throws ApiException {
		try {
			PostingDateDTO postingDateDTO = new PostingDateDTO(0);
			postingDateDTO.setPostingDate(postingDate);
			postingDateDTO.update();
			return postingDateDTO;
		} catch (DataAccessException e) {
			throw new ApiException(ApiError.DB_BAD_SQL);
		}
	}

	@ApiOperation(value = "Move PostingDate hours", notes = "Move PostingDate hours")
	@PutMapping("/posting-date/move-hours/{hours}")
	public PostingDateDTO moveHours(@PathVariable int hours) throws ApiException {
		try {
			PostingDateDTO postingDateDTO = new PostingDateDTO(0);
			postingDateDTO.setPostingDate(DateUtils.addHours(postingDateDTO.getPostingDate(), hours));
			postingDateDTO.update();
			
			return postingDateDTO;
		} catch (DataAccessException e) {
			throw new ApiException(ApiError.DB_BAD_SQL);
		}
	}
	
	@ApiOperation(value = "Move PostingDate days", notes = "Move PostingDate days")
	@PutMapping("/posting-date/move-days/{days}")
	public PostingDateDTO moveDays(@PathVariable int days) throws ApiException {
		try {
			PostingDateDTO postingDateDTO = new PostingDateDTO(0);
			postingDateDTO.setPostingDate(DateUtils.addDays(postingDateDTO.getPostingDate(), days));
			postingDateDTO.update();
			
			return postingDateDTO;
		} catch (DataAccessException e) {
			throw new ApiException(ApiError.DB_BAD_SQL);
		}
		
	}

	@ApiOperation(value = "Move PostingDate mins", notes = "Move PostingDate mins")
	@PutMapping("/posting-date/move-mins/{mins}")
	public PostingDateDTO moveMins(@PathVariable int mins) throws ApiException {
		try {
			PostingDateDTO postingDateDTO = new PostingDateDTO(0);
			postingDateDTO.setPostingDate(DateUtils.addMinutes(postingDateDTO.getPostingDate(), mins));
			postingDateDTO.update();
			
			return postingDateDTO;
		} catch (DataAccessException e) {
			throw new ApiException(ApiError.DB_BAD_SQL);
		}
		
	}
	*/
	
	@ApiOperation(value = "Reset Db", notes = "Reset Db")
	@GetMapping("/reset-db")
	public String resetDb() throws ApiException, FileNotFoundException, IOException, SQLException {
		
			    NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
				
			    try {
			    	jdbcTemplate.getJdbcTemplate().execute("DROP ALL OBJECTS DELETE FILES");
				} catch (Exception e) {
					e.printStackTrace();
				}
		File path = new ClassPathResource("sql/DB_Creation_Script2.sql").getFile();
		//System.out.println(path.getAbsolutePath());
		
		//File path=(File) AppInfoFactory.getResource("sql.DBCreationPath", "sql/DB_Creation_Script2.sql");	 ;   
		
		
		//URL sqlScriptUrl = MyServletContextListener.class
          //      .getClassLoader().getResource("sql/DB_Creation_Script.sql");
		
		//URL path=new DbCreationResourcePath().getPath();
		SQLScriptRunner.runScript(new FileReader(path));
    		    return "Reset Db accomplished";
	}
	
}

