package com.doit.peakge.hos.mybatis.test;

import com.doit.peakge.hos.mybatis.HosDataSourceConfig;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Import(HosDataSourceConfig.class)
@PropertySource("classpath:application.properties")
@ComponentScan("com.doit.peakge.hos*")
@MapperScan("com.doit.peakge.hos*")
public class BaseTest {

}
