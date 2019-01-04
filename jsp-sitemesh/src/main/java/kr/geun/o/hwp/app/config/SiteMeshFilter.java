package kr.geun.o.hwp.app.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;

/**
 *
 *
 * @author akageun
 */
public class SiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		final String bsDecorators = "/WEB-INF/decorators/bsDecorators.jsp";

		//@formatter:off
        builder
	        .addTagRuleBundle(new Sm2TagRuleBundle())
	        .addDecoratorPath("/*", bsDecorators)
        //@formatter:on
		;
	}
}
