package com.example.batchweb3j.global.config;

import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
	entityManagerFactoryRef = "mainEntityManagerFactory",
	transactionManagerRef = "mainTransactionManager")
public class MainDBConfig {
	@Primary
	@Bean(name = "mainDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.main")
	public DataSource mainDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "mainEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(mainDataSource());
		factory.setPackagesToScan("com.example.batchweb3j.document.model"); // 엔티티 패키지 경로
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return factory;
	}

	@Primary
	@Bean(name = "mainTransactionManager")
	public JpaTransactionManager mainTransactionManager(EntityManagerFactory primaryEntityManagerFactory) {
		return new JpaTransactionManager(primaryEntityManagerFactory);
	}
}
