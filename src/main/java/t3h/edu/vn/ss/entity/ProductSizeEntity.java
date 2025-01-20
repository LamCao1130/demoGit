package t3h.edu.vn.ss.entity;


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
    @JoinColumn(name = "productId")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "sizeId")
    private SizeEntity size;

}
