package kr.geun.o.hwp.app;

import kr.geun.o.hwp.app.web.Welcome;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 *
 * @author akageun
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = Welcome.class)
public class WebControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void welcome() throws Exception {
		//@formatter:off
		mvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("home"))
			.andExpect(model().attributeExists("msg"))
			.andExpect(model().attributeExists("time"))
			;
		//@formatter:on
	}
}
