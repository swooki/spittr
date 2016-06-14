package spittr.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SungControllerTest {
    @Test
    public void testSungPage() throws Exception {
	SungController controller = new SungController();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(MockMvcRequestBuilders.get("/Sung")).andExpect(MockMvcResultMatchers.view().name("sung"));
    }
}
