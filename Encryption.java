package messagesStudy;

import messagesStudy.Utilities;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Encryption {

//	This is what they see in the question.
	public void action(String message) throws Exception {

		KeyGenerator keyGen = KeyGenerator.getInstance("RC2");
		SecretKey key = keyGen.generateKey();

		Cipher cipher = Cipher.getInstance("RC2");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		cipher.update(message.getBytes());

		byte[] data = cipher.doFinal();

		System.out.println(Utilities.toString(data));
	}

//	Wrong use of encryption algorithm. OFB is weak.
	public void action_bad_asnwer_1(String message) throws Exception {

		KeyGenerator keyGen = KeyGenerator.getInstance("OFB");
		SecretKey key = keyGen.generateKey();

		Cipher cipher = Cipher.getInstance("OFB");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		cipher.update(message.getBytes());

		byte[] data = cipher.doFinal();

		System.out.println(Utilities.toString(data));
	}

//	Wrong use of IV. First line generates an array with all zeros. Also, key size is 64.
	public void action_bad_asnwer_2(String message) throws Exception {

		IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]);

		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(64);
		SecretKey secretKey = generator.generateKey();

		Cipher cipher = Cipher.getInstance("AES/GCM/PKCS5Padding", "BC");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
		cipher.update(message.getBytes());

		byte[] data = cipher.doFinal();
		System.out.println(Utilities.toString(data));
	}

	public void action_right_answer(String message) throws Exception {

		KeyGenerator keyGen = KeyGenerator.getInstance("AES/GCM/NoPadding");
		keyGen.init(128);
		SecretKey key = keyGen.generateKey();

		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		cipher.update(message.getBytes());

		byte[] data = cipher.doFinal();

		System.out.println(Utilities.toString(data));
	}
}
