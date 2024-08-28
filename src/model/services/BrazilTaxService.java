package model.services;

public class BrazilTaxService implements TaxService {							// Serviço para calcular o imposto  || Implementa a interface 
	
	public double tax(double amount) {					// amount = quantia/valor
		if (amount <= 100.00) {
			return amount * 0.20;
		}
		else {
			return amount * 0.15;
		}
	}
}
