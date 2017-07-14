package com.build.oa.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by xzhang on 7/14/2017.
 */
@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource(){
        return new ComboPooledDataSource();
    }

}
