package t3h.edu.vn.ss.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDto {
    private int productId;
    @NotEmpty(message = "tên sản phẩm không được trống")
    private String productName;

    @NotEmpty(message = "họ và tên không được phép trống")
    private String productImg;

    @Size(min=5 , message = "giá phải từ 100k đổ lên")
    private double Price;



}
