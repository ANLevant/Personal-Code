package com.seguro.canguro.test.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.seguro.canguro.test.mapper")
public class MyBatisConfig {
	
	@Value("${db-username}")
	private String dbUsername;
	@Value("${db-password}")
	private String dbPassword;
	@Value("${db-url}")
	private String dbUrl;
	@Value("${db-driverclass}")
	private String dbDriver;
	
	@Bean
	public DataSource Datasource(){
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		dataSource.setUrl(dbUrl);
		dataSource.setDriverClassName(dbDriver);
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory SqlSessionFactory(){
		
		DataSource dataSource = Datasource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
		configuration.addMappers("com.seguro.canguro.test.mapper");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		return sqlSessionFactory;
	}

}
