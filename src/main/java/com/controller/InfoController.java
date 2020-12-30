package com.controller;

import com.DTO.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class InfoController {



//    @Value("${server.port}")
//    private String serverPort;
//
//    @GetMapping("info-server")
//    public String getServerPort(){
//    return serverPort;
//    }

//    @Value("${spring.profiles.active}")
//    private String profileActive;
//    @GetMapping("/hi/info-server")
//    public String getactive(){
//        return profileActive;
//    }

//    @GetMapping("info-server")
//    public String getServerPort(){
//        return serverPort;
//    }
//    @GetMapping("h2-console-enabled")
//    public String getH2ConsoleEnabled(){
//        return consoleEnabled;
//    }
//    @GetMapping("data-source-url")
//    public String getDataSourceUrl(){
//        return dataSoutceUrl;
//    }
//    @GetMapping("hibernate-ddl-auto")
//    public String getHibernateDdlAuto(){
//        return hibernateDdlAuto;
//    }
//    @GetMapping("jpa-show-sql")
//    public String getJpaShowSql(){
//        return jpaShowSql;
//    }
//    @GetMapping("prop-hibernate-format-sql")
//    public String getJpaPropertiesHibernateFormatSql(){
//        return jpaPropertieshibernateFormatSql;
//    }
//    @GetMapping("logging-level-hibernate-type")
//    public String getLoggingLevelHibernate(){
//        return loggingLevelHibernate;
//    }
    @Value("${spring.profiles.active}")
    private String activeProfile;
    @Value("${spring.jpa.show-sql}")
    private String jpaShowSql;
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
//    @Value("${spring.jpa.hibernate.ddl-auto}")
//    private String hibernateDdlAuto;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String jpaPropertieshibernateFormatSql;
    @Value("${logging.level.org.hibernate.type}")
    private String loggingLevelHibernate;
    @Value("${app.message}")
    private String appMessage;


    @GetMapping("getAppProperties")
    public List<Info> getAppProperties(){
       List<Info> infoList=new ArrayList<>();
        Info port=new Info("server.port",serverPort);
        Info showSql=new Info("spring.jpa.show-sql",jpaShowSql);
        Info message=new Info("app.message",appMessage);
        Info sourceUrl=new Info("spring.datasource.url",dataSourceUrl);
//        Info hibernateDdl=new Info("spring.jpa.hibernate.ddl-auto",hibernateDdlAuto);
        Info driverName=new Info("spring.datasource.driverClassName",driverClassName);
        Info username=new Info("spring.datasource.username",userName);
        Info pass=new Info("spring.datasource.password",password);
        Info formatsql=new Info("spring.jpa.properties.hibernate.format_sql",jpaPropertieshibernateFormatSql);
        Info loggingLevel=new Info("logging.level.org.hibernate.type",loggingLevelHibernate);
        Info profile=new Info("spring.profiles.active",activeProfile);

        addList(infoList,profile,port,message,showSql,sourceUrl,driverName,username,pass,formatsql,loggingLevel);
        return infoList;
    }

    public List<Info> addList(List<Info> infoList,Info profile,Info port,Info message,Info showSql,Info sourceUrl,Info driverName,Info username,Info pass,Info formatsql,Info loggingLevel){
        infoList.add(profile);
        infoList.add(port);
        infoList.add(message);
        infoList.add(showSql);
        infoList.add(sourceUrl);
        infoList.add(driverName);
        infoList.add(username);
        infoList.add(pass);
        infoList.add(formatsql);
        infoList.add(loggingLevel);

        return infoList;
    }


}
