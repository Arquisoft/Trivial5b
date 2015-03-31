package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Question;

public interface QuestionDAO {

	List<Question> getQuestions();
	
	void save(Question questions);
	
	void remove(long id);
	
	void update(Question question);
	
}
