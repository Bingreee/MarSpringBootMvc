package myapp.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import myapp.test.validator.ContentValidator;
import myapp.test.vo.ContentDto;

@Controller
public class ValidatorController {

	@RequestMapping("/valid/insertForm")
	public String insert1() {
		return "validator/createPage";
	}

	@RequestMapping("/valid/create")
	public String insert2(@ModelAttribute("dto") @Validated ContentDto contentDto, BindingResult result) {
		String page = "validator/createDonePage";
		System.out.println(contentDto);

		if (result.hasErrors()) { //검사를 통과하지 못한 경우

			if (result.getFieldError("writer") != null) {
				System.out.println("1:" + result.getFieldError("writer").getDefaultMessage());
			}
			if (result.getFieldError("content") != null) {
				System.out.println("2:" + result.getFieldError("content").getDefaultMessage());
			}

			page = "validator/createPage";
		}

		return page;
	}
}
