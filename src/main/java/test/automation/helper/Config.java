package test.automation.helper;

import java.io.FileReader;
import java.util.Properties;

public class Config {

    //To be implemented
    private String filePath;

    private Properties prop;

    private FileReader reader;


    public Config(String filename) throws Exception
    {
        filePath="src//main//resource//"+filename+".properties";
        prop=new Properties();
        reader=new FileReader(filePath);
        prop.load(reader);

    }
    public String getValue(String key){
        return prop.getProperty(key);
    }

    public char[] getPassword(String key){
        return prop.getProperty(key).toCharArray();
    }


}
