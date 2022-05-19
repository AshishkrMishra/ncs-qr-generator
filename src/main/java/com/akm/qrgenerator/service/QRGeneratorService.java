package com.akm.qrgenerator.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class QRGeneratorService {

	private static String CHAR_SET = "UTF-8";

	private static int height = 500;
	private static int width = 500;

	@SuppressWarnings("deprecation")
	public String generate(String data) throws IOException, WriterException {

		UUID requestGenerator = UUID.randomUUID();
		String fileName = requestGenerator.toString();
		String format = "png";
		String tmpdir = System.getProperty("java.io.tmpdir");
		String qrfilePath = tmpdir + File.separator + fileName + "." + format;
		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

		// generates QR code with Low level(L) error correction capability
		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(CHAR_SET), CHAR_SET),
				BarcodeFormat.QR_CODE, width, height);
		File qrOutPutPath = new File(qrfilePath);
		MatrixToImageWriter.writeToFile(matrix, format, qrOutPutPath);
		return qrOutPutPath.getAbsolutePath();

	}

}
