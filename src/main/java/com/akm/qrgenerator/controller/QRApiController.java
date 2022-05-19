package com.akm.qrgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.akm.qrgenerator.pojo.UserQRRequest;
import com.akm.qrgenerator.pojo.UserQRResponse;
import com.akm.qrgenerator.service.QRRequestProcessorService;

@Controller
public class QRApiController {
	

	@Autowired 
	QRRequestProcessorService qrRequestProcessorService;
	
	
	@GetMapping("/")
	   public String viewHome(Model model) {

	      return "welcomePage";
	   }
	
	@GetMapping(value = "/qrGenerator")
	public String generateQR(Model model)
	{
		UserQRRequest userQRRequest= new UserQRRequest();
		model.addAttribute("userQRRequest", userQRRequest);
		return "qrGenerator";
	}

	
	@PostMapping("/qrGenerator")
	public String submitForm(Model model ,@ModelAttribute("userQRRequest") UserQRRequest userQRRequest) 
	{
		
		System.out.println(userQRRequest);
		UserQRResponse response=qrRequestProcessorService.process(userQRRequest);
		model.addAttribute("response",response);
		model.addAttribute("image","data:image/png;base64,"+response.getImage());
		return "qrStatus";
		
		
	}


}
