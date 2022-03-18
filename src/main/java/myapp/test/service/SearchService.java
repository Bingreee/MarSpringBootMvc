package myapp.test.service;

import org.springframework.stereotype.Service;

import myapp.test.vo.SearchCommand;

@Service
public class SearchService {
	public SearchResult search(SearchCommand command) {
		return new SearchResult();
	}
}
