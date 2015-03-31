package es.uniovi.asw.persistence.impl;

import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.QuestionDAO;
import es.uniovi.asw.persistence.UserDAO;

public class SimplePersistenceFactory implements PersistenceFactory {

	public QuestionDAO createQuestionDAO() {
		return new QuestionJdbcDAO();
	}

	public UserDAO createUserDAO() {
		return new UserJdbcDAO();
	}

}
