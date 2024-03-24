package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile 
{
	private static FileInputStream fis;
	private static Properties prop = null;

	public static String getProperty(String property)
	{		
		try 
		{
			fis = new FileInputStream(new File("config.properties"));
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) 
		{
			fnfe.printStackTrace();

		} catch(IOException ioe) 
		{
			ioe.printStackTrace();
		} 
		finally
		{
			try
			{
				fis.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return prop.getProperty(property).trim();
	}
}
