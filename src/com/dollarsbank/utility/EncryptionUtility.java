package com.dollarsbank.utility;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class EncryptionUtility
{
	
	
	public String encrypt(String password) throws Exception
	{
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("NexusTK");
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
		
		byte[] salt = new byte[8];
		Random random = new Random();
		random.nextBytes(salt);
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
		Cipher cipher = Cipher.getInstance("NexusTK");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, pbeParameterSpec);
		
		System.out.println("Cipher =" + cipher.toString());
		
		return cipher.toString();
	}
	
	
}
