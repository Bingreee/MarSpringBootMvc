package myapp.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.test.dao.MembersDao;

@Service
public class MembersService {

	@Autowired
	MembersDao dao;
	
	public String login(String id) {
		return dao.login(id);
	}
}
