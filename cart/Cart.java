package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc; 
			qtyOrdered += 1;
			System.out.println("The disc has been added.");
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		for (int i = 0; i < dvdList.length; i ++) {
//			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//				itemOrdered[qtyOrdered] = dvdList[i];
//				qtyOrdered += 1;
//				System.out.println("The disc has been added.");
//			}
//			else {
//				System.out.println("The cart is almost full.");
//			}
//		}
//	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc ... dvdDisc) {
		for (int i = 0; i < dvdDisc.length; i ++) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemOrdered[qtyOrdered] = dvdDisc[i];
				qtyOrdered += 1;
				System.out.println("The disc has been added.");
			}
			else {
				System.out.println("The cart is almost full.");
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = dvd1;
			qtyOrdered += 1;
			System.out.println("The disc has been added.");
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemOrdered[qtyOrdered] = dvd2;
				qtyOrdered += 1;
				System.out.println("The disc has been added.");
			}
			else {
				System.out.println("The cart is almost full.");
			}
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc itemOrderedCopy[] = new DigitalVideoDisc[qtyOrdered - 1];
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemOrdered[i] == disc) {
				DigitalVideoDisc c = itemOrdered[qtyOrdered - 1]; 
				itemOrdered[qtyOrdered - 1] = itemOrdered[i]; 
				itemOrdered[i] = c;
			}
		}
		for (int i = 0; i < qtyOrdered - 1; i ++) {
			itemOrderedCopy[i] = itemOrdered[i];
		}
		itemOrdered = itemOrderedCopy;
		qtyOrdered -= 1;
	}
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i ++) {
			cost += itemOrdered[i].getCost();
		}
		return cost;
	}
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemOrdered[i];
            System.out.println((i + 1) + ". " + disc);
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("***************************************************");
	}
}
