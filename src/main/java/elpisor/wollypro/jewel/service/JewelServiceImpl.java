package elpisor.wollypro.jewel.service;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import elpisor.wollypro.jewel.dao.JewelRepository;
import elpisor.wollypro.jewel.dto.DatePeriodDto;
import elpisor.wollypro.jewel.dto.JewelDto;
import elpisor.wollypro.jewel.dto.JewelPicDto;
import elpisor.wollypro.jewel.dto.NewJewelDto;
import elpisor.wollypro.jewel.dto.PriceRangeDto;
import elpisor.wollypro.jewel.dto.UpdatePriceDto;
import elpisor.wollypro.jewel.dto.UpdateTitleDto;
import elpisor.wollypro.jewel.dto.exceptions.JewelNotFoundException;
import elpisor.wollypro.jewel.model.Jewel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JewelServiceImpl implements JewelService {

	JewelRepository jewelRepository;
	ModelMapper modelMapper;

	@Override
	public JewelDto addJewel(NewJewelDto NewJewel) {
		Jewel jewel = modelMapper.map(NewJewel, Jewel.class);
		jewelRepository.save(jewel);
		return modelMapper.map(jewel, JewelDto.class);
	}

	@Override
	public JewelDto addPicture(String id, JewelPicDto jewelPicDto) {
		Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
		jewel.addUrl(jewelPicDto.getUrls());
		jewelRepository.save(jewel);
		return modelMapper.map(jewel, JewelDto.class);
	}

	@Override
	public JewelDto deletePicture(String id, JewelPicDto jewelPicDto) {
		Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
		jewel.deleteUrl(jewelPicDto.getUrls());
		jewelRepository.save(jewel);
		return modelMapper.map(jewel, JewelDto.class);
	}

	@Override
	public JewelDto deleteJewel(String id) {
		Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
		jewelRepository.deleteById(id);
		return modelMapper.map(jewel, JewelDto.class);
	}

	@Override
	public JewelDto FindeJewelById(String id) {
		Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
		return modelMapper.map(jewel, JewelDto.class);
	}

	@Override
	public JewelDto FindeJewelByTitle(String title) {
		JewelDto jewelDto = jewelRepository.findByTitleIgnoreCase(title);
		if(jewelDto == null) {
			throw new JewelNotFoundException("title: " + title);
		}
		return jewelDto;
	}

	@Override
	public Iterable<JewelDto> FindeJewelByType(String type) {
		Iterable<JewelDto> jewelsDto = jewelRepository.findByTypeIgnoreCase(type);
//		if(jewelsDto != null) {
//			throw new JewelNotFoundException("type: " + type);
//		}
		return jewelsDto;
	}

	@Override
	public Iterable<JewelDto> FindeJewelBySeller(String seller) {
		return jewelRepository.findBySellerIgnoreCase(seller);
	}

	@Override
	public Iterable<JewelDto> FindeJewelByPrice(PriceRangeDto priceRangeDto) {
		return jewelRepository.findByPriceBetween(priceRangeDto.getPriceFrom(), priceRangeDto.getPriceTo());
	}

	@Override
	public Iterable<JewelDto> FindeJewelByDate(DatePeriodDto datePeriodDto) {
		return jewelRepository.findByDateCreatedBetween(datePeriodDto.getDateFrom(), datePeriodDto.getDateTo());
	}

	@Override
	public JewelDto UpdateJewelTitle(String id, UpdateTitleDto updateTitleDto) {
		Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
		String newTitle = updateTitleDto.getTitle();
		if (newTitle != null) {
			jewel.setTitle(newTitle);
		}
		jewel = jewelRepository.save(jewel);
		return modelMapper.map(jewel, JewelDto.class);
	}

	@Override
	public JewelDto UpdateJewelPrice(String id, UpdatePriceDto updatePriceDto) {
		Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
		BigDecimal newPrice = updatePriceDto.getPrice();
		if (newPrice != null) {
			jewel.setPrice(newPrice);
		}
		jewel = jewelRepository.save(jewel);
		return modelMapper.map(jewel, JewelDto.class);
	}

}
