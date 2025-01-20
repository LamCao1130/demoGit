package t3h.edu.vn.ss.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Color")
@Data
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "colorId")
    private int colorId;

    @Column(name = "colorName")
    private String colorName;

    @Column(name = "hex")
    private String colorHex;

    @Column(name = "deleted")
    private int deleted;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
