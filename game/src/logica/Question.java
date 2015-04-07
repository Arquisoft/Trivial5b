package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import persistence.impl.QuestionJdbcDAO;

public class Question {

	private String id;
	private String category;
	private String text;
	private String correctAnswer;
	private List<String> wrongAnswers;

	public Question() {
		this.wrongAnswers = new ArrayList<String>();
	}

	public Question(String question, String correctansw, String wrongansw1,
			String wrongansw2, String category) {
		this.wrongAnswers = new ArrayList<String>();
		this.text = question;
		this.correctAnswer = correctansw;
		this.wrongAnswers.add(wrongansw1);
		this.wrongAnswers.add(wrongansw2);
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<String> getWrongAnswers() {
		return wrongAnswers;
	}

	@Override
	public String toString() {
		return "Question [category=" + category + ", text=" + text
				+ ", correctAnswer=" + correctAnswer + ", wrongAnswers="
				+ wrongAnswers + "]";
	}

	public Question getPregunta(int categoria) {
		QuestionJdbcDAO dao = new QuestionJdbcDAO();
		ArrayList<Question> lista = (ArrayList<Question>) dao.getQuestions();
		Random r;
		int valorDado;
		switch (categoria) {
		case 1:
			r = new Random();
			valorDado = r.nextInt(10)+24;
			return lista.get(valorDado);
		case 2:
			r = new Random();
			valorDado = r.nextInt(10);
			return lista.get(valorDado);
		case 3:
			r = new Random();
			valorDado = r.nextInt(11)+34;
			return lista.get(valorDado);
		case 4:
			r = new Random();
			valorDado = r.nextInt(14)+58;
			return lista.get(valorDado);
		}
		return null;
	}
}
