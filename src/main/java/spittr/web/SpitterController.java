package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;

	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(Spitter spitter) {
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	@RequestMapping(value="/{username}", method=GET)
	  public String showSpitterProfile(@PathVariable String username, Model model) {
	    Spitter spitter = spitterRepository.findByUsername(username);
	    model.addAttribute(spitter);
	    return "profile";
	  }	
}
