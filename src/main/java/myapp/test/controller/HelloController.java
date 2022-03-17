package myapp.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(Model m) {
		m.addAttribute("hello", "hello,spring!");
		return "hello"; //view정보
	}
}
