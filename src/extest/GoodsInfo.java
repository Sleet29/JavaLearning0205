package extest;
public class GoodsInfo {
    private String code;
    private String name;
    private int price;
    private String maker;

    // Constructor
    public GoodsInfo() {
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
