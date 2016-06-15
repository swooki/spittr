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
    
    @Test
    public void shouldProcessRegistration() throws Exception {
    	SpittleRepository mockRepository = mock(SpittleRepository.class);
    	Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
    	Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
    	when(mockRepository.save(unsaved)).thenReturn(saved);
    	
    	SpitterController controller = new SpitterController(mockRepository);
    	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    	
    	mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register"))
    		.param("firstName", "Jack")
    		.param("lastName", "Bauer")
    		.param("username","jbauer")
    		.param("password", "24hours")
    		.andExpect(redirectedURL("/spitter/jbauer"));
    	verify(mockRepository, atLeastOne()).save(unsaved);
    }
}
