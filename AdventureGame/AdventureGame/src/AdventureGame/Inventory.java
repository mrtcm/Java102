package AdventureGame;

public class Inventory {
	private Weapon weapon;
	private Armor armor ;
	private boolean firewood;
	private boolean water;
	private boolean food;

	
	public Inventory() {
		this.weapon  = new Weapon("Yumruk", -1, 0, 0);
		this.armor = new Armor(-1,0,0,"Paçavra");
		this.firewood = false;
		this.food =false;
		this.water = false;
		
		
	}
	

	


	public boolean getFirewood() {
		return firewood;
	}
	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}

	public boolean getWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean getFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public Armor getArmor() {
		return armor;
	}


	public void setArmor(Armor armor) {
		this.armor = armor;
	}


	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
	

}
