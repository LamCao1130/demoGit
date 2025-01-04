package t3h.edu.vn.ss.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table( name = "product" )
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productImg;
    private String price;
    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false, referencedColumnName = "brandId")
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(name = "categoryId" , nullable = false, referencedColumnName = "categoryId")
    private CategoryEntity category;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
