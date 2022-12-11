//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {

    private static Scanner sc;

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


    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    // Chọn MediaDetailsMenu
    public static void chooseMediaDetailsMenu(Media media) {
        while(true) {
            mediaDetailsMenu();
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    cart.playMedia(media);
                    break;
                case 0:
                    return;
            }
        }
    }

    // Chọn StoreMenu()
    public static void chooseStoreMenu() {
        while (true) {
            storeMenu();
            int choose = sc.nextInt();
            switch (choose) {
                case 1: {// Tìm media
                        System.out.println("Enter media title:");
                        sc.nextLine();
                        String title = sc.nextLine();
                        Media m = store.searchByTitle(title);
                        if (m == null) {
                            System.out.println("No media with title: " + title + " found");
                        } else {
                            System.out.println("Found:");
                            System.out.println(m);
                            chooseMediaDetailsMenu(m);
                        }
                    }
                        break;
                case 2: // 
                {
                    System.out.println("Enter media title to add to cart:");
                    String title = sc.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m == null) {
                        System.out.println("No media with title: " + title + " found");
                    } else {
                        System.out.println("Found:");
                        System.out.println(m);
                        cart.addMedia(m);
                        System.out.println("Number of media in the cart: " + cart.itemsOrdered.size());
                    }
                }

                    break;
                case 3:
                {
                    System.out.println("Enter media title to add to cart:");
                    String title = sc.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m == null) {
                        System.out.println("No media with title: " + title + " found");
                    } else {
                        cart.playMedia(m);
                    }
                }
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void chooseCartMenu() {
        while (true) {
            cartMenu();
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                {
                    System.out.println("Filter media by id --> enter 0");
                    System.out.println("Filter media by title --> enter 1");
                    int c = sc.nextInt();
                    if (c == 0) {
                        System.out.println("Enter id:");
                        int id = sc.nextInt();
                        Media m = cart.searchById(id);
                        if (m == null) {
                            System.out.println("No item with id: " + id + " found");
                        } else {
                            System.out.println("Found item with id: " + id);
                            System.out.println(m);
                        }
                    } else {
                        sc.nextLine();
                        System.out.println("Enter title:");
                        String title = sc.nextLine();
                        Media m = cart.searchByTitle(title);
                        if (m == null) {
                            System.out.println("No item with title: " + title + " found");
                        } else {
                            System.out.println("Found item with title: " + title);
                            System.out.println(m);
                        }
                    }
                }
                break;
                case 2:
                {
                    System.out.println("Sort by title --> enter 0");
                    System.out.println("Sort by cost --> enter 1");
                    int c = sc.nextInt();
                    if (c == 0) {
                        cart.sortByTitleCost();
                    } else {
                        cart.sortByCostTitle();
                    }
                }
                break;
                case 3:
                {
                    System.out.println("Enter media title to remove");
                    String title = sc.nextLine();
                    Media m = cart.searchByTitle(title);
                    if (m == null) {
                        System.out.println("No item with title: " + title + " found");
                    } else {
                        cart.removeMedia(m);
                    }
                }
                break;
                case 4:
                {
                    System.out.println("Enter media title to play");
                    String title = sc.nextLine();
                    Media m = cart.searchByTitle(title);
                    if (m == null) {
                        System.out.println("No item with title: " + title + " found");
                    } else {
                        cart.playMedia(m);
                    }
                }
                break;
                case 5:
                {
                    System.out.println("Your order is created");
                    System.out.println("Your cart now is empty");
                }
                break;
                case 0:
                    return;
            }

        }
    }

    public static void addBook() {
        System.out.println("Enter book title, category, cost, number of authors");
        int n;
        sc.nextLine();
        String title = sc.nextLine();
        String category = sc.nextLine();
        Float cost = sc.nextFloat();
        n = sc.nextInt();
        sc.nextLine();
        List<String> authors = new ArrayList<>();
        Book book = new Book(title, category, cost, authors);
        System.out.println("Enter " + n + " author's name:");
        for (int i = 1; i <= n; i++) {
            String author = sc.nextLine();
            System.out.println(author);
            book.addAuthor(author);
        }
        store.addDVD(book);
    }

    public static void addCompactDisc() {
        System.out.println("Enter compact disc title, category, cost, director, artist, number of tracks");
        int n;
        sc.nextLine();
        String title = sc.nextLine();
        String category = sc.nextLine();
        Float cost = sc.nextFloat();
        sc.nextLine();
        String director = sc.nextLine();
        String artist = sc.nextLine();
        n = sc.nextInt();
        List<Track> tracks = new ArrayList<>();
        CompactDisc compactDisc = new CompactDisc(title, category, director, artist, cost);
        System.out.println("Enter " + n + " tracks info");
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter track " + i + " title and length:");
            String trackTitle = sc.nextLine();
            int length = sc.nextInt();
            compactDisc.addTrack(new Track(trackTitle, length));
        }
        store.addDVD(compactDisc);
    }

    public static void addDigitalVideoDisc() {
        System.out.println("Enter digital video disc title, category, cost, director, length");
        int n;
        String title = sc.nextLine();
        String category = sc.nextLine();
        Float cost = sc.nextFloat();
        String director = sc.nextLine();
        int length = sc.nextInt();
        DigitalVideoDisc disc = new DigitalVideoDisc(title, category, director, length, cost);
        store.addDVD(disc);
    }

    public static void removeStoreItem() {
        System.out.println("Enter remove item title");
        String title = sc.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeDVD(media);
        }
    }

    public static void updateStore() {
        System.out.println("Enter your choice number");
        System.out.println("1. Add a book");
        System.out.println("2. Add a compactDisc");
        System.out.println("3. Add a digitalVideoDisc");
        System.out.println("4. Remove an item");

        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                addBook();
                break;
            case 2:
                addCompactDisc();
                break;
            case 3:
                addDigitalVideoDisc();
                break;
            case 4:
                removeStoreItem();
                break;
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (true) {
            showMenu();
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    store.printStore();
                    chooseStoreMenu();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    cart.printCart();
                    chooseCartMenu();
                    break;
                case 0:
                    System.out.println("Bye bye");
                    return;
            }

        }
    }
}
