package AdventureGame;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Dükkan",2);
		
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("==========Mağazaya Hoşgeldiniz==========");
		boolean showMenu = true;
		while (showMenu) {
		
			System.out.println("1 - Silahlar");
			System.out.println("2 - Zırhlar");
			System.out.println("3 - Çıkış Yap");
			
			int selectCase = Location.scn.nextInt();
			
			if (selectCase>3 || selectCase<1 ) {
				System.out.println("Lütfen Geçerli Bir Değer Giriniz !");
				selectCase = Location.scn.nextInt();
			}
			switch(selectCase) {
				case 1 :
					printWeapon();
					buyWeapon();
					break ;
				case 2 :
					printArmor();
					buyArmor();
					break ;
				case 3 :
					System.out.println("Tekrar Bekleriz...");
					showMenu = false;
					break ;
			}
			
		}
		return true;
	}
	private void buyArmor() {
		System.out.println("Bir Zırh Seçiniz  : ");
		int selectArmor = Location.scn.nextInt();
		if (selectArmor>Armor.armors().length || selectArmor<0 ) {
			System.out.println("Lütfen Geçerli Bir Değer Giriniz !");
			selectArmor = Location.scn.nextInt();
		}
		
		if (selectArmor != 0 ) {
			Armor selectedArmor = Armor.getArmorObjByID(selectArmor);
			
			if (selectedArmor != null) {
				if (selectedArmor.getPrice()>this.getPlayer().getMoney()) {
					System.out.println("Yeterli paranız Bulunmamaktadır.");
				}else {
					System.out.println(selectedArmor.getName() + " Zırhını Sçtiniz...");
					this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
					this.getPlayer().getInventory().setArmor(selectedArmor);
					System.out.println("Kalan Paran : " + this.getPlayer().getMoney());
				}
			}
			
		}
		
	}

	public void printWeapon() {
		System.out.println("Silahlar : ");
		for (Weapon w : Weapon.weapons()) {
			System.out.println(w.getId()+" - " +w.getName() + "<Para : "+w.getPrice()+", Hasar : "+w.getDamage()+"> ");
		}
		System.out.println("0 - Çıkış Yap");
		
	}
	
	public void buyWeapon() {
		
		System.out.print("Bir silah seçiniz : ");
		int selectWeapon = Location.scn.nextInt();
		
		if (selectWeapon>Weapon.weapons().length || selectWeapon<0 ) {
			System.out.println("Lütfen Geçerli Bir Değer Giriniz !");
			selectWeapon = Location.scn.nextInt();
		}
		
		if (selectWeapon != 0 ) {
			Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
			
			if ( selectedWeapon != null) {
				if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yeterli Paranız Bulunmamktadır !");
				}else {
					System.out.println(selectedWeapon.getName()+" silahını Başarıyla satın aldınız...");
					this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedWeapon.getPrice());
					System.out.println("Kalan Para : "  + this.getPlayer().getMoney());
					
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					
				}
			
			}
		}
		
	}
	
	public void printArmor() {
		System.out.println("Zırhlar : ");
		for(Armor a : Armor.armors()) {
			System.out.println(a.getId()+" - " +"< "+ a.getName()+"  ,Blok Değeri : " + a.getBlock()+ " ,Ücreti : " + a.getPrice()+" >" );
		}
		System.out.println("0 - Çıkış Yap"); 
	}
	
	
}
