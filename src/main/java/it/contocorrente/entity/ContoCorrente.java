package it.contocorrente.entity;

public class ContoCorrente {

	//attributi
	private String dataCreazione;
	private String iban;
	private double saldo;
	private String intestatario;
	
	
	
	
	
	
	
	
	//getters e setters
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	
	
	
}
