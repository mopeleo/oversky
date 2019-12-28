package org.oversky;

import org.oversky.msi.config.BusinessDBConfig;
import org.oversky.msi.config.SystemDBConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//加载配置
@EnableConfigurationProperties({SystemDBConfig.class,BusinessDBConfig.class})
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
