package myapp.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import myapp.test.vo.LoginDto;

@Controller
@SessionAttributes("user")
public class Logincontroller {
	
	//세션에 같은 이름으로 저장이 되어있는 경우 동작하지 않는다.
		//세션에 저장되지 않는 경우 실행 후 리턴값을 세션에 저장한다. 
		@ModelAttribute("user")
		public LoginDto getLoginDto() {
			System.out.println("getLoginDto()실행");
			return new LoginDto(); 
		}
		
		@GetMapping("/loginForm")
		public String form() {
			return "login/loginForm";
		}
		
		@RequestMapping("/login")
		public String login(@Valid LoginDto dto, BindingResult result, Model m) {
			if(result.hasErrors()) {
				return "login/loginForm";
			}
			if(dto.getId().equals(dto.getPw())) {
				//로그인 성공 => 세션에 저장
				m.addAttribute("user", dto);
			}else {
				result.reject("nocode","fail to login");//에러 코드 추가
				return "login/loginForm";
			}
			
			return "login/login";
		}
		@GetMapping("/logout")
		public String logout(SessionStatus status) {
			status.setComplete();
			return "redirect:/";
		}
		//@ModelAttribute("user") : session에 user라는 이름으로 저장된 데이터 가져옴
		@GetMapping("/checklogin")
		public String check(@ModelAttribute("user") LoginDto dto) {
			if(dto.getId() != null) {
				return "login/loginCheck";
			}else {
				return "redirect:/loginForm"; 
			}
		}
}
