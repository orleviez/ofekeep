package ofek.keep;

import java.util.UUID;

import entities.Note;
import entities.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UUID id = UUID.randomUUID();
    	Note note = new Note(id, "test", "test", "Elhen15", entities.Utilies.NoteType.text);
    	db.handler.insertNote(note);
        System.out.println( System.getProperty("user.name"));
    }
}
