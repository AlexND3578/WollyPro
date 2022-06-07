package elpisor.wollypro.jewel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Setter
public class JewelDto {
	String id;
	String title;
	String type;
	@Singular
	List<String> option;
	String seller;
	String description;
	BigDecimal price;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime dateCreated;
	@Singular
	List<String> urls;
}
