package com.ashken.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableJpaRepositories(entityManagerFactoryRef="EntityManagerFactory",transactionManagerRef="TransactionManager", basePackages="com.ashken.jpaRepositories")
@EnableTransactionManagement
public class JPADataConfig {
	
	@Bean(name = "DataSource")
	public DataSource getAuthDataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/Filesdb");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	@Autowired
	@Bean(name="EntityManagerFactory")
    EntityManagerFactory entityManagerFactory(@Qualifier("DataSource") DataSource dataSource) {
		
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.ashken.entities");
       
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();
       
        return entityManagerFactoryBean.getObject();
    }
	
	
	 @Autowired
	 @Bean(name = "TransactionManager")
	    JpaTransactionManager transactionManager(@Qualifier("EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	        return transactionManager;
	    }
	
	

}
