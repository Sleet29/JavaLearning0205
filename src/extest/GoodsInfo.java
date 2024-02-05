package extest;

public class GoodsInfo {
    private String code;
    private String name;
    private int price;
    private String maker;

    public GoodsInfo(String code, String name, int price, String maker) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.maker = maker;
    }

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

    @Override
    public String toString() {
        return code + "\t" + name + "\t\t" + price + "\t" + maker;
    }
}