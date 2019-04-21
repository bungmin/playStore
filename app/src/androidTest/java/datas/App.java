package datas;

public class App {

    public int rank;
    public String title;
    public String companyName;
    public int userRating;  // 평균 평점(별 몇개?)
    public int price;
    public boolean isMine;  // true, 설치된 항목, false, 가격 표시
    

    public App(int rank, String title, String companyName, int userRating, int price, boolean isMine) {
        this.rank = rank;
        this.title = title;
        this.companyName = companyName;
        this.userRating = userRating;
        this.price = price;
        this.isMine = isMine;
    }
}
