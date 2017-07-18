package br.com.involves.java.command;

import java.util.stream.Stream;

import br.com.involves.java.entity.CityInfo;
import br.com.involves.java.repository.DataHolder;

public class FilterByProperty implements Command {

	private String property;
	private String value;
	
	
	public FilterByProperty(String property, String value) {
		this.property = property;
		this.value = value;
	}

	@Override
	public String execute(DataHolder data) throws Exception {

        Stream<CityInfo> result = 
        		data.getCities().stream()
        		.filter((d) -> this.value.equals(d.getProperty(this.property)));
        
        StringBuffer sb = 
        		new StringBuffer().append(System.lineSeparator()).
        		append(DataHolder.PROPERTIES).append(System.lineSeparator());
        
        result.forEach(r ->  sb.append(r.toCsv()).append(System.lineSeparator()));
		
        return sb.toString();
	}

}
