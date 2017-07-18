package br.com.involves.java.entity;

import br.com.involves.java.enumerator.PropertyType;

public class CityInfo {

	public CityInfo(String csvInfo) {
		
		String[] info = csvInfo.split(",");
		
		this.ibgeId = info[0];
		this.uf = info[1];
		this.name = info[2];
		this.capital = info[3];
		this.lon = info[4];
		this.lat = info[5];
		this.noAccents = info[6];
		this.alternativeNames = info[7];
		this.microRegion = info[8];
		this.mesoRegion = info[9];
	}
	
	@Override
	public String toString() {
		return "CityInfo [ibgeId=" + ibgeId + ", uf=" + uf + ", name=" + name + ", capital=" + capital + ", lon=" + lon
				+ ", lat=" + lat + ", noAccents=" + noAccents + ", alternativeNames=" + alternativeNames
				+ ", microRegion=" + microRegion + ", mesoRegion=" + mesoRegion + "]";
	}


	public String toCsv() {
		
		StringBuffer sb = 
				new StringBuffer().
				append(ibgeId).append(",").
				append(uf).append(",").
				append(name).append(",").
				append(capital).append(",").
				append(lon).append(",").
				append(lat).append(",").
				append(noAccents).append(",").
				append(alternativeNames).append(",").
				append(microRegion).append(",").
				append(mesoRegion);
		return sb.toString();
	}

	//	ibge_id
	private String ibgeId;
	
	//	,uf
	private String uf;

	//	,name
	private String name;

	//	,capital
	private String capital;

	//	,lon
	private String lon;

	//	,lat
	private String lat;

	//	,no_accents
	private String noAccents;

	//	,alternative_names
	private String alternativeNames;

	//	,microregion
	private String microRegion;
	
	//	,mesoregion
	private String mesoRegion;

	public String getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public String getMicroRegion() {
		return microRegion;
	}

	public void setMicroRegion(String microRegion) {
		this.microRegion = microRegion;
	}

	public String getMesoRegion() {
		return mesoRegion;
	}

	public void setMesoRegion(String mesoRegion) {
		this.mesoRegion = mesoRegion;
	}
	
	public String getProperty(String property) {
	
		if (property.equals(PropertyType.IBGE_ID.getLabel())) {
			return getIbgeId();
		} else if (property.equals(PropertyType.UF.getLabel())) {
			return getUf();
		} else if (property.equals(PropertyType.NAME.getLabel())) {
			return getName();
		} else if (property.equals(PropertyType.CAPITAL.getLabel())) {
			return getCapital();
		} else if (property.equals(PropertyType.LONG.getLabel())) {
			return getLon();
		} else if (property.equals(PropertyType.LAT.getLabel())) {
			return getLat();
		} else if (property.equals(PropertyType.NO_ACCENTS.getLabel())) {
			return getNoAccents();
		} else if (property.equals(PropertyType.ALTERNATIVE_NAMES.getLabel())) {
			return getAlternativeNames();
		} else if (property.equals(PropertyType.MICRO_REGION.getLabel())) {
			return getMicroRegion();
		} else if (property.equals(PropertyType.MESO_REGION.getLabel())) {
			return getMesoRegion();
		}
		return null;
	}
	

}
