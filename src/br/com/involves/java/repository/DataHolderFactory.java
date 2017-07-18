package br.com.involves.java.repository;

import br.com.involves.java.enumerator.DataHolderType;

public class DataHolderFactory {
	
	
	public DataHolder getDataHolder(DataHolderType type) {
		if (type.equals(DataHolderType.CSV)) {
			return new CSVDataHolder();
		}
		return null;
	}

}
