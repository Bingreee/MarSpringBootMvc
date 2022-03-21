package myapp.test.scott.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myapp.test.scott.dto.Dept;

@Mapper
public interface DeptDao {

	List<Dept> deptAll(); //select => 레코드 1개 : resultType
	Dept deptOne(int no); //	   => 레코드 n개 : List<resultType>
	int maxNo();
	int addDept(Dept d); //insert, update, delete => int
}  


