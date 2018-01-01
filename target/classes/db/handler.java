package db;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import entities.Note;
import entities.User;
import entities.Utilies;

public class handler {

	
	public static void insertNote(Note note) {
		try {
			MongoClientURI connectionString = new MongoClientURI("mongodb+srv://Admin:Admin@cluster0-9b4qk.mongodb.net/test");
			MongoClient mongoClient = new MongoClient(connectionString);
			MongoDatabase db = mongoClient.getDatabase("ofekeep");
			MongoCollection<Document> notesCollection = db.getCollection("notes");
			Document document = new Document();
			document.append(Utilies.TITLE, note.getTitle());
			notesCollection.insertOne(document);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void removeNote() {
		
	}
	
	public void updateNote() {
		
	}
	
	public ArrayList<Note> getAllNotes(User user){
		
		return null;
	}
}
