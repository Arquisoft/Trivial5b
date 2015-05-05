package persistence.impl;

import persistence.PersistenceFactory;
import persistence.QuestionDAO;
import persistence.UserDAO;

public class SimplePersistenceFactory implements PersistenceFactory {

	public QuestionDAO createQuestionDAO() {
		return new QuestionJdbcDAO();
	}

	public UserDAO createUserDAO() {
		return new UserJdbcDAO();
	}

}
