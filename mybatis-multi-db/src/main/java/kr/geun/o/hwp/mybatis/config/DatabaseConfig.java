package kr.geun.o.hwp.mybatis.config;

import kr.geun.o.hwp.mybatis.config.annotation.MainDB;
import kr.geun.o.hwp.mybatis.config.annotation.SubDB;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * @author akageun
 */
public class DatabaseConfig {

    @Configuration
    @MapperScan(basePackages = "kr.geun.o.hwp.mybatis.**", annotationClass = MainDB.class, sqlSessionFactoryRef = "mainDBSQLSession")
    public static class MainDbMybatisConfig {

        @Bean(name = "mainDBDataSource")
        @Primary
        @ConfigurationProperties(prefix = "spring.database.main-db")
        public DataSource mainDBDataSource() {
            return DataSourceBuilder.create().build();

        }

        /**
         * sqlSessionFactory 선언
         *
         * @return
         * @throws Exception
         */
        @Primary
        @Bean(name = "mainDBSQLSession")
        public SqlSessionFactoryBean sqlSessionFactoryBean(
                @Qualifier("mainDBDataSource") DataSource dataSource
        ) throws Exception {

            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);

            // mybatis mapper 위치 설정
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/main/**/*.xml"));
            return sessionFactory;
        }

        /**
         * 트랜젝션 선언
         *
         * @return
         */
        @Bean(name = "mainDBTransactionManager")
        public DataSourceTransactionManager transactionManager(
                @Qualifier("mainDBDataSource") DataSource dataSource
        ) {
            return new DataSourceTransactionManager(dataSource);
        }

        /**
         * aop 설정
         *
         * @return
         */
        @Bean(name = "mainDBTransactionAdvice")
        public TransactionInterceptor txAdvice(
                @Qualifier("mainDBTransactionManager") DataSourceTransactionManager transactionManager
        ) {

            RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
            transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
            //transactionAttribute.setTimeout(DBConstants.TX_METHOD_TIMEOUT);

            NameMatchTransactionAttributeSource nameMatch = new NameMatchTransactionAttributeSource();
            nameMatch.addTransactionalMethod("add*", transactionAttribute);
            nameMatch.addTransactionalMethod("modify*", transactionAttribute);
            nameMatch.addTransactionalMethod("delete*", transactionAttribute);

            return new TransactionInterceptor(transactionManager, nameMatch);
        }

        /**
         * aop 대상 설정
         *
         * @return
         */
        @Bean(name = "mainDBTransactionAdvisor")
        public Advisor txAdviceAdvisor(
                @Qualifier("mainDBTransactionAdvice") TransactionInterceptor txAdvice
        ) {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression("execution(* kr.geun.o.hwp.mybatis..*Impl.*(..))");
            return new DefaultPointcutAdvisor(pointcut, txAdvice);
        }
    }

    @Configuration
    @MapperScan(basePackages = "kr.geun.o.hwp.mybatis.**", annotationClass = SubDB.class, sqlSessionFactoryRef = "subDBSQLSession")
    public static class SubDbMybatisConfig {


        @Bean(name = "subDBDataSource")
        @ConfigurationProperties(prefix = "spring.database.sub-db")
        public DataSource subDBDataSource() {
            return DataSourceBuilder.create().build();

        }

        /**
         * sqlSessionFactory 선언
         *
         * @return
         * @throws Exception
         */
        @Bean(name = "subDBSQLSession")
        public SqlSessionFactoryBean sqlSessionFactoryBean(
                @Qualifier("subDBDataSource") DataSource dataSource
        ) throws Exception {

            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);

            // mybatis mapper 위치 설정
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/sub/**/*.xml"));
            return sessionFactory;
        }

        /**
         * 트랜젝션 선언
         *
         * @return
         */
        @Bean(name = "subDBTransactionManager")
        public DataSourceTransactionManager transactionManager(
                @Qualifier("subDBDataSource") DataSource dataSource
        ) {
            return new DataSourceTransactionManager(dataSource);
        }

        /**
         * aop 설정
         *
         * @return
         */
        @Bean(name = "subDBTransactionAdvice")
        public TransactionInterceptor txAdvice(
                @Qualifier("subDBTransactionManager") DataSourceTransactionManager transactionManager
        ) {
            RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
            transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
            //transactionAttribute.setTimeout(DBConstants.TX_METHOD_TIMEOUT);

            NameMatchTransactionAttributeSource nameMatch = new NameMatchTransactionAttributeSource();
            nameMatch.addTransactionalMethod("add*", transactionAttribute);
            nameMatch.addTransactionalMethod("modify*", transactionAttribute);
            nameMatch.addTransactionalMethod("delete*", transactionAttribute);

            return new TransactionInterceptor(transactionManager, nameMatch);
        }

        /**
         * aop 대상 설정
         *
         * @return
         */
        @Bean(name = "subDBTransactionAdvisor")
        public Advisor txAdviceAdvisor(
                @Qualifier("subDBTransactionAdvice") TransactionInterceptor txAdvice
        ) {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression("execution(* kr.geun.o.hwp.mybatis..*Impl.*(..))");
            return new DefaultPointcutAdvisor(pointcut, txAdvice);
        }

    }
}
