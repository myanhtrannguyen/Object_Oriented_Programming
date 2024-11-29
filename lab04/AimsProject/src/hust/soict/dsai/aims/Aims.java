package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    private static Scanner sc = new Scanner(System.in);
    private static Cart order = new Cart();
    private static Store store = new Store();
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    //======================================View store=========================================//
    public static void test(){}
    public static void showDetailsOfEachMediaType(Media media) {

        int maxLen = 20;
        if (media instanceof DigitalVideoDisc) {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.printf("║ Title: %-"+ maxLen +"s \n", media.getTitle());
            System.out.printf("║ Director: %-"+ maxLen +"s \n", ((DigitalVideoDisc) media).getDirector());
            System.out.printf("║ Length: %-3d minutes \n", ((DigitalVideoDisc) media).getLength());
            System.out.printf("║ Cost: $%-5.2f \n", media.getCost());
            System.out.println("╚══════════════════════════════════════════════╝");

        } else if (media instanceof CompactDisc) {

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.printf("║ Title: %-"+ maxLen +"s \n", media.getTitle());
            System.out.printf("║ Artist: %-"+ maxLen +"s \n", ((CompactDisc) media).getArtist());
            for(Track t: ((CompactDisc) media).getTrack()){
                System.out.printf("║ Track: %-"+ maxLen +"s \n", t.getTitle());
                System.out.printf("║ Length: %-3d minutes \n", t.getLength());
            }
            System.out.printf("║ Cost: $%-5.2f \n", media.getCost());
            System.out.println("╚══════════════════════════════════════════════╝");
        } else if (media instanceof Book) {

            List<String> authors = ((Book) media).getAuthors();
            String authorsString = String.join(", ", authors);

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.printf("║ Title: %-"+ maxLen +"s \n", media.getTitle());
            System.out.printf("║ Authors: %-"+ maxLen +"s \n", authorsString);
            System.out.printf("║ Cost: $%-5.2f \n", media.getCost());
            System.out.println("╚══════════════════════════════════════════════╝");
        } else {
            System.out.println("==============================");
            System.out.println("===>>>Unknown media type<<<===");
            System.out.println("==============================");
        }
    }

    public static void addToCart(Media m){
        System.out.println("\n>>>>>>>>>>>>>=======<<<<<<<<<<<<");
        order.addMedia(m);
        System.out.println(">>>>>>>>>>>>>=======<<<<<<<<<<<<\n");
    }

    public static void playMedia(Media m){
        if (m instanceof DigitalVideoDisc) {
            System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            ((DigitalVideoDisc) m).play();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        } else if (m instanceof CompactDisc) {
            System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            ((CompactDisc) m).play();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        } else {
            System.out.println("======================================================");
            System.out.println("===>>>This type of media does not have play mode<<<===");
            System.out.println("======================================================");
        }
    }

    public static boolean solveOptionOfMediaDetailsSelected(Media m){
        switch (readOption()){

            // 1. Add to cart
            case 1:
                addToCart(m);
                break;

            // 2. Play
            case 2:
                playMedia(m);
                break;

            // 0. Back
            case 0:
                return true;

            default:
                System.out.println("========================================");
                System.out.println("===>>>This option is not available<<<===");
                System.out.println("========================================");
                return false;
        }
        return false;
    }

    public static void showMediaDetails(){

        sc.nextLine();
        System.out.println(">>>>>Enter the title of the media: ");
        System.out.print(">>>>>");
        Media tmp = store.searchMedia(sc.nextLine());
        if(tmp!=null){
            showDetailsOfEachMediaType(tmp);

            // Menu Media Details
            boolean backToMenuStore = false;

            while (!backToMenuStore) {
                mediaDetailsMenu();
                backToMenuStore = solveOptionOfMediaDetailsSelected(tmp);
            }
        }
        else {
            System.out.println("=================================================");
            System.out.println("===>>>The Media does not exist in the store<<<===");
            System.out.println("=================================================");
        }

    }

    public static void addAMediaToCart(){
        sc.nextLine();
        System.out.println(">>>>>Enter the title of the media you want to add to the cart: ");
        System.out.print(">>>>>");
        Media tmp = store.searchMedia(sc.nextLine());
        if(tmp!=null){
            System.out.println("\n>>>>>>>>>>>>>=======<<<<<<<<<<<<");
            order.addMedia(tmp);
            System.out.println(">>>>>>>>>>>>>=======<<<<<<<<<<<<\n");
        }
        else {
            System.out.println("=================================================");
            System.out.println("===>>>The Media does not exist in the store<<<===");
            System.out.println("=================================================");
        }
        int count = 0;
        if(tmp instanceof DigitalVideoDisc){
            for(Media m : order.getOrderedList())
                if(m instanceof  DigitalVideoDisc) count++;

            System.out.println(">>>>>The number of DVDs in the current cart: " + count +"<<<<<\n");
        }
    }

    public static void playAMedia(){
        sc.nextLine();
        System.out.println(">>>>>Enter the title of the media you want to play: ");
        System.out.print(">>>>>");
        Media tmp = store.searchMedia(sc.nextLine());
        playMedia(tmp);
    }
    public static boolean solveOptionOfStoreMenuSelected(){
        switch (readOption()){

            // 1. See a media’s details
            case 1:
                showMediaDetails();
                break;

            // 2. Add a media to cart
            case 2:
                addAMediaToCart();
                break;

            // 3. Play a media
            case 3:
                playAMedia();
                break;

            // 4. See current cart
            case 4:
                seeCurrentCart();
                break;

            // 0. Back
            case 0:
                return true;

            default:
                System.out.println("========================================");
                System.out.println("===>>>This option is not available<<<===");
                System.out.println("========================================");
                return false;
        }
        return false;
    }

    public static void viewStore(){

        boolean backToMenuMain = false;

        while (!backToMenuMain) {
            store.printStore();
            storeMenu();
            backToMenuMain = solveOptionOfStoreMenuSelected();
        }
    }
    //============================================================================================//

    //=================================Update store========================================//

    public static void updateStoreMenu(){
        System.out.println("##########Update Store##########");
        System.out.println("--------------------------------");
        System.out.println("1. Add a Media");
        System.out.println("2. Remove a Media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }


    public static void addAMediaToStoreMenu(){
        System.out.println("What type of media do you want to add?");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void addABookToStore(){
        System.out.println("------Book------");
        sc.nextLine();
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Cost: ");
        float cost = sc.nextFloat();
        List<String> authors = new ArrayList<>();
        sc.nextLine();
        System.out.println("Author (enter 'done' to finish): ");
        while (true) {

            String author = sc.nextLine();

            if (author.equalsIgnoreCase("done")) {
                break;
            }

            authors.add(author);
        }
        store.addMedia(new Book(title, "Book", cost, authors));
        System.out.println("Added Book to Store successfully");
        System.out.println("--------------------------------");
    }
    public static void addADVDToStore(){
        System.out.println("------DVD------");
        sc.nextLine();// Consume the newline character

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Cost: ");
        float cost = sc.nextFloat();
        sc.nextLine(); // Consume the newline character

        System.out.print("Director: ");
        String director = sc.nextLine();

        System.out.print("Length: ");
        int length = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        store.addMedia(new DigitalVideoDisc(title, "DVD", director, length, cost));
        System.out.println("Added DVD to Store successfully");
        System.out.println("-------------------------------");
    }
    public static void addACDToStore(){
        sc.nextLine(); // Consume the newline character
        System.out.println("------CD------");
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Cost: ");
        float cost = sc.nextFloat();
        sc.nextLine(); // Consume the newline character

        System.out.print("Artist: ");
        String artist = sc.nextLine();


        System.out.println("Enter Track Information for CD (Enter '0' to finish):");
        ArrayList<Track> tracks = new ArrayList<>();
        int trackNumber = 1;
        while (true) {
            System.out.print("Track " + trackNumber + " Title (Enter '0' to finish): ");
            String trackTitle = sc.nextLine();
            if (trackTitle.equals("0")) {
                break;
            }

            System.out.print("Track " + trackNumber + " Length: ");
            int trackLength = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            Track track = new Track(trackTitle, trackLength);
            tracks.add(track);
            trackNumber++;
        }

        store.addMedia(new CompactDisc(title, "CD", cost, artist, tracks));
        System.out.println("Added CD to Store successfully");
        System.out.println("------------------------------");
    }

    public static boolean solveOptionOfAddAMediaToStoreSelected(){
        switch (readOption()){

            // 1. Add a Book
            case 1:
                addABookToStore();
                break;

            // 2. Add a DVD
            case 2:
                addADVDToStore();
                break;

            // 3. Add a CD
            case 3:
                addACDToStore();
                break;

            // 0. Back
            case 0:
                return true;

            default:
                System.out.println("========================================");
                System.out.println("===>>>This option is not available<<<===");
                System.out.println("========================================");
                return false;
        }
        return false;
    }
    public static void addAMediaToStore(){

        boolean backToUpdateStoreMenu = false;

        while (!backToUpdateStoreMenu) {
            addAMediaToStoreMenu();
            backToUpdateStoreMenu = solveOptionOfAddAMediaToStoreSelected();
        }
    }
    public static void removeAMediaFromStore(){
        sc.nextLine();
        System.out.println(">>>>>Enter the title of the media you want to remove: ");
        System.out.print(">>>>>");
        Media tmp = store.searchMedia(sc.nextLine());
        if(tmp!=null){
            System.out.println("\n>>>>>>>>>>>>>=======<<<<<<<<<<<<");
            store.removeMedia(tmp);
            System.out.println(">>>>>>>>>>>>>=======<<<<<<<<<<<<\n");
        }
        else {
            System.out.println("=================================================");
            System.out.println("===>>>The Media does not exist in the store<<<===");
            System.out.println("=================================================");
        }
    }
    public static boolean solveOptionOfUpdateStoreMenuSelected(){
        switch (readOption()){

            // 1. Add a Media
            case 1:
                addAMediaToStore();
                break;

            // 2. Remove a Media
            case 2:
                removeAMediaFromStore();
                break;

            // 0. Back
            case 0:
                return true;

            default:
                System.out.println("========================================");
                System.out.println("===>>>This option is not available<<<===");
                System.out.println("========================================");
                return false;
        }
        return false;
    }
    public static void updateStore(){

        boolean backToMenuMain = false;

        while (!backToMenuMain) {
            updateStoreMenu();
            backToMenuMain = solveOptionOfUpdateStoreMenuSelected();
        }

    }

    //=====================================================================================//

    //===============================See current cart====================================//

    public static void filterMediaInCart(){

        sc.nextLine();
        System.out.println(">>>>>Enter the title of the media you want to filter: ");
        System.out.print(">>>>>");
        String title = sc.nextLine();

        ArrayList<Media> itemsOrdered = order.getOrderedList();

        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items by Title:");
        int i = 0;

        String lowerCaseKeyword = title.toLowerCase();
        for (Media media : itemsOrdered){

            String lowerCaseTitle = media.getTitle().toLowerCase();
            if (lowerCaseTitle.contains(lowerCaseKeyword)){
                System.out.printf("#%d: %s. %.2f $\n", ++i, media.getTitle(), media.getCost());
            }

        }
        System.out.println("***************************************************");
    }

    public static void sortMediasInCart() {
        System.out.println(">>>>>>>Sort by: \n1. Cost\n2. Title");
        switch (readOption()) {
            case 1:
                order.sortByCost();
                break;
            case 2:
                order.sortByTitle();
                break;
        }
    }

    public static void removeAMediaFromCart(){

        sc.nextLine();
        System.out.println(">>>>>Enter the title of the media you want to remove: ");
        System.out.print(">>>>>");
        Media tmp = order.searchMedia(sc.nextLine());
        if(tmp!=null){
            System.out.println("\n>>>>>>>>>>>>>=======<<<<<<<<<<<<");
            order.removeMedia(tmp);
            System.out.println(">>>>>>>>>>>>>=======<<<<<<<<<<<<\n");
        }
        else {
            System.out.println("=================================================");
            System.out.println("===>>>The Media does not exist in the cart<<<===");
            System.out.println("=================================================");
        }
    }

    public static void placeOrder(){
        if(order.getOrderedList().isEmpty()){
            System.out.println("!!!! Your order is EMPTY !!!!");
        }
        else{
            System.out.println("**** Order is created ****");
        }
    }

    public static boolean solveOptionOfCartMenuSelected(){
        switch (readOption()){

            // 1. Filter medias in cart
            case 1:
                filterMediaInCart();
                break;

            // 2. Sort medias in cart
            case 2:
                sortMediasInCart();
                break;

            // 3. Remove media from cart
            case 3:
                removeAMediaFromCart();
                break;

            // 4. Play a media
            case 4:
                playAMedia();
                break;

            // 5. Place order
            case 5:
                placeOrder();
                break;

            // 0. Back
            case 0:
                return true;

            default:
                System.out.println("========================================");
                System.out.println("===>>>This option is not available<<<===");
                System.out.println("========================================");
                return false;
        }
        return false;
    }

    public static void seeCurrentCart(){

        order.printCart();
        boolean back= false;

        while (!back) {
            cartMenu();
            back = solveOptionOfCartMenuSelected();
        }


    }
    //===================================================================================//

    //===================================Menu Main==========================================//
    public static void solveOptionSelected(){
        switch (readOption()){

            // 1. View store
            case 1:
                viewStore();
                break;

           // 2. Update store
            case 2:
                updateStore();
                break;

            // 3. See current cart
            case 3:
                seeCurrentCart();
                break;

            // 0. Exit
            case 0:
                System.out.println("Are you sure you want to exit the system ? (y/n)");
                if(sc.next().charAt(0) == 'y'){
                    System.exit(0);
                    sc.close();
                }
                else {
                    break;
                }
                break;

            default:
                System.out.println("========================================");
                System.out.println("===>>>This option is not available<<<===");
                System.out.println("========================================");
                break;
        }
    }

    public static int readOption(){
        return sc.nextInt();
    }

    public static void initData(){

        // Book
        Book initBook = new Book("The Great Novel", "Book", 100.00f,
                Arrays.asList("John Doe", "Jane Smith"));

        // Book
        Book initBook2 = new Book("OOP1", "Book", 100.00f,
                Arrays.asList("Tuan", "Dung"));

        // Book
        Book initBook3 = new Book("OOP2", "Book", 100.00f,
                Arrays.asList("Dat", "Duong"));

        // DVD
        DigitalVideoDisc initDVD = new DigitalVideoDisc("Inception", "DVD",
                "Christopher Nolan", 150, 35.88f);

        // CD
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Song 1", 3));
        tracks.add(new Track("Song 2", 4));
        CompactDisc initCD = new CompactDisc("The Best Hits", "CD", 90.00f,
                "Various Artists", tracks);

        store.addMedia(initBook);
        store.addMedia(initBook2);
        store.addMedia(initBook3);
        store.addMedia(initCD);
        store.addMedia(initDVD);
    }

    //===================================================================================//

    public static void main(String[] args) {

        initData();
        while(true){
            showMenu();
            solveOptionSelected();
        }
    }
}