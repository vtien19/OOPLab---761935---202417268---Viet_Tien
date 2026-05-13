package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
<<<<<<< HEAD
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompacDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class Aims {
    public static void main(String[] args) {
        // 1. Tạo giỏ hàng mới
        Cart anOrder = new Cart();

        // 2. Tạo DVD và thêm vào giỏ
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1); // Sử dụng addMedia thay vì addDigitalVideoDisc

        // 3. Tạo Sách và thêm vào giỏ
        Book book1 = new Book(1, "Java Programming", "Education", 25.0f);
        book1.addAuthor("James Gosling");
        anOrder.addMedia(book1);

        // 4. Tạo CD và thêm vào giỏ
        CompacDisc cd1 = new CompacDisc(2, "Greatest Hits", "Music", 15.0f, 0, "Various Artists", "Queen");
        cd1.addTrack(new Track("Bohemian Rhapsody", 6));
        cd1.addTrack(new Track("We Will Rock You", 3));
        anOrder.addMedia(cd1);

        // 5. In thông tin giỏ hàng và tổng tiền
        System.out.println("Total Cost is: " + anOrder.totalCost());
        anOrder.print();

        // 6. Chạy thử (Play) các phương tiện hỗ trợ Playable
        System.out.println("\n--- Testing Playback ---");
        dvd1.play();
        cd1.play();

        // Lưu ý: book1.play() sẽ báo lỗi vì Book không triển khai Playable
    }
}
=======
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    // Menu chính
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Menu khi xem Store
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // Menu chi tiết từng Media
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    // Menu trong Giỏ hàng
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
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu cho Store tại đây (DVD, CD, Book)
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            if (choice == 1) viewStore();
            else if (choice == 2) updateStore();
            else if (choice == 3) viewCart();
            else if (choice == 0) break;
            else System.out.println("Invalid option.");
        }
    }

    // Xử lý View Store
    public static void viewStore() {
        store.print(); // Hiển thị danh sách item trong cửa hàng
        int choice;
        while (true) {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break; // Quay lại menu chính

            switch (choice) {
                case 1: // See details
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Media m = store.search(title); // Giả định store có hàm search
                    if (m != null) {
                        System.out.println(m.toString());
                        handleMediaDetails(m);
                    } else System.out.println("Not found.");
                    break;
                case 2: // Add to cart
                    System.out.print("Enter title to add: ");
                    String tAdd = scanner.nextLine();
                    Media mAdd = store.search(tAdd);
                    if (mAdd != null) {
                        cart.addMedia(mAdd);
                        // Yêu cầu Bài 18: Hiển thị số lượng DVD trong giỏ
                        System.out.println("DVDs in cart: " + cart.getQtyOfDVDs());
                    }
                    break;
                case 3: // Play media
                    System.out.print("Enter title to play: ");
                    String tPlay = scanner.nextLine();
                    Media mPlay = store.search(tPlay);
                    if (mPlay instanceof Playable) ((Playable) mPlay).play();
                    else System.out.println("Cannot play this type.");
                    break;
                case 4: viewCart(); break;
            }
        }
    }

    // Xử lý Media Details
    private static void handleMediaDetails(Media m) {
        mediaDetailsMenu();
        int choice = scanner.nextInt();
        if (choice == 1) cart.addMedia(m);
        else if (choice == 2 && m instanceof Playable) ((Playable) m).play();
    }

    // Xử lý Giỏ hàng (Cart)
    public static void viewCart() {
        cart.print();
        int choice;
        while (true) {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 2: // Sort
                    System.out.print("1. By Title | 2. By Cost: ");
                    int s = scanner.nextInt();
                    if (s == 1) cart.sortByTitle(); else cart.sortByCost();
                    cart.print();
                    break;
                case 3: // Remove
                    System.out.print("Enter title to remove: ");
                    String tRem = scanner.nextLine();
                    Media mRem = cart.search(tRem);
                    if (mRem != null) cart.removeMedia(mRem);
                    break;
                case 5: // Place order
                    System.out.println("Order created! Emptying cart...");
                    cart = new Cart(); // Tạo giỏ mới (làm trống)
                    return;
            }
        }
    }

    public static void updateStore() {
        int choice;
        do {
            System.out.println("\n--- Update Store Options ---");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.print("Please choose: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Chống trôi lệnh

            if (choice == 1) {
                System.out.println("Choose media type: 1. Book | 2. CD | 3. DVD");
                int type = scanner.nextInt();
                scanner.nextLine();

                // Nhập các thông tin cơ bản
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Category: ");
                String category = scanner.nextLine();
                System.out.print("Enter Cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();

                switch (type) {
                    case 1: // Thêm Book
                        // Giả sử Book của bạn dùng Constructor: (id, title, category, cost)
                        System.out.print("Enter ID: ");
                        int idBook = scanner.nextInt();
                        scanner.nextLine();
                        store.addMedia(new Book(idBook, title, category, cost));
                        break;

                    case 2: // Thêm CD
                        System.out.print("Enter ID: ");
                        int idCD = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Artist: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter Director: ");
                        String directorCD = scanner.nextLine();
                        System.out.print("Enter Length: ");
                        int lengthCD = scanner.nextInt();
                        scanner.nextLine();

                        // Gọi CompactDisc (id, title, category, cost, length, director, artist)
                        store.addMedia(new CompacDisc(idCD, title, category, cost, lengthCD, directorCD, artist));
                        break;

                    case 3: // Thêm DVD
                        System.out.print("Enter Director: ");
                        String directorDVD = scanner.nextLine();
                        System.out.print("Enter Length: ");
                        int lengthDVD = scanner.nextInt();
                        scanner.nextLine();

                        // SỬA TẠI ĐÂY: Gọi theo đúng Constructor phổ biến của DVD (Title, Category, Director, Length, Cost)
                        // Không truyền ID vào để tránh lỗi "Cannot resolve constructor"
                        store.addMedia(new DigitalVideoDisc(title, category, directorDVD, lengthDVD, cost));
                        break;

                    default:
                        System.out.println("Invalid type!");
                }
                System.out.println("Update successful!");

            } else if (choice == 2) {
                System.out.print("Enter the title to remove: ");
                String titleRem = scanner.nextLine();
                Media m = store.search(titleRem);
                if (m != null) {
                    store.removeMedia(m);
                } else {
                    System.out.println("Media not found!");
                }
            }
        } while (choice != 0);
    }
}
>>>>>>> cb07005 (update lab)
