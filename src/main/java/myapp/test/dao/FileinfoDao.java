package myapp.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myapp.test.vo.FileinfoDto;

@Mapper
public interface FileinfoDao {
	int insertFile(FileinfoDto file);
	List<FileinfoDto>  fileList();
	FileinfoDto fileOne(int fileid);
}