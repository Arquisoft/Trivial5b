package es.uniovi.asw.trivial;

import java.io.IOException;
import java.util.Scanner;

import es.uniovi.asw.parsers.json.Proof;
import es.uniovi.asw.parsers.xml.Parser;

public class MenuOptions {

	int opcion;
	Scanner scanner = new Scanner (System.in);

	public void start() throws IOException {
		System.out.println("============================");
		System.out.println("|   SELECCIONE UNAOPCION   |");
		System.out.println("============================");
		System.out.println("| Options:                 |");
		System.out.println("|        1. GIFT-JSON      |");
		System.out.println("|        2. XML-JSON       |");
		System.out.println("|        3. Exit           |");
		System.out.println("============================");
		opcion=scanner.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Option 1 selected"); // This is where I want to
														// call the class
			Proof jsonParser = new Proof();
			System.out.println("parsing...");
			jsonParser.parserGIFT();
			System.out.println("done!");
			break;
		case 2:
			System.out.println("Option 2 selected"); // this is where I want to
														// call the class
			Parser xmlParser = new Parser();
			xmlParser.parseXMLFile("Data/questions");
			break;
		}
	}
}
