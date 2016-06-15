package spittr.web;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasItems;

import static org.mockito.Mockito.*;

import spittr.Spittle;
import spittr.data.SpittleRepository;

public class SpitterControllerTest {
    @Test
    public void shouldShowRegistration() throws Exception {
	SpitterController controller = new SpitterController();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
		.andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }
}
