public class Aims {

    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.printItems();

        // print total cost of the items in the cart
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);

        anOrder.printItems();

        System.out.println("Total cost after delete is: " + anOrder.totalCost());

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Cinderella", "Animation", 15.0f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight", "Action", 20.0f);

        // Thử nghiệm nạp chồng: thêm 2 đĩa cùng lúc
        anOrder.addDigitalVideoDisc(dvd4, dvd5);

        // 2. Test nạp chồng: Truyền một mảng đĩa
        DigitalVideoDisc[] list = new DigitalVideoDisc[2];
        list[0] = new DigitalVideoDisc("Phim A", "Thể loại A", 10.0f);
        list[1] = new DigitalVideoDisc("Phim B", "Thể loại B", 15.0f);

        // Bước 2: Gọi hàm nạp chồng mảng
        // Java thấy bạn truyền 'list' (là một mảng) nên nó sẽ tự gọi hàm ở mục 2
        anOrder.addDigitalVideoDisc(list);
        anOrder.printItems();

        System.out.println("DVD 1 ID: " + dvd1.getId());
        System.out.println("DVD 2 ID: " + dvd2.getId());

    }
}
