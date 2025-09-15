package com.worms.mybatisspring.config;

import com.worms.mybatisspring.section01.factorybean.MenuMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 설명. 나중엔 간편히 할 수 있으니 이번 프로젝트느 추가 설정 할 예정 */
@Configuration
public class MybatisConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.jdbc-url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        
        /* 설명. 데이터베이스 연결 시도 유지 시간 */
        dataSource.setConnectionTimeout(30000); // 30초

        /* 설명. 데이터베이스 유휴 시간(커넥트 되고 이후 쿼리가 안날아 가는 상태를 대기하는 시간) */
        dataSource.setIdleTimeout(600000); // 10분
        
        /* 설명. 데이터 베이스 연결 최대 유지 시간 */
        dataSource.setMaxLifetime(1800000); // 30분

        dataSource.setMaximumPoolSize(50);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        org.apache.ibatis.session.Configuration configuration
                = new org.apache.ibatis.session.Configuration();
        configuration.addMapper(MenuMapper.class);

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());            // environment의 개념
        factoryBean.setConfiguration(configuration);        // mapper 추가 개념

        return factoryBean.getObject();
    }
}
