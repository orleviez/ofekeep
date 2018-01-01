package db;

import java.util.ArrayList;

import com.mongodb.*;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBCollection;

import entities.Note;
import entities.User;

public class DBhandler {
	
	private MongoClientURI connectionString = null;
	private MongoClient mongoClient = null;
	private MongoDatabase db = null;


	public DBhandler()
	{
		if (db == null) {
			
			connectionString= new  MongoClientURI("mongodb+srv://Admin:Admin@cluster0-9b4qk.mongodb.net/test");
			mongoClient = new MongoClient(connectionString);
			db = mongoClient.getDatabase("test");
		}
	}
	
	public void insertNote(Note note) {
		try {	
			MongoCollection<Document> notesCollection = this.db.getCollection("notes");
			Document document = new Document();
			document.append(Utilities.UUID, note.get_id());
			document.append(Utilities.USER_NAME, note.getUser());
			document.append(Utilities.DESCRIPTION, note.getDescription());
			document.append(Utilities.DATE, note.getDate().toString());
			document.append(Utilities.TITLE, note.getTitle());
			document.append(Utilities.IS_DELETED, note.isDeleted());
			notesCollection.insertOne(document);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

    public boolean isUserExist(String userName){
        DBObject query = new BasicDBObject(Utilities.USER_NAME, userName);
        DB database = mongoClient.getDB("test");
        DBCollection userCollection = database.getCollection("users");
        DBCursor cursor = userCollection.find(query);
        return cursor.hasNext();
    }


    public void insertUser(User user) {
        try {
            if (isUserExist(user.getUserName())){
                return;
            }
            MongoCollection<Document> usersCollection = this.db.getCollection("users");
            Document document = new Document();
            document.append(Utilities.USER_NAME, user.getUserName());
            document.append(Utilities.NOTES, user.getNotes());
            usersCollection.insertOne(document);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	public void updateNote(Note note, Note oldNote) {
		MongoCollection<Document> notesCollection = this.db.getCollection("notes");
		Document document = new Document();
	}
	
	public void removeNote() {
		
	}
	
	public void updateNote() {
		
	}
	
	public ArrayList<Note> getAllNotes(String userName) {
        DBObject query = new BasicDBObject(Utilities.USER_NAME, userName);
        DB database = mongoClient.getDB("test");
        DBCollection userCollection = database.getCollection("users");
        DBCursor cursor = userCollection.find(query);
        DBObject userBasic = cursor.next();
        User user = (User) userBasic.removeField("_id");
		ArrayList<Note> notes = user.getNotes();
		/*int index = 0;
        DBCollection notesCollection = database.getCollection("notes");
        ArrayList<Note> notes = new ArrayList<Note>();
        for (index = 0; index < notes.size(); index++){
            DBObject query = new BasicDBObject(Utilities.UUID, notes.get(index));
            DBCursor cursor = userCollection.find(query);
            Note note = (Note) cursor.next();
            notes.add(note);
        }
        */
        System.out.println(notes);
        return notes;
	}
}
