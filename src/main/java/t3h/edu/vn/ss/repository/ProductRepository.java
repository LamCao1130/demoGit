package t3h.edu.vn.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.edu.vn.ss.Entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "select p.productId, p.brandId,p.categoryId,p.productName, p.productImg,p.price,p.deleted ,b.brandName, c.categoryName,b.brandImg,c.categoryImg from product p join category c on p.categoryId = c.categoryId join brand b on b.brandId = p.brandId order by p.productId asc;", nativeQuery = true)
    public List<ProductEntity> findAllProductsAllTable();
}
