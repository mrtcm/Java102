package AdventureGame;

public class Obstacle {
	private int id ;
	private int damage;
	private int healht;
	private String name;
	private int award;
	private  int defaultHealt;
	public Obstacle(String name,int id, int damage, int healht,int award) {
		super();
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.healht = healht;
		this.defaultHealt = healht;
		this.award = award;
	}
	
	
	public int getDefaultHealt() {
		return defaultHealt;
	}


	public void setDefaultHealt(int defaultHealt) {
		this.defaultHealt = defaultHealt;
	}


	public int getAward() {
		return award;
	}


	public void setAward(int award) {
		this.award = award;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealht() {
		return healht;
	}
	public void setHealht(int healht) {
		if (healht < 0 ) {
			healht = 0 ;
		}
		this.healht = healht;
	}
	
	
}
