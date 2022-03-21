package myapp.test.emp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.test.emp.dao.EmpDao;
import myapp.test.emp.dto.Emp;
import myapp.test.scott.dto.Dept;

@Service
public class EmpService {
	
	@Autowired
	EmpDao dao;
	
	public int maxEmpno() {
		return dao.maxEmpno()+1;
	}
	public List<Dept> deptList(){
		return dao.deptList();
	}
	public int addEmp(Emp emp) {
		return dao.addEmp(emp);
	}
	public List<Map<String, Object>> empNames1(int deptno){
		return dao.empNames1(deptno);
	}
	public Emp emp(int empno) {
		return dao.emp(empno);
	}
}
