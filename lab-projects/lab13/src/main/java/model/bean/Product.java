package model.bean;

public class Product {
    private int id;
    private String name;
    private String description;
    private float unitPrice;
    private int unitInStock;
    private String imageFile;
    public Product(){
    }

    public Product(int id, int quantity){
        this.id = id;
        this.unitInStock -= quantity;
    }

    public Product(int id, String name, String description, float unitPrice, int unitInStock, String imageFile) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.imageFile = imageFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
