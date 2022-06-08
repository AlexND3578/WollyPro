package elpisor.wollypro.jewel.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = { "id" })
public class Jewel {
	String id;
	@Setter
	String title;
	@Setter
	String type;
	Set<String> option;
	String seller;
	String description;
	@Setter
	BigDecimal price;
	LocalDateTime dateCreated = LocalDateTime.now();
	Set<String> urls;

	public boolean addOption(List<String> list) {
		Set<String> optionSet = new HashSet<>(list);
		return option.removeAll(optionSet);
	}

	public boolean addUrl(List<String> list) {
		Set<String> UrlsSet = new HashSet<>(list);
		return urls.addAll(UrlsSet);
	}

	public boolean deleteUrl(List<String> list) {
		Set<String> UrlsSet = new HashSet<>(list);
		return urls.removeAll(UrlsSet);
	}

	public boolean deleteOption(List<String> list) {
		Set<String> optionSet = new HashSet<>(list);
		return option.removeAll(optionSet);
	}
}
