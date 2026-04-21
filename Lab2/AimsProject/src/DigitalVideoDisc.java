public class DigitalVideoDisc {
    private String title;       // Tiêu đề phim
    private String category;    // Thể loại
    private String director;    //Đạo diễn
    private int length;         // Độ dài phim
    private float cost;          // Giá tiền

    // Biến static để đếm tổng số lượng DVD đã tạo
    private static int nbDigitalVideoDiscs = 0;

    // Biến instance để lưu ID duy nhất của từng đĩa
    private int id;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;     // tăng tổng số đĩa
        this.id = nbDigitalVideoDiscs;  // gán ID cho đĩa này
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;     // tăng tổng số đĩa
        this.id = nbDigitalVideoDiscs;  // gán ID cho đĩa này
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;     // tăng tổng số đĩa
        this.id = nbDigitalVideoDiscs;  // gán ID cho đĩa này
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;     // tăng tổng số đĩa
        this.id = nbDigitalVideoDiscs;  // gán ID cho đĩa này
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    // Nếu muốn xem hiện tại có tổng bao nhiêu đĩa
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
}

