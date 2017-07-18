package br.com.involves.java.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.involves.java.entity.CityInfo;

public class CSVDataHolder implements DataHolder {

	private static final String FILE_NAME = "cidades.csv";

	private List<CityInfo> cities = new ArrayList<>();
	
	@Override
	public void loadData() throws Exception {
		try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {
			
			stream.forEach(item->{
				if (!item.equals(PROPERTIES)) {
					CityInfo city = new CityInfo(item);
					cities.add(city);
					System.out.println(city);
				} else {
					
				}
			});

			StringBuffer sb = new StringBuffer("Arquivo ").append(FILE_NAME).append(" carregado com ").
			append(cities.size()).append(" linhas");
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}        
	}
	
	@Override
	public List<CityInfo> getCities() {
		return cities;
	}

}
