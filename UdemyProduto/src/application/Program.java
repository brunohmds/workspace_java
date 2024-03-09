package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String clientBirthDate = sc.next();
		Client client = new Client(clientName, clientEmail, LocalDate.parse(clientBirthDate,fmt1));
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		Integer orderQuantity = sc.nextInt();
		
		for (int i = 1; i <= orderQuantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
