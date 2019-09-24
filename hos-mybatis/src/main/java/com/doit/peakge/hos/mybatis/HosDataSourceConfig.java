package com.doit.peakge.hos.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

@Configuration
@MapperScan(basePackages = HosDataSourceConfig.PAKAGE,sqlSessionFactoryRef = "HosSqlSessionFactory")
public class HosDataSourceConfig {
    static final String PAKAGE = "com.doit.peakge.hos.**";

    @Bean(name = "HosDataSource")
    @Primary
    public DataSource hosDataSource() throws IOException {
        ResourceLoader loader = new DefaultResourceLoader();

        //1.获取datasource相关配置信息的输入流
        InputStream inputStream = loader.getResource("classpath:application.properties").getInputStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        Set<Object> keys = properties.keySet();
        Properties dsProperties = new Properties();

        //2.将以"datasource"开头的属性信息放到dsProperties中
        for(Object key:keys){
            if(key.toString().startsWith("datasource")){
                dsProperties.put(key.toString().replace("datasource.", ""), properties.get(key));
            }
        }
        //3.将dsProperties传给HikariDataSourceFactory对象，获取DataSource
        HikariDataSourceFactory factory = new HikariDataSourceFactory();
        factory.setProperties(dsProperties);
        inputStream.close();
        return factory.getDataSource();
    }

    @Bean(name = "HosSqlSessionFactory")
    @Primary
    public SqlSessionFactory hosSqlSessionFactory(@Qualifier("HosDataSource")DataSource phoenixDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(phoenixDataSource);
        ResourceLoader loader = new DefaultResourceLoader();

        //1.读取mybatis相关配置文件mybatis-config.xml
        String resource = "classpath:mybatis-config.xml";
        factoryBean.setConfigLocation(loader.getResource(resource));

        //2.获取sqlSessionFactory的实例
        factoryBean.setSqlSessionFactoryBuilder(new SqlSessionFactoryBuilder());
        return factoryBean.getObject();
    }
}
