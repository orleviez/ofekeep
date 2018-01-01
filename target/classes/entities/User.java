package entities;

import com.mongodb.DBObject;
import db.Utilities;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;

@Entity
public class User {
	@Id
	private String userName;
	private ArrayList<Note> notes;

	public User() {
		
	}

	/*
	public User (DBObject dbObject){
	    if (dbObject.containsField(Utilities.USER_NAME)) {
            this.userName = dbObject.(Utilities.USER_NAME);
        }
        if (dbObject.containsField(Utilities.NOTES)) {
            this.notes = dbObject.(Utilities.NOTES);
        }
	}
	*/
	

	public User(String userName, ArrayList<Note> notes) {
		this.userName = userName;
		this.notes = notes;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}
	
	
}
