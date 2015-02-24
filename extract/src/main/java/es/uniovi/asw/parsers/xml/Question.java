package es.uniovi.asw.parsers.xml;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String question;
	private String correctAnswer;
	private List<String> wrongAnswers;

	public Question(String question, String correctAnswer, String wrongansw1,
			String wrongansw2, String wrongansw3) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.wrongAnswers = new ArrayList<String>();
		wrongAnswers.add(wrongansw1);
		wrongAnswers.add(wrongansw2);
		wrongAnswers.add(wrongansw3);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<String> getWrongAnswers() {
		return wrongAnswers;
	}

	@Override
	public String toString() {
		return "Question [question=" + question + ", correctAnswer="
				+ correctAnswer + ", wrongAnswers=" + wrongAnswers + "]";
	}
	
	
}
