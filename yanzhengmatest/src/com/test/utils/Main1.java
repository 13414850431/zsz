package com.test.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main1 {

	public static void main(String[] args) {
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("c:\\temp\\yzm.jpg");
			VerifyCodeUtils.outputImage(150, 80, fos, verifyCode);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
