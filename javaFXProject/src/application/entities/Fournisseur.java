package application.entities;

public class Fournisseur {
	
	private String nom;
	private String adresse;
	private String telephone;
	private String email;
	
	public Fournisseur(String nom,String adresse,String telephone,String email) {
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		
	}
	/**
	 * @return the name
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param name the name to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Fournisseur [name=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email
				+ "]";
	}
	
	

}
