package myapp.test.emp.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import myapp.test.emp.dto.Emp;
import myapp.test.emp.service.EmpService;
import myapp.test.scott.dto.Dept;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService eservice;
	
	@GetMapping("/insert")
	public String insertForm(Model m) {
		
		int empno = eservice.maxEmpno();
		m.addAttribute("empno", empno);
		
		List<Dept> list = eservice.deptList();
		m.addAttribute("list", list);
		
		return "emp/insertForm";
	}
	
	@PostMapping("/insert")
	public String insert(Emp emp) {
		eservice.addEmp(emp);
		return "redirect:/";
	}
	
	@RequestMapping("/viewEmpDept")
	public String viewEmpDept(Model m) {
		
		List<Dept> list = eservice.deptList();
		m.addAttribute("list", list);
		
		return "emp/viewEmpDept";
	}
	@RequestMapping("/viewEmpsDept/{deptno}")
	@ResponseBody
	public String viewEmps(@PathVariable int deptno) {
		List<Map<String, Object>> enames =
		eservice.empNames1(deptno);
		
		Gson gson = new  Gson();
		String txt_names = gson.toJson(enames); 
		System.out.println(txt_names);
		return txt_names;
	}
	@RequestMapping("/viewEmp/{empno}")
	@ResponseBody
	public String viewEmp(@PathVariable int empno) {
		Emp e =  eservice.emp(empno);
		Gson gson = new  Gson();
		return gson.toJson(e);
	}
	
	@GetMapping("/viewEmpName")
	public String viewEmpName() {
		return "emp/viewEmpName";
	}
	
	@GetMapping("/viewEmpsName/{ename}")
	@ResponseBody //ajax
	public String viewEmps(@PathVariable String ename) {
		List<Map<String,Object>>  list = eservice.empNames2(ename);
		Gson gson= new Gson();
		return gson.toJson(list);
	}
	
	
	@GetMapping("/updateEmp/{empno}")
	public String updateForm(@PathVariable int empno,Model m) {
		Emp e = eservice.emp(empno);
		m.addAttribute("emp",e);
		
		List<Dept> list = eservice.deptList();
		m.addAttribute("list", list);
		
		return "emp/updateForm";
	}
	
	@PutMapping("/updateEmp")
	public String update(Emp e) {
		eservice.updateEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp/{empno}")
	public String deleteForm(@PathVariable int empno, Model m) {
		m.addAttribute("empno",empno);
		return "/emp/delete";
	}
	
	@DeleteMapping("/deleteEmp/{empno}")
	public String delete(@PathVariable int empno) {
		eservice.deleteEmp(empno);
		return "redirect:/";
	}
	
}










