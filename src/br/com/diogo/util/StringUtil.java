package br.com.diogo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {

	public static String StringToMd5(String texto) {
		MessageDigest m;

		try {
			m = MessageDigest.getInstance("MD5");
			m.update(texto.getBytes(), 0, texto.length());
			BigInteger i = new BigInteger(1, m.digest());

			// Formatando o resuldado em uma cadeia de 32 caracteres,
			// completando com 0 caso falte
			texto = String.format("%1$032X", i);

			System.out.println("MD5: " + texto);
			return texto;
		}

		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}

}
