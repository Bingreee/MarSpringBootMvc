package myapp.test.emp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import myapp.test.vo.ReportCommand;

@Controller
public class ReportSubmissionController {
	
	@RequestMapping("/report/submission")
	public String form() {
		return "report/submissionForm";
	}
	
	@RequestMapping(value="/report/submitReport1", method= RequestMethod.POST)
	public String submitReport1(String studentNumber, MultipartFile report) {
		printInfo(studentNumber, report);
		System.out.println(upload(report));
		return "report/submissionComplete";
	}
	
	//c:/upload폴더에 업로드
	private String upload(MultipartFile tempfile) {
		long currentTime = System.currentTimeMillis();
		Random random = new Random();
		int r = random.nextInt(50);//0~49 총 50개 범위에서 정수 값 뽑기
		
		String oName = tempfile.getOriginalFilename();
		int index = oName.lastIndexOf(".");
		String ext = oName.substring(index+1);
		
		String fileName = currentTime+"_"+r+"."+ext;
		
		File newFile = new File("c:/upload/"+fileName);
		
		try {
			tempfile.transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile.getPath();
	}
	
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());

	}
	
	@RequestMapping(value="/report/submitReport2", method=RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request,Model m) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		String path = request.getServletContext().getRealPath("/mainImg");
		try {
			report.transferTo(new File(path + "/" + report.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("path", report.getOriginalFilename());
		return "report/submissionComplete";
	}
	
	@RequestMapping(value = "/report/submitReport3", method=RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
	
	return "report/submissionComplete";
}
}
