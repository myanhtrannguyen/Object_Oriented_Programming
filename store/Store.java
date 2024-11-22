package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private static final int MAX_STORE_SIZE = 20; 
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_STORE_SIZE];
    private int numOfItems = 0; 

    public void addDVD(DigitalVideoDisc dvd) {
        if (numOfItems < MAX_STORE_SIZE) {
            itemsInStore[numOfItems] = dvd;
            numOfItems++;
            System.out.println("DVD added to the store: " + dvd.getTitle());
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(String title) {
    	boolean found = false;
        for (int i = 0; i < numOfItems; i++) {
            if (itemsInStore[i].isMatch(title)) {
                found = true;
                System.out.println("DVD removed from the store: " + itemsInStore[i].getTitle());

                for (int j = i; j < numOfItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numOfItems - 1] = null; 
                numOfItems -= 1;
                break;
            }
        }
        if (found == false) {
            System.out.println("No DVD found with the title: " + title);
        }
    }

    public void printStore() {
        System.out.println("******************* STORE *******************");
        if (numOfItems == 0) {
            System.out.println("No DVDs in the store.");
        } else {
            for (int i = 0; i < numOfItems; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i]);
            }
        }
        System.out.println("********************************************");
    }
}

