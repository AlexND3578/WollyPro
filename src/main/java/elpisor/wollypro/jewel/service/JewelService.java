package elpisor.wollypro.jewel.service;

import java.util.List;

import elpisor.wollypro.jewel.dto.DatePeriodDto;
import elpisor.wollypro.jewel.dto.JewelDto;
import elpisor.wollypro.jewel.dto.NewJewelDto;
import elpisor.wollypro.jewel.dto.PriceRangeDto;
import elpisor.wollypro.jewel.dto.UpdatePriceDto;
import elpisor.wollypro.jewel.dto.UpdateTitleDto;

public interface JewelService {
	JewelDto addJewel(NewJewelDto newJewel);
	
	JewelDto addPicture(String id, List<String> urls);
	
	JewelDto deletePicture(String id, List<String> urls);
	
	JewelDto deleteJewel(String id);
	
	JewelDto FindeJewelById(String id);
	
	JewelDto FindeJewelByTitle(String title);
	
	Iterable<JewelDto> FindeJewelByType(String type);
	
	Iterable<JewelDto> FindeJewelBySeller(String seller);
	
	Iterable<JewelDto> FindeJewelByPrice(PriceRangeDto priceRangeDto);
	
	Iterable<JewelDto> FindeJewelByDate(DatePeriodDto datePeriodDto);
	
	JewelDto UpdateJewelTitle(String id, UpdateTitleDto updateTitleDto);
	
	JewelDto UpdateJewelPrice(String id, UpdatePriceDto updatePriceDto);
	
}
