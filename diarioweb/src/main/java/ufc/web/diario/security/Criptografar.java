package ufc.web.diario.security;


import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografar {

	private static MessageDigest md;
	
	public Criptografar() {
		// TODO Auto-generated constructor stub
	}
	
	public String criptografar(String senha){

		String convertida = null;
		
		try {
			
			// Obtendo instância do algoritmo MD5
			md = MessageDigest.getInstance("MD5");			
			
			// Passando a senha como uma sequência de bytes para a criptografia 
			byte[] converter = md.digest(senha.getBytes());
			
			//Convetendo os bytes para uma string de retorno no padrão UTF-8
			//convertida = new String(converter, "UTF-8");
			convertida = converterString(senha, "UTF-8");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertida;
	}
	

	public static String converterString(String content, String encode) {  
	    Charset charset = Charset.forName(encode);  
	    ByteBuffer bb = charset.encode(content);  
	    return bb.toString();  
	} 
}
