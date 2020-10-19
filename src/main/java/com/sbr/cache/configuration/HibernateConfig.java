package com.sbr.cache.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Value("${spring.hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	
	@Value("${spring.hibernate.dialect}")
	private String dialect;
	
	@Value("${spring.hibernate.scanPackages}")
	private String scanPackages;
	
	@Value("${spring.hibernate.show_sql}")
	private String showSql;
	
	@Value("${spring.hibernate.cache.region.factory_class}")
	private String factoryClass;
	
	@Value("${spring.hibernate.cache.use_second_level_cache}")
	private String secondLevelCache;
	
	@Value("${spring.hibernate.cache.use_query_cache}")
	private String queryCache;
	
	@Value("${spring.hibernate.generate_statistics}")
	private String statistics;
	
	@Value("${spring.hibernate.cache.use_structured_entries}")
	private String structureEntries;
	
	@Value("${spring.hibernate.cache.redisson.config}")
	private String reddissonConfigFile;

	@Autowired
	private DataSource dataSource;
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",this.hbm2ddlAuto);
		hibernateProperties.setProperty("hibernate.dialect",this.dialect);
		hibernateProperties.setProperty("hibernate.show_sql",this.showSql);
		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache",this.secondLevelCache);
		hibernateProperties.setProperty("hibernate.cache.region.factory_class",this.factoryClass);
		hibernateProperties.setProperty("hibernate.cache.use_query_cache", this.queryCache);
		hibernateProperties.setProperty("hibernate.generate_statistics", this.statistics);
		hibernateProperties.setProperty("hibernate.cache.use_structured_entries", this.structureEntries);
		hibernateProperties.setProperty("hibernate.cache.redisson.config",this.reddissonConfigFile);
		return hibernateProperties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(this.dataSource);
		sessionFactory.setPackagesToScan(this.scanPackages);
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}

