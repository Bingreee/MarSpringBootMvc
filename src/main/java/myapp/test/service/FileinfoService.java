package myapp.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.test.dao.FileinfoDao;
import myapp.test.vo.FileinfoDto;

@Service
public class FileinfoService {
	
	@Autowired
	FileinfoDao dao;
	
	public int insertFile(FileinfoDto file) {
		return dao.insertFile(file);
	}
	
	public List<FileinfoDto> fileList() {
		return dao.fileList();
	}
	
	public FileinfoDto fileOne(int fileid) {
		return dao.fileOne(fileid);
	}
}
