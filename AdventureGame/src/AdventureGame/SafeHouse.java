package AdventureGame;

public class SafeHouse extends NormalLoc {
	
	

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev",1);
		
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Güvenli Evdesiniz...");
		System.out.println("Canınız Yenilendi!");
		this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
		return true;
	}

	
	
	
	
	
	
}
