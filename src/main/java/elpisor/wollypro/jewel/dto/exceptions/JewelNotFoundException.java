package elpisor.wollypro.jewel.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "jewel not found")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class JewelNotFoundException extends RuntimeException {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1105671105671105677L;

	public JewelNotFoundException(String message) {
		super("Jewel with " + message + ", not found");
	}
}