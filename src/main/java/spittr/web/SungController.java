package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Sung")
class SungController {
    @RequestMapping(method=RequestMethod.GET)
    public String sung() {
	return "sung";
    }
}
