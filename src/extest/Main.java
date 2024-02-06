package extest;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<GoodsInfo> list = dao.select();

        System.out.println("번호\t상품코드\t상품명\t\t\t가격\t제조사");
        System.out.println("--------------------------------------------------------");
        int no = 1;
        for (GoodsInfo g : list) {
            System.out.printf("%d\t%s\t%-15s\t%d\t%s\n", 
                                no++, g.getCode(), g.getName(), g.getPrice(), g.getMaker());
        }
    }
}
