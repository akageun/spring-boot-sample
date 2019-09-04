package kr.geun.o.hwp.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * HomeController
 *
 * @author akageun
 * @since 2019-09-04
 */
@Slf4j
@Controller
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @GetMapping("/")
    public ModelAndView home(HttpServletRequest request) {
        log.info("LocaleResolver : {}", messageSource.getMessage("hello", new Object[]{}, localeResolver.resolveLocale(request)));

        log.info("messageSourceAccessor : {}", messageSourceAccessor.getMessage("hello"));
        log.info("messageSourceAccessor with LocaleResolver : {}", messageSourceAccessor.getMessage("hello", localeResolver.resolveLocale(request)));

        return new ModelAndView("home");
    }
}
