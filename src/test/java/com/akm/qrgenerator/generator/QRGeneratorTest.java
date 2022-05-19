package com.akm.qrgenerator.generator;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.akm.qrgenerator.service.QRGeneratorService;
import com.google.zxing.WriterException;

public class QRGeneratorTest {

	@Test
	public void testQRGenerator() throws IOException, WriterException {

		try
		{
			String url = "http://localhost:8080";
			QRGeneratorService generatorService = new QRGeneratorService();
			generatorService.generate(url);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
