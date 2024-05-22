package com.coreautomation.uiautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	/**
	 * Collects value from Property file.
	 * 
	 * @param fileName: Name of property file
	 * @param key:      Key Name.
	 * @return: Returns null if key/file is not preset,else returns the value.
	 */
	public static String GetValue(String fileName, String key) {
		Properties properties = new Properties();
		FileInputStream fis = null;
		String value = null;

		try {
			fis = new FileInputStream(fileName);
			properties.load(fis);
			value = properties.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
