
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		itemOrdered[qtyOrdered] = disc; 
		qtyOrdered += 1;
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
}
