package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");			// Objeto de formatação da Data e hora 
		
		System.out.println("Enter rental data: ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/mm/yyyy hh:ss): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);						// Ler o que foi digitado como data e hora no meu teclado, como está no fmt7
		System.out.print("Return (dd/mm/yyyy hh:ss): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Enter com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por hora: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService (pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvolice(cr);
		
		System.out.println();
		System.out.println("FATURA: ");
		System.out.println("Pagamento basico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		 
		sc.close();
	}
}
