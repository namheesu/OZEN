package kr.or.ddit.global.security.otp;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Component;

@Component
public class OtpUtils {
	
	public String creatCode() {
	    byte[] buffer = new byte[5 + 5 * 5];
	    new Random().nextBytes(buffer);
	    Base32 codec = new Base32();
	    byte[] secretKey = Arrays.copyOf(buffer, 10);  //16자 이상이여하므로 10으로 설정 필요
	    byte[] bEncodedKey = codec.encode(secretKey);
	     
	    //인증키 생성
	    String encodedKey = new String(bEncodedKey); 
	    
	    return encodedKey;
	}
	
	//코드 체크 함수
	public boolean checkCode(String secret, long code, long t) throws InvalidKeyException, NoSuchAlgorithmException {
	  Base32 codec = new Base32();
	  byte[] decodedKey = codec.decode(secret);
	 
	  int window = 3;
	  for (int i = -window; i <= window; ++i) {
	      long hash = verifyCode(decodedKey, t + i);
	 
	      if (hash == code) {
	          return true;
	      }
	  }
	  return false;
	}
	 
	//코드 확인 함수
	public int verifyCode(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException{
	  byte[] data = new byte[8];
	  long value = t;
	  for (int i = 8; i-- > 0; value >>>= 8) {
	      data[i] = (byte) value;
	  }
	 
	  SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
	  Mac mac = Mac.getInstance("HmacSHA1");
	  mac.init(signKey);
	  byte[] hash = mac.doFinal(data);
	 
	  int offset = hash[20 - 1] & 0xF;
	 
	  long truncatedHash = 0;
	  for (int i = 0; i < 4; ++i) {
	      truncatedHash <<= 8;
	      truncatedHash |= (hash[offset + i] & 0xFF);
	  }
	 
	  truncatedHash &= 0x7FFFFFFF;
	  truncatedHash %= 1000000;
	 
	  return (int) truncatedHash;
	}
}
