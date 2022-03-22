package myapp.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DownloadController {
	
	@GetMapping("/download")
	public void fileDownload(HttpServletResponse response) throws IOException {
		File file = new File("c:\\upload\\1647933046580_1.txt");
		String fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
		response.setContentType("application/octet-stream; charset=utf-8"); //file데이터만 전송
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\";");//다운로드 받을 파일명 지정

		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream(); //OutputStream : 출력 스트림

														//InputStream : 입력 스트림
		try (FileInputStream fis = new FileInputStream(file);){
			FileCopyUtils.copy(fis, out);
		}
		out.flush();
	
	}
}
