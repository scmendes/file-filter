package br.com.involves.java.command;

import java.util.Arrays;

import br.com.involves.java.repository.DataHolder;

public class CommandFactory {
	
	private static final String COUNT_All = "count *";
	private static final String COUNT_DISTINCT = "count distinct";
	private static final String FILTER = "filter ";

	public Command getCommand(final String inputCommand) {
		if (inputCommand.equals(COUNT_All)) {
			return getCountAll();
		} else if (inputCommand.startsWith(COUNT_DISTINCT)) {
			return getCountDistinct(inputCommand);
		} else if (inputCommand.startsWith(FILTER)) {
			return getFilterByProperty(inputCommand);
		}
		return null;
	}
	
	private Command getCountAll() {
		return new CountAll();
	}
		
	private Command getCountDistinct(final String inputCommand) {
		
		String[] parts = inputCommand.split(" ");
		if (parts == null || parts.length < 3) {
			return null;
		}
		
		String property = parts[2];
		if (Arrays.asList(DataHolder.PROPERTIES.split(",")).contains(property)){
			return new CountDistinct(property);
		}
		
		return null;
	}
	
	private Command getFilterByProperty(final String inputCommand) {
		
		String[] parts = inputCommand.split(" ");
		if (parts == null || parts.length < 3) {
			return null;
		}
		
		String property = parts[1];
		String value = parts[2];
		if (Arrays.asList(DataHolder.PROPERTIES.split(",")).contains(property)){
			return new FilterByProperty(property, value);
		}
		return null;
	}
	
}
