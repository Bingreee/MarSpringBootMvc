package myapp.test.vo;
import lombok.Data;

@Data
public class NewArticleCommand {
	
	private String title;
	private String content;
	private int parentId;
}
