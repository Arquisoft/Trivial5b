package es.uniovi.asw.parsers.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import es.uniovi.asw.util.Question;

public class XMLParser {

	
	public static void main(String[] args){
		XMLParser p = new XMLParser();
		Document doc = p.parseXMLFile("Data/questionsXML.xml");
		List<Question> list = p.parseDocument(doc);
		System.out.println("No of Questions '" + list.size() + "'.");
		for(Question e:list) 
			System.out.println(e.toString());
		
	}
	
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

				//get the employee element
				Element el = (Element)nl.item(i);

				//get the Employee object
				Question e = getQuestion(el);

				//add it to list
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
		
		//Creamos un nuevo objeto question
		Question q = new Question(question,correctansw,wrongansw1,wrongansw2);
		
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


	/**
	 * Calls getTextValue and returns a int value
	 */
	private int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}
}
