package t3h.edu.vn.ss.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "size")
@Data
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sizeId;
    private String sizeEu;
    private int deleted;

}
