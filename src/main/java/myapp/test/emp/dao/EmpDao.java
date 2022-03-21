package myapp.test.emp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import myapp.test.emp.dto.Emp;
import myapp.test.scott.dto.Dept;

@Mapper
public interface EmpDao {

	int maxEmpno();
	List<Dept> deptList();
	int addEmp(Emp emp);
	List<Map<String, Object>> empNames1(int deptno);
	Emp emp(int empno);
}










 