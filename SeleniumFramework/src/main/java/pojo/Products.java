package pojo;

public class Products {

    private String productName;
    private double dolarsPrice;
    private double poundsPrice;
    private double euroPrice;

    public Products(String productName, double dolarsPrice, double poundsPrice, double euroPrice) {
        this.productName = productName;
        this.dolarsPrice = dolarsPrice;
        this.poundsPrice = poundsPrice;
        this.euroPrice = euroPrice;
    }

    public double getDolarsPrice() {
        return dolarsPrice;
    }

    public void setDolarsPrice(double dolarsPrice) {
        this.dolarsPrice = dolarsPrice;
    }

    public double getPoundsPrice() {
        return poundsPrice;
    }

    public void setPoundsPrice(double poundsPrice) {
        this.poundsPrice = poundsPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
