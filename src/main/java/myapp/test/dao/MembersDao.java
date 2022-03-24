package myapp.test.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MembersDao {
		
	String login(String id);
}	
