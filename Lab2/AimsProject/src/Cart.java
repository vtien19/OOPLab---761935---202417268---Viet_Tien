public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0; // Biến này để đếm xem hiện có bao nhiêu đĩa trong giỏ

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");

            if(qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The card is almost full.");
            }
        } else {
            System.out.println("The cart is already full!");
        }
    }

    // Nạp chồng với tham số là một mảng []
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("Đã thêm đĩa: " + disc.getTitle());
            } else {
                System.out.println("Giỏ hàng đã đầy, không thể thêm: " + disc.getTitle());
                break;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(dvd1); // Gọi lại hàm thêm 1 đĩa đã viết trước đó
            addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i] == disc) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("The disc was not found in the cart.");
        } else {
            // Dồn các phần tử phía sau lên để lấp chỗ trống
            for(int i = index; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--;
            System.out.println("The disc has been removed.");
        }
    }

    public float totalCost() {
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void printItems() {
        for(int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCost());
        }
    }
}
