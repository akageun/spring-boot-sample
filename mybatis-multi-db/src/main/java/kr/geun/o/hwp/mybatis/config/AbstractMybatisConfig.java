package kr.geun.o.hwp.mybatis.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;

import java.util.Collections;

/**
 * Mybatis 관련 설정
 *
 * @author akageun
 */
public abstract class AbstractMybatisConfig {

	@Autowired
	private Environment env;

	/**
	 * DataSource 관련 기본 메소드
	 * - DB 명에 따른 프로퍼티 설정
	 *
	 * @param dbNm
	 * @return
	 */
	protected final BasicDataSource getDataSource(String dbNm) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("spring." + dbNm + ".database.driverClassName"));
		dataSource.setUrl(env.getProperty("spring." + dbNm + ".database.url"));
		dataSource.setUsername(env.getProperty("spring." + dbNm + ".database.username"));
		dataSource.setPassword(env.getProperty("spring." + dbNm + ".database.password"));

		return dataSource;
	}

	/**
	 * 트랜젝션 AOP 관련 공통 설정
	 *
	 * @return
	 */
	protected final NameMatchTransactionAttributeSource getNameMatchTransactionAttributeSource() {
		RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
		transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		//transactionAttribute.setTimeout(DBConstants.TX_METHOD_TIMEOUT);

		NameMatchTransactionAttributeSource nameMatch = new NameMatchTransactionAttributeSource();
		nameMatch.addTransactionalMethod("add*", transactionAttribute);
		nameMatch.addTransactionalMethod("modify*", transactionAttribute);
		nameMatch.addTransactionalMethod("delete*", transactionAttribute);

		return nameMatch;
	}
}
