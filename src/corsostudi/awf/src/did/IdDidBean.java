package did;

public class IdDidBean {

	private String NomeDip;
	private String Codice;
	private String NomeCorso;
	private String Durata;
	private String Sede;
	private String Informativa;
	private int NumIns;
	private int CreditiTot;

	public IdDidBean() {
		NomeDip = null;
		Codice = null;
		NomeCorso = null;
		Durata = null;
		Sede = null;
		Informativa = null;
		NumIns = 0;
		CreditiTot = 0;
	}

	public String getNomeDip() {
		return NomeDip;
	}

	public void setNomeDip(String nomeDip) {
		NomeDip = nomeDip;
	}

	public String getCodice() {
		return Codice;
	}

	public void setCodice(String codice) {
		Codice = codice;
	}

	public String getNomeCorso() {
		return NomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		NomeCorso = nomeCorso;
	}

	public String getDurata() {
		return Durata;
	}

	public void setDurata(String durata) {
		Durata = durata;
	}

	public String getSede() {
		return Sede;
	}

	public void setSede(String sede) {
		Sede = sede;
	}

	public String getInformativa() {
		return Informativa;
	}

	public void setInformativa(String informativa) {
		Informativa = informativa;
	}

	public int getNumIns() {
		return NumIns;
	}

	public void setNumIns(int numIns) {
		NumIns = numIns;
	}

	public int getCreditiTot() {
		return CreditiTot;
	}

	public void setCreditiTot(int creditiTot) {
		CreditiTot = creditiTot;
	}
  
	
	
	
}
