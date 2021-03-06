package petiteAnnonce.client;
/**
 * @author KABA
 *
 */

public class Annonce {
	
	/**
	 * @param id_Annonce
	 * @param titre
	 * @param domaine
	 * @param prix
	 * @param descriptif
	 * @param user
	 */
	public Annonce(String id, String titre, String domaine, String prix, String desc, String user) {
		_id_Annonce = id;
		_titre = titre;
		_domaine = domaine;
		_prix = prix;
		_descriptif = desc;
		_user = user;
	}
	public String getId_Annonce() {
		return _id_Annonce;
	}
	public void setId_Annonce(String id_Annonce) {
		_id_Annonce = id_Annonce;
	}
	/**
	 * @return the _titre
	 */
	public String getTitre() {
		return _titre;
	}
	/**
	 * @param _titre the _titre to set
	 */
	public void setTitre(String _titre) {
		this._titre = _titre;
	}
	public String getDomaine() {
		return _domaine;
	}
	public void setDomaine(String domaine) {
		_domaine = domaine;
	}
	public String getPrix() {
		return _prix;
	}
	public void setPrix(String prix) {
		_prix = prix;
	}
	public String getDescriptif() {
		return _descriptif;
	}
	public void setDescriptif(String descriptif) {
		_descriptif = descriptif;
	}
	
	public String getUser() {
		return _user;
	}
	public void setUser(String user) {
		_user = user;
	}
	
	public String toString() {
		
		return "\t"+getId_Annonce()+" -------- "+getTitre()+" ------- "+getDomaine()+" ------- "+getPrix()+".00 $ --------- "+getDescriptif()+" --------- "+getUser()+" !!";
	}
	
	String _id_Annonce;
	String _titre;
	String _domaine;
	String _prix;
	String _descriptif;
	String _user;

}
