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

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
	HomeController controller = new HomeController();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
	List<Spittle> expectedSpittles = createSpittleList(20);
	SpittleRepository mockRepository = mock(SpittleRepository.class);
	when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

	SpittleController controller = new SpittleController(mockRepository);

	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
		.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
	mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
		.andExpect(MockMvcResultMatchers.view().name("spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())))
	 	;
    } 

    private List<Spittle> createSpittleList(int count) {
	List<Spittle> spittles = new ArrayList<Spittle>();
	for (int i = 0; i < count; i++) {
	    spittles.add(new Spittle("Spittle " + i, new Date()));
	}
	return spittles;
    }
}
