package elpisor.wollypro.jewel.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import elpisor.wollypro.jewel.dto.JewelDto;
import elpisor.wollypro.jewel.model.Jewel;

public interface JewelRepository extends MongoRepository<Jewel, String>{

	JewelDto findByTitleIgnoreCase(String title);

	Iterable<JewelDto> findByTypeIgnoreCase(String type);

	Iterable<JewelDto> findBySellerIgnoreCase(String seller);
	
	Iterable<JewelDto> findByPriceBetween(BigDecimal fromPrice, BigDecimal toPrice);
	
	Iterable<JewelDto> findByDateCreatedBetween(LocalDate dateFrom, LocalDate dateTo);
	
}
