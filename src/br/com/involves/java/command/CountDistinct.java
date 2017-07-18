package br.com.involves.java.command;

import java.util.Map;
import java.util.stream.Collectors;

import br.com.involves.java.repository.DataHolder;

public class CountDistinct implements Command {

	private String property;
	
	public CountDistinct(String property) {
		this.property = property;
	}

	@Override
	public String execute(DataHolder data) throws Exception {
		Map<String, String> items = data.getCities().stream().distinct()
		.collect(Collectors.toMap(x -> x.getProperty(property), x -> x.getProperty(property), 
				(oldValue, newValue) -> oldValue));
		return items.size() + "";
	}

}
