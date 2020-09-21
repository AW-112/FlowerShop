package com.udacity.demoapplication;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@ConfigurationProperties("spring.datasource.configuration")
public class DatasourceConfig {
    /*public DataSource getDataSource() {
        DataSourceBuilder dsb = DataSourceBuilder.create();
        dsb.url("jdbc:mysql://${MYSQL_HOST:localhost}:3306/plant?serverTimezone=UTC&useLegacyDatetimeCode=false");
        return dsb.build();
    }

    private String securePasswordService() {
        return "Plant$User";
    }*/
}
