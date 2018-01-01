package ofek.ofekKeep;

import java.util.ArrayList;
import java.util.UUID;

import db.DBhandler;
import db.Utilities;
import entities.Note;
import entities.NoteType;
import entities.User;
import db.Utilities;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		UUID id = UUID.randomUUID();
		Note note = new Note(id, "test", "test", "Elhen15", NoteType.text);
//    	Note note = null;
		DBhandler dBhandler = new DBhandler();
		dBhandler.insertNote(note);
		ArrayList<Note> notes = new ArrayList<Note>();
		notes.add(note);
		User user = new User("Elhen15", notes);
		dBhandler.insertUser(user);
		dBhandler.getAllNotes(user.getUserName());
		System.out.println(System.getProperty("user.name"));
    	System.out.println(System.getProperty("user"));

    }
}
