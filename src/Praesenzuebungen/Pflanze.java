package Praesenzuebungen;

public class Pflanze {
	private double size; // in cm
	String name;
	private String genus;
	String color = "grün";
	double growthRate = 1; // in cm
	private boolean isWatered;
	private boolean isFertilized;
	private int fertilizer = 0;

	public Pflanze(String name, String genus) {
		this.name = name;
		this.genus = genus;
	}

	public Pflanze(String name, String genus, String color) {
		this(name, genus);
		this.color = color;
	}

	public boolean grow() {
		if (this.isWatered) {
			if (this.fertilizer >= 1) {
				this.size += (this.growthRate * 2);
				this.isWatered = false;
				this.fertilizer--;
				if (this.fertilizer == 0) {
					this.isFertilized = false;
				}
				return true;
			} else {
				this.size += this.growthRate;
				this.isWatered = false;
				return true;
			}
		}
		return false;
	}

	public void water() {
		this.isWatered = true;
	}

	public boolean fertilize() {
		isFertilized = true;
		fertilizer = 2;
		return true;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public boolean isWatered() {
		return isWatered;
	}

	public void setWatered(boolean isWatered) {
		this.isWatered = isWatered;
	}

	public boolean isFertilized() {
		return isFertilized;
	}

	public void setFertilized(boolean isFertilized) {
		this.isFertilized = isFertilized;
	}

	public int getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(int fertilizer) {
		this.fertilizer = fertilizer;
	}
}