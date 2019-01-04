package kr.geun.o.hwp.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author akageun
 */
@Configuration
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * 필터 등록
	 *
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new SiteMeshFilter()); //sitemesh 필터
		filter.addUrlPatterns("/*");
		return filter;
	}
}
