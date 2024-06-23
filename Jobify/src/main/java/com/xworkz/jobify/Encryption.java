

package com.xworkz.jobify;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class Encryption {

    public String encrypt(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedStr = encoder.encodeToString(password.getBytes());
        return encryptedStr;
    }

    public String decrypt(String encryptedStr) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encryptedStr);
        String decryptedStr;
		try {
			decryptedStr = new String(decodedBytes,"UTF-8");
	        return decryptedStr;

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
    }
}


		
		
	    



