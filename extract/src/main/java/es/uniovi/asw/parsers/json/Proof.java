package es.uniovi.asw.parsers.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Proof {

	public static void main(String[] args) throws IOException {

		Proof p = new Proof();
		for(Question q:p.parserGIFT())
			System.out.println(q);
	}
	
	public List<Question> parserGIFT() throws IOException{
		List<String> lines = leerFichero("Data/questions");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		String aux = "";
		double cont = 0;
		int acum = 0;
		for(String line:lines){
			if(line.startsWith("$")){
				question.setCategory(line.substring(10));
			}else if(line.startsWith("::")){
				aux = line.substring(3,4+acum);
				question.setId(aux);
				aux = line.substring(7+acum);
				aux = aux.substring(0,aux.length()-1);
				question.setText(aux);
			}else if(line.startsWith("=")){
				question.setCorrectAnswer(line.substring(1));
			}else if(line.startsWith("~")){
				question.getWrongAnswers().add(line.substring(1));
			}else if(line.startsWith("}")){
				questions.add(question);
				question = new Question();
				cont++;
				if(cont/10==1.0|cont/100==1.0|cont/1000==1.0|cont/10000==1.0)
					acum++;
			}
		}
		return questions;
	}
	
	private List<String> leerFichero(String file) throws IOException{
		List<String> lines = new ArrayList<String>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine())!=null)
				lines.add(line);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return lines;
	}
	
	

}
