package es.uniovi.asw.mongoDB;

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

import es.uniovi.asw.parsers.json.GIFTParser;
import es.uniovi.asw.util.Question;

public class Mongo {

	public static void main(String[] args) throws IOException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("mydb");
		DBCollection coll = db.getCollection("questionsCollection");
		mongoClient.setWriteConcern(WriteConcern.JOURNALED);
		GIFTParser p = new GIFTParser();
		BasicDBObject doc = null;
		for (Question q : p.parserGIFT("Data/questionsGIFT")) {
			doc = new BasicDBObject("category", q.getCategory())
					.append("question", q.getText())
					.append("correctanswer", q.getCorrectAnswer())
					.append("wrongAnswers",q.getWrongAnswers());
			coll.insert(doc);
		}

		DBCursor cursor = coll.find();
		try {
			   while(cursor.hasNext()) {
			       System.out.println(cursor.next());
			   }
			} finally {
			   cursor.close();
			}
	}
}
