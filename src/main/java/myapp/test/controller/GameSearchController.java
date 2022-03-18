package myapp.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myapp.test.service.SearchResult;
import myapp.test.service.SearchService;
import myapp.test.vo.SearchCommand;
import myapp.test.vo.SearchType;


@Controller
public class GameSearchController {
	@Autowired
	private SearchService searchService;
	
	@ModelAttribute("searchTypeList")
	public List <SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "뉴스"));
		options.add(new SearchType(3, "블로그"));
		return options;
	}
		
		@ModelAttribute("popularQueryList")
		public String[] getPopularQueryList() {
			return new String[] { "게임", "웹툰", "IT" };
		}
		
		@RequestMapping("/search/main")
		public String main() {
			return "search/main";
		}
		
		@RequestMapping("/search/game")
		public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
			//ModelAndView생성자 첫번째 매개변수는 view name
			ModelAndView mav = new ModelAndView("search/game");
			System.out.println("검색어 = " + command.getQuery().toUpperCase());
			SearchResult result = searchService.search(command);
			mav.addObject("searchResult", result);
			return mav;
		}
			
			@ExceptionHandler(NullPointerException.class)
			public String handleNullPointerException(NullPointerException ex) {
				return "error/nullException";
			}
			
			public void setSearchService(SearchService searchService) {
				this.searchService = searchService;
			}
	
}
