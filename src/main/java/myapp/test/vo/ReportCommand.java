package myapp.test.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReportCommand {
	
	private String studentNumber;
	private MultipartFile report;
}
