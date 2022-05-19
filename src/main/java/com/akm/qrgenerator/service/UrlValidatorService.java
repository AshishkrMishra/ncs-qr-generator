package com.akm.qrgenerator.service;

import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class UrlValidatorService {
	
	public boolean isValidUrl(String url)
	
	{
		/* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }
          
        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
	}

}
