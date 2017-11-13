package com.shawnyan.service.druid;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shawnyan
 * @date 2017/11/13 下午10:30
 */
public class DruidDBConfig {
    private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name:com.mysql.jdbc.Driver}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize:5}")
    private int initialSize;

    @Value("${spring.datasource.minIdle:5}")
    private int minIdle;

    @Value("${spring.datasource.maxActive:20}")
    private int maxActive;

    @Value("${spring.datasource.maxWait:60000}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis:60000}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis:300000}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery:SELECT 1 FROM DUAL}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle:true}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow:false}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn:false}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements:true}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize:20}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters:stat,wall,slf4j}")
    private String filters;


    @Value("${spring.datasource.slowSqlMillis:500}")
    private int slowSqlMillis;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        List<Filter> proxyfilters = new ArrayList<Filter>();
        StatFilter statFiler = new StatFilter();
        statFiler.setLogSlowSql(true);
        statFiler.setMergeSql(true);
        statFiler.setSlowSqlMillis(slowSqlMillis);
        proxyfilters.add(statFiler);
        datasource.setProxyFilters(proxyfilters );
        return datasource;
    }
}
