package kr.geun.o.hwp.app.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 *
 *
 * @author akageun
 */
@Controller
public class Welcome {
	@Value("${application.msg:Hello World}")
	private String msg;

	@RequestMapping("/")
	public String welcomePage(Model model) {
		model.addAttribute("time", new Date());
		model.addAttribute("msg", msg);

		return "home";
	}
}
