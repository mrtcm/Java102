package AdventureGame;

public abstract class NormalLoc extends Location{
	
	
	public NormalLoc(Player player,String name,int ID) {
		super(player,name,ID);
	}

	@Override
	public boolean onLocation() {
		return true;
	}
	

}
