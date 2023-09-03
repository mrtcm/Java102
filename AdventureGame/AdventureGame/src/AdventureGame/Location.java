package AdventureGame;

import java.util.Scanner;

public abstract class Location {
	private Player player ;
	private String name;
	private int ID; 
	public static Scanner scn = new Scanner(System.in);
	public Location(Player player, String name,int ID) {
		super();
		this.player = player;
		this.name = name;
		this.ID  = ID;
	}
	
	public abstract boolean onLocation();
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	
	
	
}
