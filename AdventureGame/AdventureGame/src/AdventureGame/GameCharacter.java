package AdventureGame;

public abstract class GameCharacter {
	private	int ID;
	private String name;
	private int damage;
	private int health;
	private int money;
	public GameCharacter(int ID,String name,int damage, int health, int money) {
		super();
		this.ID = ID;
		this.damage = damage;
		this.health = health;
		this.money = money;
		this.name = name;
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
	public void setID(int iD) {
		ID = iD;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
