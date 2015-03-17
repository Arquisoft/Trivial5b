package es.uniovi.asw.trivial;

import java.io.IOException;

import org.w3c.dom.Document;

import com.google.gson.Gson;

import es.uniovi.asw.parsers.json.GIFTParser;
import es.uniovi.asw.parsers.xml.XMLParser;
import es.uniovi.asw.util.Question;

public class Extractor {
	
	public void usage() throws IOException {
		System.out.println("Wellcome to Trivial Extractor");

		System.out.println("Resultado de parsear las preguntas en formato GIFT");
		GIFTParser jsonParser = new GIFTParser();
		for(Question q:jsonParser.parserGIFT("Data/questionsGIFT")){
			Gson gson = new Gson();
			String representacionJSON = gson.toJson(q);
			System.out.println(representacionJSON);
		}
		
		XMLParser xmlParser = new XMLParser();
		System.out.println("Resultado de parsear las preguntas en formato XML");
		Document doc = xmlParser.parseXMLFile("Data/questionsXML.xml");
		for(Question q:xmlParser.parseDocument(doc)){
			Gson gson = new Gson();
		String representacionJSON = gson.toJson(q);
		System.out.println(representacionJSON);
		}
		
	}
	public int run(String[] args) throws IOException {
		if (args.length == 0) {
			usage();
			return 0;
		}
		return -1 ;
	}
	
	public static void main(String[] args) throws IOException {
        new Extractor().run(args);
    }	
}
