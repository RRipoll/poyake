package com.jsantos.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsantos.common.util.MapValues;
import com.jsantos.orm.exceptions.ApiException;

@RestController
@RequestMapping("/rest/api")
//@Slf4j
public class tokenController {
	
	@GetMapping("/sandbox/token/{loginName}")
	public MapValues<String> gettoken(@PathVariable String loginName) throws ApiException {
		////log.info("**** getSettings for  {}", loginName);
		MapValues<String> value= new MapValues<String>();
		value.put("token",  "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjUwMzdjN2YzLTAzYTAtNDExMi04MTdmLTFhNmM1YTc0MzI5OSJ9.eyJzdWIiOiJzYSIsImF1ZCI6IndlYiIsIklucHV0U291cmNlIjoyLCJJbnB1dC1Vc2VyIjoxLCJpc3MiOiJGYXN0bGFuZSIsIkF1dGhQcm92aWRlciI6ImRhdGFiYXNlIiwiSW5wdXQtTG9jYXRpb24iOjAsImV4cCI6MTU5MTM4NzYxMCwiaWF0IjoxNTU5ODUxNjEwfQ.huDCOVC3YE5EvcYaLwlH8ISrKSpVSU73763ulbMGtnaqv_5vRJwxRCK_e_DQxLKPCTQz7pb-zs_BkwMiGT1I_8CzEp_4wxKkBDjuMRlpg5Y-MSMYDP-L4yLwkAy_3Hd2PnGDRkXh0IwUUnSO_vMa55hQI4BJVM63MbxIupJKCBO-apy5mY1Gzf9I_1nL9KYJsRznuFzxfaC3-YNjjcWHhvJ6sVw4rRqwPFToEv-QUe9VC1ofbJW_wCcciWOASd0Cj2zQCZ9V-TwNJpDB2MA8PjuRED4B-rS6Jvud7I-t3gddcEwLTnHEN02o8AS8PdqeLnKulBxS2uRVuABHx0c37Q");
		return value;
	}
}
