package jtm.activity09;

/*- TODO #1
 * Implement Comparable interface with Order class
 * Hint! Use generic type of comparable items in form: Comparable<Order>
 * 
 * TODO #2 Override/implement necessary methods for Order class:
 * - public Order(String orderer, String itemName, Integer count) — constructor of the Order
 * - public int compareTo(Order order) — comparison implementation according to logic described below
 * - public boolean equals(Object object) — check equality of orders
 * - public int hashCode() — to be able to handle it in some hash... collection 
 * - public String toString() — string in following form: "ItemName: OrdererName: Count"
 * 
 * Hints:
 * 1. When comparing orders, compare their values in following order:
 *    - Item name
 *    - Customer name
 *    - Count of items
 * If item or customer is closer to start of alphabet, it is considered "smaller"
 * 
 * 2. When implementing .equals() method, rely on compareTo() method, as for sane design
 * .equals() == true, if compareTo() == 0 (and vice versa).
 * 
 * 3. Also Ensure that .hashCode() is the same, if .equals() == true for two orders.
 * 
 */

import java.util.Objects;

public class Order implements Comparable<Order>{
	String orderer; // Name of the customer
	String itemName; // Name of the requested item
	int count; // Count of the requested items

	public Order(String orderer, String itemName, Integer count) {
		this.orderer = orderer;
		this.itemName = itemName;
		this.count = count;
	}

	@Override
	public String toString() {
		return itemName + ": " + orderer + ": " + count;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Order order = (Order) object;
		int equalsResult = compareTo(order);
		return equalsResult == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderer, itemName, count);
	}

	@Override
	public int compareTo(Order order) {
		if(!this.itemName.equals(order.itemName)){
			return this.itemName.compareTo(order.itemName) > 0 ? 1 : -1;
		}
		if(!this.orderer.equals(order.orderer)){
			return this.orderer.compareTo(order.orderer) > 0 ? 1 : -1;
		}
		if(this.count != (order.count)){
			if(this.count > order.count) {
				return 1;
			}else {
				return -1;
			}
		}
		return 0;
	}

}
