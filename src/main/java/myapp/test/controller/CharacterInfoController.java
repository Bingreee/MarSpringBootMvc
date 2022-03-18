package myapp.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/{id}")
public class CharacterInfoController {
	@RequestMapping("/characters/{characterId}")
	public String characterInfo(@PathVariable("id") String userId,
				@PathVariable int characterId, ModelMap model) {
		model.addAttribute("userId", userId);
		model.addAttribute("characterId", characterId);
		return "character/users/info";
	}
}
