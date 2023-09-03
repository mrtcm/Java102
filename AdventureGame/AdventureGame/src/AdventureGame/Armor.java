package AdventureGame;

public class Armor {
	private int id ;
	private int block;
	private int price;
	private String name;
	public Armor(int id, int block, int price, String name) {
		super();
		this.id = id;
		this.block = block;
		this.price = price;
		this.name = name;
	}
	
	public static Armor[] armors() {
		Armor[] armorList = { new Armor(1,1,15,"Hafif"),new Armor(2,3,25,"Orta"),new Armor(3,5,48,"Ağır")};
		return armorList;
	}
	
	public static Armor getArmorObjByID(int id) {
		for (Armor a : Armor.armors()) {
			if (a.getId() == id ) {
				return a ;
			}
		}
		return null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
