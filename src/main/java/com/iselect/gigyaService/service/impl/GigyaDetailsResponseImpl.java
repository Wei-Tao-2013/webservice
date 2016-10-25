package com.iselect.gigyaService.service.impl;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iselect.gigyaService.dao.GigyaDAO;
import com.iselect.gigyaService.exception.ServiceException;
import com.iselect.gigyaService.model.Gigya;
import com.iselect.gigyaService.model.GigyaRequest;
import com.iselect.gigyaService.model.GigyaResponse;
import com.iselect.gigyaService.service.GigyaDetailsResponse;


@Component
public class GigyaDetailsResponseImpl implements GigyaDetailsResponse {
	private Logger logger = LoggerFactory.getLogger(GigyaDetailsResponse.class);	
	
	@Autowired 
	private GigyaDAO gigyaDAOImpl;
	
	
	public GigyaResponse getLoginResponse(final GigyaRequest gigyaRequest)
			throws  ServiceException {
		
		GigyaResponse gigyaResponse=new GigyaResponse();
		Gigya gigya=gigyaDAOImpl.getInfo(gigyaRequest.getSocialUUID(),gigyaRequest.getVertical());
		
		if(gigya==null){
			gigyaResponse.setSocialUUID(gigyaRequest.getSocialUUID());
			gigyaResponse.setVertical(gigyaRequest.getVertical());			
		}else{
			gigyaResponse.setSocialUUID(gigya.getSocialUUID());
			gigyaResponse.setVertical(gigya.getVertical());
			gigyaResponse.setVerticalId(gigya.getVerticalId());
			gigyaResponse.setIdentifierType(gigya.getIdentifierType());
			gigyaResponse.setUrlSaved(gigya.getUrlSaved());
		}
		
		return gigyaResponse;
		
	}
	
	public  GigyaResponse saveDetails(final GigyaRequest gigyaRequest)
			throws  ServiceException {
		
		Gigya gigya=gigyaDAOImpl.getInfo(gigyaRequest.getSocialUUID(),gigyaRequest.getVertical());		
		final Calendar today = Calendar.getInstance();
		
		if(gigya!=null){
			if(StringUtils.isNotBlank(gigyaRequest.getVerticalId()) && StringUtils.isNotBlank(gigyaRequest.getIdentifierType())){
				gigya.setVerticalId(gigyaRequest.getVerticalId());
				gigya.setIdentifierType(gigyaRequest.getIdentifierType());
				gigya.setUrlSaved(gigyaRequest.getUrlSaved());
				gigya.setUpdateddDate(today);
			}
		
		}else{
			gigya=new Gigya();
			gigya.setSocialUUID(gigyaRequest.getSocialUUID());
			gigya.setVertical(gigyaRequest.getVertical());
			gigya.setVerticalId(gigyaRequest.getVerticalId());
			gigya.setIdentifierType(gigyaRequest.getIdentifierType());
			gigya.setUrlSaved(gigyaRequest.getUrlSaved());
			gigya.setCreatedDate(today);
			gigya.setUpdateddDate(today);
			
		}
		
		gigya= gigyaDAOImpl.merge(gigya);
		
		GigyaResponse gigyaResponse=new GigyaResponse();
		
		gigyaResponse.setSocialUUID(gigya.getSocialUUID());
		gigyaResponse.setVertical(gigya.getVertical());
		gigyaResponse.setVerticalId(gigya.getVerticalId());
		gigyaResponse.setIdentifierType(gigya.getIdentifierType());
		gigyaResponse.setUrlSaved(gigya.getUrlSaved());
		
		return gigyaResponse;
	
	}
		

}
