package org.oversky.code.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.oversky.code.util.PropertiesUtil;

public class ExecJarGenerator extends CodeGenerator{

	private String configName = null;
	
    public String getConfigName() {
    	if(configName == null) {
    		configName = "config.properties";
    	}
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	@Override
    protected String getConfig(String key) {
        if(util == null){
        	Properties prop = new Properties();
            try {
            	String filePath = System.getProperty("user.dir") + File.separator + getConfigName();
                System.out.println("配置文件路径:" + filePath);
                InputStream in = new FileInputStream(new File(filePath));
                prop.load(in);
                util = new PropertiesUtil(prop);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("解析配置文件异常:" + e.getMessage());
            }        
        }
        String val =  util.getValue(key);
        if(val == null) {
        	val = "";
        }
        return val;
    }

    @Override
    protected String getClassPath(){
        return System.getProperty("user.dir");
    }
	
	public static void main(String[] args) {
		ExecJarGenerator gen = new ExecJarGenerator();
		if(args == null || args.length == 0) {
			gen.setConfigName("config.properties");
		}else {
			gen.setConfigName(args[0]);
		}
        gen.projectGenerate();
	}
}
