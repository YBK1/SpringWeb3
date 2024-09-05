// package com.example.batchweb3j.global.config;
//
//
// import java.lang.reflect.Field;
// import java.time.DayOfWeek;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.util.ArrayList;
// import java.util.List;
//
// import javax.sql.DataSource;
//
// import org.springframework.batch.core.Job;
// import org.springframework.batch.core.Step;
// import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
//
// import org.springframework.batch.core.explore.JobExplorer;
// import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
// import org.springframework.batch.core.job.builder.JobBuilder;
// import org.springframework.batch.core.launch.JobLauncher;
// import org.springframework.batch.core.launch.support.SimpleJobLauncher;
// import org.springframework.batch.core.repository.JobRepository;
// import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
// import org.springframework.batch.core.step.builder.StepBuilder;
// import org.springframework.batch.item.ItemProcessor;
// import org.springframework.batch.item.database.JpaPagingItemReader;
// import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.autoconfigure.batch.BatchProperties;
// import org.springframework.boot.context.properties.EnableConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.transaction.PlatformTransactionManager;
//
// import jakarta.persistence.EntityManagerFactory;
//
// @Configuration
// @EnableConfigurationProperties()
// public class BatchConfig extends DefaultBatchConfiguration {
// 	@Autowired
// 	@Qualifier("mainDataSource")
// 	private DataSource dataSource;
// 	@Autowired
// 	@Qualifier("mainEntityManagerFactory")
// 	private EntityManagerFactory entityManagerFactory;
//
// 	@Bean
// 	public JobRepository jobRepository(@Qualifier("metaDataSource") DataSource metaDataSource,
// 		@Qualifier("metaTransactionManager") PlatformTransactionManager transactionManager) throws Exception {
// 		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
// 		factory.setDataSource(metaDataSource);
// 		factory.setTransactionManager(transactionManager);
// 		factory.setIsolationLevelForCreate("ISOLATION_DEFAULT");
// 		factory.setTablePrefix("BATCH_"); // BATCH_* 테이블 사용
// 		factory.setMaxVarCharLength(1000);
// 		return factory.getObject();
// 	}
//
// 	@Bean
// 	public JobExplorer jobExplorer(@Qualifier("metaDataSource") DataSource batchDataSource) throws Exception {
// 		JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
// 		jobExplorerFactoryBean.setDataSource(batchDataSource);
// 		return jobExplorerFactoryBean.getObject();
// 	}
//
// 	@Bean
// 	public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
// 		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
// 		jobLauncher.setJobRepository(jobRepository);
// 		jobLauncher.afterPropertiesSet();
// 		return jobLauncher;
// 	}
//
// 	private int chunk = 10;
// 	// Job
// 	@Bean
// 	public Job myJob(JobRepository jobRepository) {
// 		// return new JobBuilder("reservationCreationJob", jobRepository)
// 		// 	.start()
// 		// 	.build();
// 		return null;
// 	}
//
// 	@Bean
// 	public Step getCounselorSchedule(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
// 		// return new StepBuilder("", jobRepository)
// 		// 	.< , >chunk(chunk, transactionManager)
// 		// 	.reader()
// 		// 	.processor()
// 		// 	.writer(list -> {})
// 		// 	.build();
// 		return null;
// 	}
//
// 	@Bean
// 	public JpaPagingItemReader<?> jpaPagingItemReader(EntityManagerFactory entityManagerFactory) {
// 		// return new JpaPagingItemReaderBuilder<>()
// 		// 	.name("")
// 		// 	.entityManagerFactory(entityManagerFactory)
// 		// 	.queryString("select")
// 		// 	.pageSize(1000)
// 		// 	.build();
// 		return null;
// 	}
//
// 	@Bean
// 	public ItemProcessor<?, ?> reservationScheduleProcessor() {
// 		return schedule -> {
// 			return null;
// 		};
// 	}
// }
