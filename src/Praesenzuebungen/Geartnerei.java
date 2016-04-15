package Praesenzuebungen;

public class Geartnerei {

	public static void main(String[] args) {
		Pflanze rose = new Pflanze("Wildrose", "Rose", "rot");
		Pflanze tulpe = new Pflanze("Darwin-Tulpe", "Tulpe", "gelb");

		rose.growthRate = 1.2;
		rose.water();
		rose.grow();

		tulpe.growthRate = 1;
		tulpe.water();
		tulpe.grow();
	}
}