package entities;

import java.util.ArrayList;

import entities.Utilies.NetworkType;

public class User {
	
	private NetworkType network;
	private String userName;
	private ArrayList<Note> notes;

	public User() {
		
	}
	
	
	public User(NetworkType network, String userName, ArrayList<Note> notes) {
		this.network = network;
		this.userName = userName;
		this.notes = notes;
	}
	
	
	public NetworkType getNetwork() {
		return network;
	}
	public void setNetwork(NetworkType network) {
		this.network = network;
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
