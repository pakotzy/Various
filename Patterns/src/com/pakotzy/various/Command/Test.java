package com.pakotzy.various.Command;

public class Test {
	public static void main(String[] args) {
		Boss boss = new Boss();

		CryptoTrader trader = new CryptoTrader();
		Developer developer = new Developer();

		boss.setWorker(1, () -> {
			System.out.println("------- Crypto Trader -------");
			System.out.println(trader.pickCurrency() + " -> " + trader.readTrendline() + " -> " + trader.trade() + " " +
					"-> " + trader.getRich());
		});
		boss.setWorker(0, () -> {
			System.out.println("------- Developer -------");
			System.out.println(developer.doMagic() + " -> " + developer.collectPayment());
		});

		boss.makeMoney(1);
		boss.makeMoney(0);
		boss.makeMoney(2);

		Cartel cartel = new Cartel();
		boss.setWorker(1, () -> {
			System.out.println("------- Cartel -------");
			System.out.println(cartel.bitchWhat() + " -> " + cartel.shotDead() + " -> " + cartel.takeMoney());
		});
		boss.makeMoney(1);
	}
}
