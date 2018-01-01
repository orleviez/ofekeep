package entities;

import java.util.UUID;

import entities.Utilies.NoteType;

public class Note {
	
	private UUID _id;
	private String title;
	private String description;
	private String user;
	private NoteType noteType;
	
	public Note() {
		
	}
		
	public Note(UUID _id, String title, String description, String user, NoteType noteType) {
		this._id = _id;
		this.title = title;
		this.description = description;
		this.user = user;
		this.noteType = noteType;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public NoteType getNoteType() {
		return noteType;
	}


	public void setNoteType(NoteType noteType) {
		this.noteType = noteType;
	}


	public UUID get_id() {
		return _id;
	}

	public void set_id(UUID _id) {
		this._id = _id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
