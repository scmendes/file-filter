package br.com.involves.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.java.command.Command;
import br.com.involves.java.command.CommandFactory;
import br.com.involves.java.enumerator.DataHolderType;
import br.com.involves.java.repository.DataHolder;
import br.com.involves.java.repository.DataHolderFactory;

public class FileFilterTest {
	
	private DataHolder dataHolder = null;

	@Before
	public void setUpStreams() {

		try {
			DataHolderFactory factory = new DataHolderFactory();
			dataHolder = factory.getDataHolder(DataHolderType.CSV);
			dataHolder.loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCountAll() {
		
		try {
			String inputCommand = "count *";
			CommandFactory commandFactory = new CommandFactory();
			Command command = commandFactory.getCommand(inputCommand);
			String result = command.execute(dataHolder);
			
		    assertEquals("5565", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCountUf() {
		
		try {
			String inputCommand = "count distinct uf";
			CommandFactory commandFactory = new CommandFactory();
			Command command = commandFactory.getCommand(inputCommand);
			String result = command.execute(dataHolder);
			
		    assertEquals("27", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFilterByProperty() {
		
		try {
			String inputCommand = "filter name Franca";
			CommandFactory commandFactory = new CommandFactory();
			Command command = commandFactory.getCommand(inputCommand);
			String result = command.execute(dataHolder);
			
			StringBuffer sb = new StringBuffer().
					append(System.lineSeparator()).
					append("ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion").
					append(System.lineSeparator()).
					append("3516200,SP,Franca,,-47.4023316257,-20.536097,Franca,,Franca,Ribeirão Preto").
					append(System.lineSeparator());
			
		    assertEquals(sb.toString(), result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void cleanUpStreams() {
	}
	
}
