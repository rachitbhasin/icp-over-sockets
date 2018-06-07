package com.rachit;

import com.rachit.summationServer.SummationClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomUtils {
    static final String PROP_FILE = "resources/application.properties";

    public static Properties getProperties() throws FileNotFoundException {
        Properties prop = new Properties();
        InputStream input = SummationClient.class.getClassLoader().getResourceAsStream(PROP_FILE);
        if(input==null){
            System.out.println("Sorry, unable to find " + PROP_FILE);
            throw new FileNotFoundException();
        }

        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
