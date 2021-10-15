package Java2.src.Buoi6;

public class BookObj {
    private String code;
    private String name;
    private double price;

    
    
    public BookObj() {
        
    }
    public BookObj(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "BookObj [code=" + code + ", name=" + name + ", price=" + price + "]";
    }

    
}
