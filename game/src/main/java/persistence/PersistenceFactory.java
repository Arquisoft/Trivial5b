package persistence;

public interface PersistenceFactory {

	QuestionDAO createQuestionDAO();
	
	UserDAO createUserDAO();
}
