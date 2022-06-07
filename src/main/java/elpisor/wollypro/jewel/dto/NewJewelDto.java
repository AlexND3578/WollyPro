package elpisor.wollypro.jewel.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewJewelDto {
	String title;
	String type;
	List<String> option;
	String seller;
	String description;
	BigDecimal price;
//	LocalDateTime date;
	List<String> urls;
}
