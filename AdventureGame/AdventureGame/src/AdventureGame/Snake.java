package AdventureGame;

import java.util.Random;

public class Snake extends Obstacle {
	Random rnd = new Random();
	private int armorOrWeapon;
	private Player player ;
	
	public Snake(Player player) {
		super("Yılan", 4,0, 12,0);
		this.setDamage(rndDamage());
		this.player = player;
		
	}
	
	public  int  rndDamage() {
		return rnd.nextInt(4)+3;
	}
	public  void rndAward() {
		int rndAward  =   rnd.nextInt(100)+1;
		if (rndAward<= 15 ) {
			int rndSelectWeapon = rnd.nextInt(100)+1;
			Weapon[] weapon = Weapon.weapons();
			if (rndSelectWeapon <=20) {
				this.getPlayer().getInventory().setWeapon(weapon[2]);
				System.out.println(weapon[2].getName() +" Silahını Kazandın ");
			}else if (rndSelectWeapon <=50 ) {
				this.getPlayer().getInventory().setWeapon(weapon[1]);
				System.out.println(weapon[1].getName() +" Silahını Kazandın ");
			}else if (rndSelectWeapon <=100) {
				this.getPlayer().getInventory().setWeapon(weapon[0]);
				System.out.println(weapon[0].getName() +" Silahını Kazandın ");
			}
		} else if (rndAward<=30 ) {
			int rndSelectArmor = rnd.nextInt(100)+1;
			Armor[] armor =  Armor.armors();
			if (rndSelectArmor <=20) {
				this.getPlayer().getInventory().setArmor(armor[2]);
				System.out.println(armor[2].getName() +" Zırıhını Kazandın ");
			}else if (rndSelectArmor <=50 ) {
				this.getPlayer().getInventory().setArmor(armor[1]);
				System.out.println(armor[1].getName() +" Zırıhını Kazandın ");
			}else if (rndSelectArmor <=100) {
				this.getPlayer().getInventory().setArmor(armor[0]);
				System.out.println(armor[0].getName() +" Zırıhını Kazandın ");
			}
		}else if (rndAward<=55) {
			int rndSelectMoney = rnd.nextInt(100)+1;
			if (rndSelectMoney <=20) {
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
				System.out.println("10 altın kazandın ");
			}else if (rndSelectMoney <=50 ) {
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
				System.out.println("5 altın kazandın ");
			}else if (rndSelectMoney <=100) {
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
				System.out.println("1 altın kazandın ");
			}
		}else if (rndAward<=100) {
			System.out.println("Birşey Kazanamadın!");
		}
		

	}

	public int getArmorOrWeapon() {
		return armorOrWeapon;
	}

	public void setArmorOrWeapon(int armorOrWeapon) {
		this.armorOrWeapon = armorOrWeapon;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
