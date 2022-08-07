package com.turkcell.atm;

// Butun bankalarda ortak metodlar
public interface IBank {
	
	// para görüntüleme
	public void showMoney();
	
	// para Ekleme
	public void addMoney();
	
	// para çekme
	public void reduceMoney();
	
	// Havale yapmak
	public void sendHavaleMoney();
	
	// Eft yapmak
	public void sendEftMoney();
	
	// Mail Göndermek
	public void sendMail();
	
}
