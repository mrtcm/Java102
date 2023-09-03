package AdventureGame;

import java.util.Random;

public abstract class BattleLoc  extends Location {
	private Obstacle obstacle;
	private String award;
	private int maxObstacle;
	private Random rnd  = new Random();

	public BattleLoc(Player player, String name, int ID,Obstacle obstacle,String award,int maxObstacle) {
		super(player, name, ID);
		this.obstacle   = obstacle;
		this.award = award;
		this.maxObstacle  = maxObstacle;
		
	}

	public int randomObstacleNumber() {
		
		return rnd.nextInt(this.getMaxObstacle())+1;
	}
	public int getMaxObstacle() {
		return maxObstacle;
	}


	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}


	public Obstacle getObstacle() {
		return obstacle;
	}
	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}

	@Override
	public boolean onLocation() {
		int obsNumber   = this.randomObstacleNumber();
		System.out.println("Şuan Buradasın : "+ this.getName());
		System.out.println("Dikkatli Ol Burada " + obsNumber+" "+ this.getObstacle().getName() + " Yaşıyor...");
		System.out.println();
		System.out.print("Savaşmak için 's' Kaçmak için 'k' yi tuşla : ");
		String selectCase = scn.nextLine();
		selectCase=  selectCase.toUpperCase();
		if (selectCase.equals("S")) {
			if (combat(obsNumber)) {
				System.out.println(this.getName()  + " tüm düşmanları yendiniz ...");
				isAward(this.getObstacle());
				return true;
			}
			
		} 
		if (this.getPlayer().getHealth() <= 0 ) {
			System.out.println("Öldünüz ...");
			return false ;
		}
		
		
		return true;
	}
	
	public boolean combat(int obsNumber) {
		
		for (int i = 1 ; i<=obsNumber ; i++) {
			this.getObstacle().setHealht(this.getObstacle().getDefaultHealt());
			playerStats();
			obstacleStats(i);
			
			while(this.getPlayer().getHealth()> 0 && this.getObstacle().getHealht() > 0) {
				System.out.println();
				if (rndCombat() == 0 ) {
					System.out.println();
					System.out.println("Siz Vurdunuz...");
					this.getObstacle().setHealht(this.obstacle.getHealht()-this.getPlayer().getTotalDamage());
					
					afterHit();
					System.out.println();
				}else if (rndCombat() == 1 ) {
					if (this.getObstacle().getHealht()  > 0 ) {
						System.out.println();
						System.out.println("Canavar Size Vurdu ...");
						int obstacleDamage  = this.getObstacle().getDamage()  - this.getPlayer().getInventory().getArmor().getBlock();
						if (obstacleDamage < 0 ) {
							obstacleDamage = 0;
						}
						this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
						afterHit();
						if (this.getPlayer().getHealth()<= 0 ) {
							return false;
						}
					}else {
						return false;
					}
				}
					/*
				//System.out.print("<V>ur veya <K>aç : ");
				//String selectCombat = scn.nextLine().toUpperCase();
				if (selectCombat.equals("V")) {
					
					
					}
					*/
				
				if (this.getObstacle().getHealht() <= 0) {
					if (this.getObstacle().getId() == 4 ) {
						Snake snake = new Snake(getPlayer());
						snake.rndAward();
						playerStats();
						System.out.println("Düşmanı Yendiniz ...");
						System.out.println("Güncel bakiye : " + this.getPlayer().getMoney());
					}else {
						System.out.println("Düşmanı Yendiniz ...");
						System.out.println( this.getObstacle().getAward() +" TL kazandınız!");
						this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
						System.out.println("Güncel bakiye : " + this.getPlayer().getMoney());
					}
					
				}
			}
			
		}
		return true;
	}
	public void afterHit() {
		System.out.println("===========================================");
		System.out.println("Canınız : " + this.getPlayer().getHealth());
		System.out.println("Canavar Canı  : "+ this.getObstacle().getHealht());
		
	}
	public void isAward(Obstacle obstacle) {
		switch(obstacle.getId()) {
			case 1 :
				this.getPlayer().getInventory().setFood(true);
				break;
			case 2 :
				this.getPlayer().getInventory().setFirewood(true);
				break;
			case 3 :
				this.getPlayer().getInventory().setWater(true);
				break;
		}
	}
	
	public int rndCombat() {
		return rnd.nextInt(2);
	}

	public void playerStats() {
		System.out.println();
		System.out.println("Oyuncu Değerleri : ");
		System.out.println("======================");
		System.out.println("Sağlık : " + this.getPlayer().getHealth());
		System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
		System.out.println("Para : " + this.getPlayer().getMoney());
		System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
	}
	
	public void obstacleStats(int i) {
		System.out.println();
		System.out.println(i+"."+this.getObstacle().getName() + " Değerleri : ");
		System.out.println("Sağlık : "+ this.getObstacle().getHealht());
		System.out.println("Hasar : "+ this.getObstacle().getDamage());
		System.out.println("Ödül : "+ this.getObstacle().getAward());
	}
}
