package br.com.involves.java;

import java.util.Scanner;

import br.com.involves.java.command.Command;
import br.com.involves.java.command.CommandFactory;
import br.com.involves.java.enumerator.DataHolderType;
import br.com.involves.java.repository.DataHolder;
import br.com.involves.java.repository.DataHolderFactory;

public class FileFilter {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		FileFilter fileFilter = new FileFilter();
		fileFilter.init();
	}
	
	public void init() {
		Scanner scan = null;

		try {
			
			DataHolderFactory factory = new DataHolderFactory();
			DataHolder dataHolder = factory.getDataHolder(DataHolderType.CSV);
			dataHolder.loadData();
			
			System.out.println("Entre com o comando ou digite " + EXIT_COMMAND + " para encerrar.");
			
			while (true) {

				scan = new Scanner(System.in);
				System.out.println(
						"Entre com o comando: count * | count distinct [propriedade] | filter [propriedade] [valor]  | exit");
				String inputCommand = scan.nextLine();

				if (inputCommand.length() == EXIT_COMMAND.length() && inputCommand.toLowerCase().equals(EXIT_COMMAND)) {
					System.out.println("Exiting.");
					return;
				}

				CommandFactory commandFactory = new CommandFactory();
				Command command = commandFactory.getCommand(inputCommand);
				
				if (command != null) {
					System.out.println("Comando selecionado=" + inputCommand);
					String result = command.execute(dataHolder);
					System.out.println("Resultado=" + result);
				} else {
					System.out.println("Invalido comando=" + inputCommand);
				}
			}

		} catch (Exception e) {
			System.err.println("Erro" + e);
		} finally {
			scan.close();
		}
	}

}
