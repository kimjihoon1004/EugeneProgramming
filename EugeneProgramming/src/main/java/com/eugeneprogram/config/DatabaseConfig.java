package com.eugeneprogram.config;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"com.eugeneprogram.tc.dao", "com.eugeneprogram.st.dao"})
@EnableTransactionManagement
public class DatabaseConfig {
  @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
          final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
          sessionFactory.setDataSource(dataSource);
          PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
          Resource[] mapperLocations1 = resolver.getResources("classpath:mapper/tc/*.xml");
          Resource[] mapperLocations2 = resolver.getResources("classpath:mapper/st/*.xml");

       // 두 배열을 합쳐서 하나의 배열로 만듦
          Resource[] allMapperLocations = Stream.concat(
                  Arrays.stream(mapperLocations1),
                  Arrays.stream(mapperLocations2)
          ).toArray(Resource[]::new);

          // SqlSessionFactoryBean에 설정
          sessionFactory.setMapperLocations(allMapperLocations);

          return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
          final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
          return sqlSessionTemplate;
    }
}
