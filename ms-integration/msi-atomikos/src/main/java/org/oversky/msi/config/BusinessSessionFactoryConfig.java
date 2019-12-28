package org.oversky.msi.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;

@Configuration
@MapperScan(basePackages = "org.oversky.dreamland", sqlSessionTemplateRef = "businessSqlSessionTemplate")
public class BusinessSessionFactoryConfig {

	@Bean(name = "businessDataSource")
    public DataSource businessDataSource(BusinessDBConfig config) throws SQLException {  
		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		mysqlXaDataSource.setUrl(config.getUrl());
		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		mysqlXaDataSource.setPassword(config.getPassword());
		mysqlXaDataSource.setUser(config.getUsername());
		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
 
		// 将本地事务注册到创 Atomikos全局事务
		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXaDataSource);
		xaDataSource.setUniqueResourceName(config.getUniqueName());
 
		xaDataSource.setMinPoolSize(config.getMinPoolSize());
		xaDataSource.setMaxPoolSize(config.getMaxPoolSize());
		xaDataSource.setMaxLifetime(config.getMaxLifetime());
		xaDataSource.setBorrowConnectionTimeout(config.getBorrowConnectionTimeout());
		xaDataSource.setLoginTimeout(config.getLoginTimeout());
		xaDataSource.setMaintenanceInterval(config.getMaintenanceInterval());
		xaDataSource.setMaxIdleTime(config.getMaxIdleTime());
		xaDataSource.setTestQuery(config.getTestQuery());
		return xaDataSource;

	}
	
    @Bean(name = "businessSessionFactory")
    public SqlSessionFactory businessSessionFactory(@Qualifier("businessDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //指定mapper xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:org/oversky/dreamland/mapper/**/*.xml"));
        return factoryBean.getObject();

    }

	@Bean(name = "businessSqlSessionTemplate")
	public SqlSessionTemplate businessSqlSessionTemplate(@Qualifier("businessSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
