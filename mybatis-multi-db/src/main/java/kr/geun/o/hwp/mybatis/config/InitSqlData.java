package kr.geun.o.hwp.mybatis.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 *
 *
 * @author akageun
 */
@Configuration
public class InitSqlData implements InitializingBean {

	@Autowired
	@Qualifier("subDBDataSource")
	private DataSource subDBDataSource;

	@Autowired
	@Qualifier("mainDBDataSource")
	private DataSource mainDBDataSource;

	@Override
	public void afterPropertiesSet() throws Exception {
		DatabasePopulatorUtils.execute(getScripts("initQuery/main_schema.sql", "initQuery/main_data.sql"), mainDBDataSource); // schema init
		DatabasePopulatorUtils.execute(getScripts("initQuery/sub_schema.sql", "initQuery/sub_data.sql"), subDBDataSource); // schema init
	}

	private ResourceDatabasePopulator getScripts(String... script) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		for (String st : script) {
			resourceDatabasePopulator.addScript(new ClassPathResource(st));
		}

		return resourceDatabasePopulator;
	}
}
