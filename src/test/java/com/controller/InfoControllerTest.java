package com.controller;


import com.DTO.Info;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InfoControllerTest {
    @InjectMocks
    private InfoController infoController;

    @Mock
    private List<Info> infoList=new ArrayList<>();

    @Before
    public void setUp(){
//        Info port=new Info("server.port","serverPort");
//        Info showSql=new Info("spring.jpa.show-sql","jpaShowSql");
//        Info message=new Info("app.message","appMessage");
//        Info sourceUrl=new Info("spring.datasource.url","dataSourceUrl");
//        Info driverName=new Info("spring.datasource.driverClassName","driverClassName");
//        Info username=new Info("spring.datasource.username","userName");
//        Info pass=new Info("spring.datasource.password","password");
//        Info formatsql=new Info("spring.jpa.properties.hibernate.format_sql","jpaPropertieshibernateFormatSql");
//        Info loggingLevel=new Info("logging.level.org.hibernate.type","loggingLevelHibernate");
//        Info profile=new Info("spring.profiles.active","activeProfile");

//        infoList.add(profile);
//        infoList.add(port);
//        infoList.add(message);
//        infoList.add(showSql);
//        infoList.add(sourceUrl);
//        infoList.add(driverName);
//        infoList.add(username);
//        infoList.add(pass);
//        infoList.add(formatsql);
//        infoList.add(loggingLevel);
    }

    @Test
    public void shouldAppProp(){
        Info port=new Info("server.port","serverPort");
        Info showSql=new Info("spring.jpa.show-sql","jpaShowSql");
        Info message=new Info("app.message","appMessage");
        Info sourceUrl=new Info("spring.datasource.url","dataSourceUrl");
        Info driverName=new Info("spring.datasource.driverClassName","driverClassName");
        Info username=new Info("spring.datasource.username","userName");
        Info pass=new Info("spring.datasource.password","password");
        Info formatsql=new Info("spring.jpa.properties.hibernate.format_sql","jpaPropertieshibernateFormatSql");
        Info loggingLevel=new Info("logging.level.org.hibernate.type","loggingLevelHibernate");
        Info profile=new Info("spring.profiles.active","activeProfile");

        infoController.addList(infoList,profile,port,message,showSql,sourceUrl,driverName,username,pass,formatsql,loggingLevel);

        List<Info> res =infoController.getAppProperties();

        assertNotNull(res.size());
    }


}