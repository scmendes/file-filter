package br.com.involves.java.command;

import br.com.involves.java.repository.DataHolder;

public class CountAll implements Command {

	@Override
	public String execute(DataHolder data) throws Exception {
		return  data.getCities().size() + "";
	}

}
