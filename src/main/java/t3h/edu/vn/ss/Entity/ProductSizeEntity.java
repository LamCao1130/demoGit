package t3h.edu.vn.ss.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productsize")
@Data
public class ProductSizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productSizeId;


    @ManyToOne
    @JoinColumn(name = "product_product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "size_size_id")
    private SizeEntity size;

}
