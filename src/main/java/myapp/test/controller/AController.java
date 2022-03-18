package myapp.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class AController {
	 
	@GetMapping("/a")
	public String a() {
		return "test/a";
	}
	
	@GetMapping("/b")
	//@ResponseBody
	public String b() {
		List<String> names = new ArrayList<>();
		names.add("Javakim");
		names.add("anna");
		names.add("admin");
		names.add("김철수");
		
		Gson gson = new Gson();
		String t_names = gson.toJson(names);
		return t_names;
	}
}
