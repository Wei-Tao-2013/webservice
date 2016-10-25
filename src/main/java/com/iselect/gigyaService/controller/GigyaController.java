package com.iselect.gigyaService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iselect.gigyaService.exception.ServiceException;
import com.iselect.gigyaService.model.GigyaRequest;
import com.iselect.gigyaService.model.GigyaResponse;
import com.iselect.gigyaService.service.GigyaDetailsResponse;


/**
 * Handles requests for the application home page.
 */
@Controller
public class GigyaController {
	private static final Logger logger = LoggerFactory.getLogger(GigyaController.class);
	
	@Autowired 
	private GigyaDetailsResponse gigyaDetailsResponse;

	
	@RequestMapping(value = "/login", method = RequestMethod.POST,headers="Accept=application/json")
    public @ResponseBody GigyaResponse getLoginDetails(@RequestBody GigyaRequest gigyaRequest) throws Throwable  {		
         	GigyaResponse gr = gigyaDetailsResponse.getLoginResponse(gigyaRequest);                			
			return gr;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers="Accept=application/json")
    public @ResponseBody GigyaResponse update(@RequestBody GigyaRequest gigyaRequest) throws Throwable {
		logger.debug("GigyaController update :: " +gigyaRequest.getIdentifierType() + "~" + gigyaRequest.getSocialUUID() +"~" + gigyaRequest.getUrlSaved() +"~" +gigyaRequest.getVerticalId()); 
		return gigyaDetailsResponse.saveDetails(gigyaRequest);     
    }
	
	
	
	
}
