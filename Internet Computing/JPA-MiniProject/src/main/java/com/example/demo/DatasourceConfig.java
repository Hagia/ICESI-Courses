package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {

	@Bean
	public DataSource datasource() {
		DataSource ds = DataSourceBuilder.create()
				.driverClassName("org.springframework.jdbc.datasource.DriverManagerDataSource")
				.url("jdbc:h2:mem:testdb").username("sa").password("").build();

		return ds;

	}
}
