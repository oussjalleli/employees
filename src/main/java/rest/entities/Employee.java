package rest.entities;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Employee {
	private String cin;
	private String nom;
	private String prenom;
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Employee(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Employee() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(cin, nom, prenom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(cin, other.cin) && Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}
	
	

}
