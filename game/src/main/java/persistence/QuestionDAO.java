package persistence;

import java.util.List;

import logica.Question;

public interface QuestionDAO {

	List<Question> getQuestions();
	
	void save(Question questions);
	
	void remove(long id);
	
	void update(Question question);
	
}
