package Vokabelkram;

public class Speicher {
	String deutsch;
	String english;
	int bereich = 0;
	int schleife = 0;
	String kategorie;

	public Speicher(String deutsch, String english, String kategorie) {
		this.deutsch = deutsch;
		this.english = english;
		this.kategorie = kategorie;
	}
	
	public void besser(){
		this.bereich++;
	}
	
	public void umstecken(Integer a){
		this.bereich = a;
	}
	
	public void koennen(){
		this.schleife++;
	}
	
	@Override
	public String toString() {
		return deutsch + english + kategorie;
	}
}