package es.uniovi.asw.trivial;

import java.io.IOException;
import java.util.Scanner;

import es.uniovi.asw.parsers.json.GIFTParser;
import es.uniovi.asw.parsers.xml.XMLParser;
import es.uniovi.asw.util.Question;

import org.w3c.dom.Document;

import com.google.gson.Gson;

public class MenuOptions {

	int opcion;
	Scanner scanner = new Scanner(System.in);

	public void start() throws IOException {
		System.out.println("============================");
		System.out.println("|   SELECCIONE UNAOPCION   |");
		System.out.println("============================");
		System.out.println("| Options:                 |");
		System.out.println("|        1. GIFT-JSON      |");
		System.out.println("|        2. XML-JSON       |");
		System.out.println("|        3. Salir          |");
		System.out.println("============================");
		System.out.print("Escoja una de las acciones disponibles:");
		opcion = scanner.nextInt();
		while (opcion != 3) {
			switch (opcion) {
			case 1:
				System.out.println("Option 1 selected");
				GIFTParser jsonParser = new GIFTParser();
				System.out.println("Resultado de parsear las preguntas en formato GIFT");
				for(Question q:jsonParser.parserGIFT("Data/questionsGIFT")){
					Gson gson = new Gson();
					String representacionJSON = gson.toJson(q);
					System.out.println(representacionJSON);
				}
				break;
			case 2:
				System.out.println("Option 2 selected");
				XMLParser xmlParser = new XMLParser();
				System.out.println("Resultado de parsear las preguntas en formato XML");
				Document doc = xmlParser.parseXMLFile("Data/questionsXML.xml");
				for(Question q:xmlParser.parseDocument(doc)){
					Gson gson = new Gson();
				String representacionJSON = gson.toJson(q);
				System.out.println(representacionJSON);
				}
				break;
			}
			System.out.println("============================");
			System.out.println("|   ACCIONES DISPONIBLES   |");
			System.out.println("============================");
			System.out.println("| Options:                 |");
			System.out.println("|        1. GIFT-JSON      |");
			System.out.println("|        2. XML-JSON       |");
			System.out.println("|        3. Salir          |");
			System.out.println("============================");
			System.out.print("Escoja una de las acciones disponibles:");
			opcion = scanner.nextInt();
		}
		System.out.println("Simulaci�n finalizada");
	}
}
