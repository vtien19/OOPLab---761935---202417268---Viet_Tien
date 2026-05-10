package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
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