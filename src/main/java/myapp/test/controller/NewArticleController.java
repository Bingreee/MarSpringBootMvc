package myapp.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import myapp.test.service.ArticleService;
import myapp.test.vo.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle")
public class NewArticleController {

	@Autowired
	private ArticleService articleService;

	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		return "article/newArticleForm";
	}

	@PostMapping
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.writeArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}