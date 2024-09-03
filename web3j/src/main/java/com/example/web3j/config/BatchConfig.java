package com.example.web3j.config;


import javax.sql.DataSource;

import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BatchProperties.class)
public class BatchConfig extends DefaultBatchConfiguration {
	@Autowired
	private DataSource dataSource;
}
