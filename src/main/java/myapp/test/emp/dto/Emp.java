package myapp.test.emp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Emp {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
}
