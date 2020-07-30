package com.dollarsbank.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class EncryptionUtility
{
	private byte[] keyBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,
	            0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };
	SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
	public String encrypt(String password) throws Exception
	{
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(password.getBytes());
		String encodeTxt = new String(cipherText);
		//System.out.println("CipherDoFinal =" + encodeTxt);
		return encodeTxt;
	}
	
	public String decrypt(String password) throws Exception
	{
		//System.out.println("in decrypt");
		//System.out.println(password);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
		cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedPassword = cipher.doFinal(password.getBytes());
        String decodeTxt = new String(decryptedPassword);
		return decodeTxt;
	}
}
