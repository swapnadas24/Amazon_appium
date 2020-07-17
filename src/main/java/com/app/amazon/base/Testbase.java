package com.app.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Testbase {
    
    public Properties prop;
        
        
    public Testbase() {
            try {
                prop = new Properties();
                FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/app/amazon/config/application.properties");
                prop.load(objfile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
    }   
}
    
