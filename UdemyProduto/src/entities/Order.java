package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import entities.enums.OrderStatus;

public class Order {

	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order () {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public String getMoment() {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
		return fmt1.format(moment);
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		Double totalPrice = 0.0;
		for (OrderItem item : items) {
			totalPrice += item.subTotal();	
		}
		return totalPrice;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + getMoment() + "\n");
		sb.append("Order status: " + getStatus() + "\n");
		sb.append("Client: " + client.getName() + " (" + client.getBirthDate() +")" + " - " + client.getEmail() + "\n");
		sb.append("Order items:" + "\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");	
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
	
}
