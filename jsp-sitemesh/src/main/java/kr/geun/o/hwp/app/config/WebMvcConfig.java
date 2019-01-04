package kr.geun.o.hwp.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 *
 * @author akageun
 */

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	/**
	 * 정적자원
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//@formatter:off
		VersionResourceResolver versionResourceResolver = new VersionResourceResolver();
		versionResourceResolver.addFixedVersionStrategy("v.0.0.1", "/**");

		registry
			.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/")
					.setCachePeriod(3600)
					.resourceChain(true)
					.addResolver(versionResourceResolver);

		registry
			.addResourceHandler("/favicon.ico")
				.addResourceLocations("/resources/")
					.setCachePeriod(3600)
					.resourceChain(true)
					.addResolver(new PathResourceResolver());
		//@formatter:on
	}

	@Bean
	public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
		ResourceUrlEncodingFilter filter = new ResourceUrlEncodingFilter();

		return filter;
	}
}
