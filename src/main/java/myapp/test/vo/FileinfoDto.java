package myapp.test.vo;

import lombok.Data;

@Data
public class FileinfoDto {
	
	private int fileid;
	private String name;
	private String path;
	private long filesize;
	private String description;
}
