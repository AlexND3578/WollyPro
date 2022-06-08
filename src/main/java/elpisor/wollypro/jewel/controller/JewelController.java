package elpisor.wollypro.jewel.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import elpisor.wollypro.jewel.dto.DatePeriodDto;
import elpisor.wollypro.jewel.dto.JewelDto;
import elpisor.wollypro.jewel.dto.JewelPicDto;
import elpisor.wollypro.jewel.dto.NewJewelDto;
import elpisor.wollypro.jewel.dto.PriceRangeDto;
import elpisor.wollypro.jewel.dto.UpdatePriceDto;
import elpisor.wollypro.jewel.dto.UpdateTitleDto;
import elpisor.wollypro.jewel.service.JewelService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
//@RequestMapping("/localhost:8080")
public class JewelController {

	JewelService jewelService;
	
	@PostMapping("/jewel")
	public JewelDto addJewel(@RequestBody NewJewelDto newJewel) {
		return jewelService.addJewel(newJewel);
	}
	
	@PostMapping("/jewel/{id}/urls/newPicture")
	public JewelDto addJewelPic(@PathVariable String id, @RequestBody JewelPicDto jewelPicDto) {
		return jewelService.addPicture(id, jewelPicDto);
	}
	
	@DeleteMapping("/jewel/{id}/urls/deletePicture")
	public JewelDto deleteJewelPic(@PathVariable String id, @RequestBody JewelPicDto jewelPicDto) {
		return jewelService.deletePicture(id, jewelPicDto);
	}
	
	@DeleteMapping("/jewel/{id}")
	public JewelDto deleteJewel(@PathVariable String id) {
		return jewelService.deleteJewel(id);
	}
	
	@GetMapping("/jewel/{id}")
	public JewelDto FindJewel(@PathVariable String id) {
		return jewelService.FindeJewelById(id);
	}
	
	@GetMapping("/jewels/title/{title}")
	public JewelDto FindeJewelByTitle(@PathVariable String title) {
		return jewelService.FindeJewelByTitle(title);
	}

	@GetMapping("/jewels/type/{type}")
	public Iterable<JewelDto> FindeJewelByType(@PathVariable String type) {
		return jewelService.FindeJewelByType(type);
	}
	
	@GetMapping("/jewels/seller/{seller}")
	public Iterable<JewelDto> FindeJewelBySeller(@PathVariable String seller) {
		return jewelService.FindeJewelBySeller(seller);
	}
	
	@GetMapping("/jewels/price/price_between")
	public Iterable<JewelDto> FindeJewelByPrice(@RequestBody PriceRangeDto priceRangeDto) {
		return jewelService.FindeJewelByPrice(priceRangeDto);
	}
	
	@GetMapping("/jewels/{date_from}/{date_to}")
	public Iterable<JewelDto> FindeJewelByDate(@RequestBody DatePeriodDto datePeriodDto) {
		return jewelService.FindeJewelByDate(datePeriodDto);
	}
	
	@PutMapping("/jewel/{id}/title/newTitle")
	public JewelDto UpdateJewelTitle(@PathVariable String id, @RequestBody UpdateTitleDto updateTitleDto) {
		return jewelService.UpdateJewelTitle(id, updateTitleDto);
	}
	
	@PutMapping("/jewel/{id}/price/newPrice")
	public JewelDto UpdateJewelPrice(@PathVariable String id, @RequestBody UpdatePriceDto updatePriceDto) {
		return jewelService.UpdateJewelPrice(id, updatePriceDto);
	}
}
