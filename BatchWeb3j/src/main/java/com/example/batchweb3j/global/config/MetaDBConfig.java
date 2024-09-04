package com.example.batchweb3j.global.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "entityManagerFactory",
	transactionManagerRef = "transactionManager")
public class MetaDBConfig {
	@Bean
	@ConfigurationProperties("meta.datasource")
	public DataSourceProperties metaDataSourceProperties(){
		return new DataSourceProperties();
	}

	@Bean
	public DataSource metaDataSource(){
		return metaDataSourceProperties()
			.initializeDataSourceBuilder()
			.type(HikariDataSource.class)
			.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean metaEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(metaDataSource());
		factory.setPackagesToScan("com.example.batchweb3j"); // 엔티티 패키지 경로
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return factory;
	}

	@Bean
	public JpaTransactionManager metaTransactionManager(EntityManagerFactory metaEntityManagerFactory) {
		return new JpaTransactionManager(metaEntityManagerFactory);
	}
}
