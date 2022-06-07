package elpisor.wollypro.jewel.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class PriceRangeDto {
	BigDecimal priceFrom;
	BigDecimal priceTo;
}
