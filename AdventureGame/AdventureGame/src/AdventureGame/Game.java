package AdventureGame;

import java.util.Scanner;

public class Game {
	
	private  Scanner scn = new Scanner(System.in);
	
	public void start() {
		System.out.println("Oyuna Hoşgeldiniz...");
		System.out.print("Lütfen bir isim giriniz : ");
		String playerName = scn.nextLine();
		
		Player player = new Player(playerName);
		System.out.println(player.getName() + " Hoşgeldin...");
		
		player.selectChar();
		
		while(true) {
			
			player.printInfo();
			
			Location location = new SafeHouse(player);
			Location[] locList = {new SafeHouse(player),new ToolStore(player),new Cave(player),new Forest(player),new River(player),new Mine(player)};
			System.out.println("================================================");
			System.out.println();
			for (Location i : locList) {
				System.out.println(i.getID() +" - "+i.getName());
			}
			
			System.out.println();
			System.out.println();
			System.out.print("Lütfen Bölge Seçiniz : ");
			int selectLocNumber = scn.nextInt();
			System.out.println();
			switch (selectLocNumber) {
				case 1 :
					location = locList[0];
					break;
				case 2 :
					location = locList[1];
					break;
				case 3 :
					if (locList[2].getPlayer().getInventory().getFood()) {
						System.out.println("Bölge ödülü alındı başka harita seçiniz !");
						
					}else {
						location = locList[2];
					}
					break;
					
				case 4 :
					if (locList[3].getPlayer().getInventory().getFirewood()) {
						System.out.println("Bölge ödülü alındı başka harita seçiniz !");
					
					}else {
					location = locList[3];
					}
					break;
				case 5 :
					if (locList[4].getPlayer().getInventory().getWater()) {
						System.out.println("Bölge ödülü alındı başka harita seçiniz !");
						
					}else {
						location = locList[4];
					}
					break;
				case 6:
						location = locList[5];
					break;
				default:
					location = locList[0];
					break;
			}
			
			if (!location.onLocation()) {
				System.out.println("GAME OVER!");
				break;
			}
			
			if (player.getInventory().getFood() == true && player.getInventory().getFirewood() == true && player.getInventory().getWater() == true) {	
				System.out.println("Tebrikler Oyunu Kazandınız ... ");
				break;
			}
			
			
			
		}
		
		
	}
}
