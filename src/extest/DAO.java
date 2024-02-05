package extest;
import java.util.*;
public class DAO {
	

}

































/*
import java.util.ArrayList;
import java.util.List;

// GoodsInfo class representing the information of a single item
public class GoodsInfo {
    private String code;
    private String name;
    private int price;
    private String maker;

    // Constructor
    public GoodsInfo(String code, String name, int price, String maker) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.maker = maker;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    // Override toString() method to customize output format
    @Override
    public String toString() {
        return code + "\t" + name + "\t\t" + price + "\t" + maker;
    }
}

// DAO class for performing CRUD operations on GoodsInfo objects
class DAO {
    // Sample data - list of GoodsInfo objects
    private List<GoodsInfo> goodsList;

    // Constructor
    public DAO() {
        // Initialize goodsList and populate with sample data
        goodsList = new ArrayList<>();
        goodsList.add(new GoodsInfo("10001", "디지털 TV", 350000, "LG"));
        goodsList.add(new GoodsInfo("10002", "DVD 플레이어", 250000, "LG"));
        goodsList.add(new GoodsInfo("10003", "디지털 카메라", 210000, "삼성"));
        goodsList.add(new GoodsInfo("10004", "전자사전", 180000, "아이리버"));
        goodsList.add(new GoodsInfo("10005", "벽걸이 에어컨", 400000, "삼성"));
    }

    // Method to retrieve all goods information
    public List<GoodsInfo> select() {
        return goodsList;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<GoodsInfo> list = dao.select();

        System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
        System.out.println("--------------------------------------------------------");
        int no = 1;
        for (GoodsInfo g : list) {
            System.out.println(no++ + "\t" + g.toString());
        }
    }
}
