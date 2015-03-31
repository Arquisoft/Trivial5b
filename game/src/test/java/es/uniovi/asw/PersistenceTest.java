package es.uniovi.asw;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.extract.GIFTParser;
import es.uniovi.asw.infrastructure.Factories;
import es.uniovi.asw.model.Question;
import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.QuestionDAO;

public class PersistenceTest {

	@Test
	public void test() {
		List<Question> questions =  Factories.persistence.createQuestionDAO().getQuestions();
		assertNotNull(questions);
		List<User> users = Factories.persistence.createUserDAO().getUsers();
		assertNotNull(users);
	}
	
	@Test
	public void testGuardarPreguntas() throws IOException{
		/*GIFTParser gf = new GIFTParser();
		QuestionDAO qd= Factories.persistence.createQuestionDAO();
		List<Question> questions = gf.parserGIFT("files/questionsGIFT");
		for(Question q:questions)
			qd.save(q);*/
	}

}
