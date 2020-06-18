package Helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    InputStream input;
    Properties prop;

    public Properties readProperties() {

        {
            try {
                input = new FileInputStream("./src/main/resources/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        {
            prop = new Properties();
            // load a properties file
            try {
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
