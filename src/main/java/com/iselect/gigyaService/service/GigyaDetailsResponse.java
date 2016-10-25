package com.iselect.gigyaService.service;

import com.iselect.gigyaService.model.GigyaRequest;
import com.iselect.gigyaService.model.GigyaResponse;
import com.iselect.gigyaService.exception.ServiceException;




public interface GigyaDetailsResponse {
	GigyaResponse getLoginResponse(GigyaRequest gigyaRequest) throws  ServiceException;
	GigyaResponse saveDetails(GigyaRequest gigyaRequest) throws  ServiceException;
}
