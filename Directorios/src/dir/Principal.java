package dir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nom1="dir1";
		String nom2="dir2";
		
		File f1=new File(nom1);
		File f2=new File(nom2);
		
		try 
		{
			comparar(f1, f2);
		} 
		catch (IOException e) 
		{
			System.out.println("Vaya, algo ha ocurrido con los ficheros");
		}
		catch (NullPointerException npe)
		{
			System.out.println("Vaya no se ha encontrado algún directorio...");
		}
	}
	
	public static void comparar(File f1, File f2) throws IOException, NullPointerException
	{
		if (f1.list().length==f2.list().length)
		{
			System.out.println("Los directorios SI contienen la misma cantidad de ficheros/directorios");
		}
		else
		{
			System.out.println("Los directorios NO contienen la misma cantidad de ficheros/directorios");
		}
		
		System.out.println("Cantidad en el directorio 1: "+f1.list().length);
		System.out.println("Cantidad en el directorio 2: "+f2.list().length);
	}

}
