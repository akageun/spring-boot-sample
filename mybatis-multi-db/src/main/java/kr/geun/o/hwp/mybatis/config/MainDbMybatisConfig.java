package kr.geun.o.hwp.mybatis.config;

import kr.geun.o.hwp.mybatis.config.annotation.MainDB;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;

/**
 * Main DB 설정
 *
 * @author akageun
 */
@Configuration
@MapperScan(basePackages = "kr.geun.o.hwp.mybatis.**", annotationClass = MainDB.class, sqlSessionFactoryRef = "mainDBSQLSession")
public class MainDbMybatisConfig extends AbstractMybatisConfig {

	/**
	 * DataSource Setting
	 *  - Connection Pool Sample Value
	 *
	 * @return
	 */
	@Primary
	@Bean(name = "mainDBDataSource", destroyMethod = "close")
	//	@ConfigurationProperties(prefix = "spring.booking.datasource")
	public DataSource dataSource() {
		BasicDataSource dataSource = getDataSource("mainDB");
		dataSource.setMaxTotal(50);
		dataSource.setMaxWaitMillis(3000L);
		dataSource.setMaxIdle(50);
		dataSource.setMinIdle(2);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);
		dataSource.setValidationQuery("select 1");
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(130000L);
		dataSource.setMinEvictableIdleTimeMillis(120000L);
		dataSource.setNumTestsPerEvictionRun(50);
		dataSource.setRemoveAbandonedTimeout(30);
		dataSource.setRemoveAbandonedOnBorrow(true);
		dataSource.setLogAbandoned(false);

		return dataSource;
	}

	/**
	 * sqlSessionFactory 선언
	 *
	 * @return
	 * @throws Exception
	 */
	@Primary
	@Bean(name = "mainDBSQLSession")
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());

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
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	/**
	 * aop 설정
	 *
	 * @return
	 */
	@Bean(name = "mainDBTransactionAdvice")
	public TransactionInterceptor txAdvice() {
		return new TransactionInterceptor(transactionManager(), getNameMatchTransactionAttributeSource());
	}

	/**
	 * aop 대상 설정
	 *
	 * @return
	 */
	@Bean(name = "mainDBTransactionAdvisor")
	public Advisor txAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* kr.geun.o.hwp.mybatis..*Impl.*(..))");
		return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}

}
