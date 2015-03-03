package es.uniovi.asw.trivial;

import java.io.IOException;
import java.util.Scanner;

import es.uniovi.asw.parsers.json.GIFTParser;
import es.uniovi.asw.parsers.xml.XMLParser;

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
		System.out.println("|        3. Salir         |");
		System.out.println("============================");
		opcion=scanner.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Option 1 selected"); 
			GIFTParser jsonParser = new GIFTParser();
			System.out.println("parsing...");
			jsonParser.parserGIFT();
			System.out.println("done!");
			break;
		case 2:
			System.out.println("Option 2 selected"); 
			XMLParser xmlParser = new XMLParser();
			xmlParser.parseXMLFile("Data/questions");
			break;
		}
	}
}
