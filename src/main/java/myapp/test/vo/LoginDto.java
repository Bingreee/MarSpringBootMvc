package myapp.test.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginDto {

	@NotNull(message = "id is null.")
	@NotEmpty(message = "id is empty.")
	private String id;
	
	@NotNull(message = "pw is null.")
	@NotEmpty(message = "pw is empty.")
	private String pw;
}
