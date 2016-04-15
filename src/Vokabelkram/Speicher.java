package Vokabelkram;

public class Speicher {
	private String deutsch;
	private String english;
	private int bereich = 0;
	private int schleife = 0;
	private String kategorie;

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

	public String getDeutsch() {
		return deutsch;
	}

	public void setDeutsch(String deutsch) {
		this.deutsch = deutsch;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public int getBereich() {
		return bereich;
	}

	public void setBereich(int bereich) {
		this.bereich = bereich;
	}

	public int getSchleife() {
		return schleife;
	}

	public void setSchleife(int schleife) {
		this.schleife = schleife;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
}