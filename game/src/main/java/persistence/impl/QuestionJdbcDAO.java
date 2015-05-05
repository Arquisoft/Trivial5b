package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import logica.Question;
import persistence.Jdbc;
import persistence.QuestionDAO;

public class QuestionJdbcDAO implements QuestionDAO {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;

	public ArrayList<Question> getQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
			con = Jdbc.getConnection();
			ps = con.prepareStatement("select * from tquestion");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Question question = new Question();
				question.setCorrectAnswer(rs.getString("CORRECTANSWER"));
				question.setText(rs.getString("QUESTION"));
				question.getWrongAnswers().add(rs.getString("WRONGANSWER1"));
				question.getWrongAnswers().add(rs.getString("WRONGANSWER2"));
				question.setCategory(rs.getString("CATEGORY"));
				questions.add(question);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null && rs != null)
				Jdbc.close(rs, ps);
			if (con != null)
				Jdbc.close(con);
		}
		return questions;
	}

	public ArrayList<Question> getQuestionByCategoria(String categoria) {
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
			con = Jdbc.getConnection();
			ps = con.prepareStatement("select * from tquestion where CATEGORY = ?");
			ps.setString(1, categoria);
			rs = ps.executeQuery();

			while (rs.next()) {
				Question question = new Question();
				question.setCorrectAnswer(rs.getString("CORRECTANSWER"));
				question.setText(rs.getString("QUESTION"));
				question.getWrongAnswers().add(rs.getString("WRONGANSWER1"));
				question.getWrongAnswers().add(rs.getString("WRONGANSWER2"));
				question.setCategory(rs.getString("CATEGORY"));
				questions.add(question);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null && rs != null)
				Jdbc.close(rs, ps);
			if (con != null)
				Jdbc.close(con);
		}
		return questions;
	}

	public void save(Question question) {
		try {
			con = Jdbc.getConnection();
			ps = con.prepareStatement("insert into tquestion (question,correctanswer,wronganswer1,wronganswer2,category)"
					+ "values (?,?,?,?,?)");

			ps.setString(1, question.getText());
			ps.setString(2, question.getCorrectAnswer());
			ps.setString(3, question.getWrongAnswers().get(0));
			ps.setString(4, question.getWrongAnswers().get(1));
			ps.setString(5, question.getCategory());

			ps.executeUpdate();
			/*
			 * int rows = ps.executeUpdate(); if(rows != 1) throw new
			 * Exception("");
			 */
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null && rs != null)
				Jdbc.close(rs, ps);
			if (con != null)
				Jdbc.close(con);
		}
	}

	public void remove(long id) {
		try {

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(Question question) {
		try {

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
