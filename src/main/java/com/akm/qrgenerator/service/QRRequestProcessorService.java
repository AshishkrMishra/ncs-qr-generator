package com.akm.qrgenerator.service;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akm.qrgenerator.pojo.UserQRRequest;
import com.akm.qrgenerator.pojo.UserQRResponse;

@Service 
public class QRRequestProcessorService {
	
	@Autowired
	UrlValidatorService  urlValidatorService;
	
	
	@Autowired 
	QRGeneratorService qrGeneratorService;
	
	public  UserQRResponse process(UserQRRequest userQRRequest)
	{
		
		UserQRResponse response= new UserQRResponse();
		response.setUserQrRequest(userQRRequest);
		response.setStatus("failed");
		if(urlValidatorService.isValidUrl(userQRRequest.getUrl()))
		{
			try
			{
				String path=qrGeneratorService.generate(userQRRequest.getUrl());
				response.setStatus("sucess");
				System.out.println("Actual image location : "+path);
				File imageFile=new File(path);
				String imageAsBase64=encodeFileToBase64Binary(imageFile);
				response.setImage(imageAsBase64);
				
			}catch(Exception e)
			{
				response.setFailureReason(e.getMessage());
			}
			
		}else
		{
			response.setFailureReason("Invalid Url");
		}
		return response;
	}
	
	
	private static String encodeFileToBase64Binary(File file) throws Exception{
         @SuppressWarnings("resource")
		FileInputStream fileInputStreamReader = new FileInputStream(file);
         byte[] bytes = new byte[(int)file.length()];
         fileInputStreamReader.read(bytes);
         return new String(Base64.encodeBase64(bytes), "UTF-8");
     }
	

}
