package es.uniovi.asw.persistence;

public interface PersistenceFactory {

	QuestionDAO createQuestionDAO();
	
	UserDAO createUserDAO();
}
