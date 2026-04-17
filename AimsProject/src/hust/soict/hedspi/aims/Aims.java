package hust.soict.hedspi.aims;

import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void initData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book("Harry Potter", "Fantasy", 20.00f);
        book1.addAuthor("J.K. Rowling");
        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music", "Various", 15.00f, "Queen");
        cd1.addTrack(new Track("Bohemian Rhapsody", 6));
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void viewStore() {
        boolean back = false;
        while (!back) {
            store.print();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    String titleCart = scanner.nextLine();
                    Media mCart = store.fetchMedia(titleCart);
                    if (mCart != null) {
                        cart.addMedia(mCart);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mPlay = store.fetchMedia(titlePlay);
                    if (mPlay != null) {
                        if (mPlay instanceof Playable) {
                            ((Playable)mPlay).play();
                        } else {
                            System.out.println("This media is not playable.");
                        }
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        
        boolean back = false;
        while (!back) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added to cart.");
                    back = true;
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable)media).play();
                    } else {
                        System.out.println("This media is not playable.");
                    }
                    back = true;
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.fetchMedia(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStore() {
        System.out.println("\n1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter type (1 for Book, 2 for DVD, 3 for CD): ");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            
            if (type == 1) {
                store.addMedia(new Book(title, category, cost));
            } else if (type == 2) {
                store.addMedia(new DigitalVideoDisc(title, category, cost));
            } else if (type == 3) {
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                store.addMedia(new CompactDisc(title, category, "", cost, artist));
            }
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = store.fetchMedia(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Not found.");
            }
        }
    }

    public static void seeCurrentCart() {
        boolean back = false;
        while (!back) {
            cart.print();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    System.out.print("Filter by (1) ID or (2) Title? ");
                    int f = scanner.nextInt();
                    scanner.nextLine();
                    if (f == 1) {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        cart.searchById(id);
                    } else if (f == 2) {
                        System.out.print("Enter Title: ");
                        String t = scanner.nextLine();
                        cart.searchByTitle(t);
                    }
                    break;
                case 2:
                    System.out.print("Sort by (1) Title then Cost or (2) Cost then Title? ");
                    int s = scanner.nextInt();
                    if (s == 1) {
                        cart.sortByTitleCost();
                    } else if (s == 2) {
                        cart.sortByCostTitle();
                    }
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String rTitle = scanner.nextLine();
                    Media mToRemove = cart.fetchMedia(rTitle);
                    if (mToRemove != null) {
                        cart.removeMedia(mToRemove);
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String pTitle = scanner.nextLine();
                    Media mToPlay = cart.fetchMedia(pTitle);
                    if (mToPlay != null) {
                        if (mToPlay instanceof Playable) {
                            ((Playable)mToPlay).play();
                        } else {
                            System.out.println("Media is not playable.");
                        }
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 5:
                    System.out.println("An order has been created. The cart will now be emptied.");
                    cart.emptyCart();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }
}
