package section02;

import java.util.Date;

public class Product {
    private String code;
    private String brand;
    private String name;
    private int price;
    private java.util.Date manufactureDate;

    public Product() {
    }

    public Product(String code, String brand, String name, int price, Date manufactureDate) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }

    public String getCode() {
        return code;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufactureDate=" + manufactureDate +
              '}';
    }
}
