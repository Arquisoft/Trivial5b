package es.uniovi.asw.extract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import es.uniovi.asw.model.Question;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	public Document parseXMLFile(String file){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document dom;
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(file);
			return dom;
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}catch(SAXException se){
			se.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return null;
	}
	
	public List<Question> parseDocument(Document doc){
		Element ele =  doc.getDocumentElement();
		List<Question> myquestions = new ArrayList<Question>();
		NodeList nl = ele.getElementsByTagName("Element");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				Element el = (Element)nl.item(i);
				Question e = getQuestion(el);
				myquestions.add(e);
			}
		}
		return myquestions;
	}
	
	private Question getQuestion(Element questEl){
		//Recuperamos el valor de los tags que nos interesan dentro del fichero xml.
		String question = getTextValue(questEl,"question");
		String correctansw = getTextValue(questEl,"correctansw");
		String wrongansw1 = getTextValue(questEl,"wrongansw1");
		String wrongansw2 = getTextValue(questEl,"wrongansw2");
		String category = getTextValue(questEl,"category");
		
		//Creamos un nuevo objeto question
		Question q = new Question(question,correctansw,wrongansw1,wrongansw2,category);
		
		return q;
	}
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}
}
