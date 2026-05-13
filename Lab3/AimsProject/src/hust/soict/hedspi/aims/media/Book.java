package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

// Kế thừa Media để tái sử dụng id, title, category , cost
public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost){
        super(id,title,category,cost);
    }

    // Thực hiện yêu cầu hàm addAuthor
    public void addAuthor(String authorName) {
        // Kiểm tra xem tác giả đã có trong danh sách chưa
        if(!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả: " + authorName);
        } else {
            System.out.println("Tác giả '" + authorName + "' đã tồn tại!");
        }
    }

    // Thực hiện yêu cầu hàm removeAuthor
    public void removeAuthor(String authorName){
        // Kiểm tra xem tác giả có trong danh sách không rồi mới xoá
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Đã xoá tác giả: " + authorName);
        } else {
            System.out.println("Không tìm thấy tác giả '" + authorName + "' để xoá!");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + ": " + getCost() + " $";
    }
}
