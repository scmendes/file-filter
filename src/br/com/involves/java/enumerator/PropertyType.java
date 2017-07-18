package br.com.involves.java.enumerator;

public enum PropertyType {
	
	IBGE_ID("ibge_id"),
	UF("uf"),
	NAME("name"),
	CAPITAL("capital"),
	LONG("lon"),
	LAT("lat"),
	NO_ACCENTS("no_accents"),
	ALTERNATIVE_NAMES("alternative_names"),
	MICRO_REGION("microregion"),
	MESO_REGION("mesoregion");
	
	private String label;

	private PropertyType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}	
	
}
