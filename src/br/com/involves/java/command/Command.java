package br.com.involves.java.command;

import br.com.involves.java.repository.DataHolder;

public interface Command {
	
	String execute(DataHolder data) throws Exception;
	
}
