package configManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configurationManager {
	public static Properties pro = new Properties();

	static {
		try {
			String path = System.getProperty("user.dir") + "\\src\\test\\resource\\Config.properties";
			FileInputStream file = new FileInputStream(path);
			pro.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String get(String key) {
		String value = pro.getProperty(key);
		if (value == null) {
			throw new RuntimeException("⚠️ Key not found in config.properties: " + key);
		}
		return value;

	}
}
