package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int taxPayersQuantity = sc.nextInt();
		
		for (int i = 1; i <= taxPayersQuantity; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char taxPayerType = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double income = sc.nextDouble();
			if(taxPayerType == 'i') {
				System.out.print("Health expenditures: ");
				Double expenditures = sc.nextDouble();
				taxPayers.add(new Individual(name, income, expenditures));
			} else if(taxPayerType == 'c') {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				taxPayers.add(new Company(name, income, numberOfEmployees));
			}
		}
		
		System.out.println();
		double taxesSum = 0.0;
		for (TaxPayer payer : taxPayers) {
			taxesSum += payer.tax();
			System.out.println(payer.getName() + ": $ " + String.format("%.2f", payer.tax()));
		}
		
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", taxesSum));

		sc.close();
	}

}
