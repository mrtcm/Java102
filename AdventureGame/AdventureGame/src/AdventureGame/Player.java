package AdventureGame;

import java.util.Scanner;

public class Player {
	private int ID;
	private int damage;
	private int health;
	private int money;
	private String name;
	private String charName;
	private Inventory inventory;
	private int defaultHealth;
	
	private Scanner scn = new Scanner(System.in);
	
	public Player(String name) {
		super();
		this.name = name;
		this.inventory = new Inventory();
		this.defaultHealth = this.health;
	}
	
	public void printInfo() {
		System.out.println(
				"Silahınız : " + this.getInventory().getWeapon().getName()
				+" ,Zırhınız : "+ this.getInventory().getArmor().getName()
				+" ,Blok Değeri : " + this.getInventory().getArmor().getBlock()
				+" ,Hasarınız : "+ this.getTotalDamage()
				+" ,sağlık : "+ this.getHealth()
				+" ,Para : "+ this.getMoney());
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void selectChar() {
		GameCharacter[] characters = {new Archer(),new Samurai(),new Knight()};
		System.out.println("================================================");
		for (GameCharacter i : characters) {
			System.out.println("ID : "+i.getID()+" Karakter : "+i.getName() +" Hasar : "+i.getDamage()+" Sağlık : "+i.getHealth()+" Para : "+i.getMoney());
		}
		System.out.println("================================================");

		System.out.print("Lütfen Karakter Seçiniz : ");
		int selectNumber = scn.nextInt();
		
		switch (selectNumber) {
			case 2:
				initPlayer(new Samurai());
				break;
			case 1:
				initPlayer(new Archer());
				break;
			case 3:
				initPlayer(new Knight());
				break;
			default:
				initPlayer(new Samurai());
				break;
		}
		System.out.println("ID : "+this.getID()+" Karakter : "+this.getCharName() +" Hasar : "+this.getDamage()+" Sağlık : "+this.getHealth()+" Para : "+this.getMoney());

	}
	

	
	public void initPlayer(GameCharacter gameChar) {
		this.setDamage(gameChar.getDamage());  
		this.setHealth(gameChar.getHealth());
		this.setMoney(gameChar.getMoney());
		this.setDefaultHealth(gameChar.getHealth());
		this.setCharName(gameChar.getName());
		this.setID(gameChar.getID());
	}
	
	
	public int getDefaultHealth() {
		return defaultHealth;
	}

	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTotalDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
	}
	public int getDamage() {
		return damage ;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if (health< 0 ) {
			this.health = 0 ;
		}else {
			this.health = health;
		}
		
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}
	
	
	
	
	
	
}
