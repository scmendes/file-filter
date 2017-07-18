package br.com.involves.java.repository;

import java.util.List;

import br.com.involves.java.entity.CityInfo;

public interface DataHolder {
	
	final String PROPERTIES = "ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion";
	
	void loadData() throws Exception;
	
	List<CityInfo> getCities();

}
