package t3h.edu.vn.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.edu.vn.ss.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "select p.productId, p.brandId,p.categoryId,p.productName, p.productImg,p.price,p.deleted ,b.brandName, c.categoryName,b.brandImg,c.categoryImg, cl.colorId, cl.colorName , cl.hex from product p join category c on p.categoryId = c.categoryId join brand b on b.brandId = p.brandId join color cl on p.colorId = cl.colorId order by p.productId asc;", nativeQuery = true)
    public List<ProductEntity> findAllProductsAllTable();

    @Query(value = "select p.productId, p.brandId,p.categoryId,p.productName, p.productImg,p.price,p.deleted ,b.brandName, c.categoryName,b.brandImg,c.categoryImg, cl.colorId, cl.colorName , cl.hex from product p join category c on p.categoryId = c.categoryId join brand b on b.brandId = p.brandId join color cl on p.colorId = cl.colorId order by p.productId desc limit 12;", nativeQuery = true)
    public List<ProductEntity> findAllProducts12();

    @Query(value = "select p.productId, p.brandId,p.categoryId,p.productName, p.productImg,p.price,p.deleted ,b.brandName, c.categoryName,b.brandImg,c.categoryImg, cl.colorId, cl.colorName , cl.hex from product p join category c on p.categoryId = c.categoryId join brand b on b.brandId = p.brandId join color cl on p.colorId = cl.colorId where b.brandId = ?1;", nativeQuery = true)
    public List<ProductEntity> findAllProductsByBrandId(Integer brandId);

    @Query(value = "select p.productId, p.brandId,p.categoryId,p.productName, p.productImg,p.price,p.deleted ,b.brandName, c.categoryName,b.brandImg,c.categoryImg, cl.colorId, cl.colorName , cl.hex from product p join category c on p.categoryId = c.categoryId join brand b on b.brandId = p.brandId join color cl on p.colorId = cl.colorId where b.brandId = ?1 limit 9 offset ?2;", nativeQuery = true)
    public List<ProductEntity> findAllProductsByBrandIdLim9(Integer brandId, Integer limit);

    @Query(value = "select p.productId, p.brandId,p.categoryId,p.productName, p.productImg,p.price,p.deleted ,b.brandName, c.categoryName,b.brandImg,c.categoryImg, cl.colorId, cl.colorName , cl.hex from product p join category c on p.categoryId = c.categoryId join brand b on b.brandId = p.brandId join color cl on p.colorId = cl.colorId where p.productName like %?1% ;", nativeQuery = true)
    public List<ProductEntity> findAllProductsByName(String name);

    @Query(value = "select p.productId, p.brandId,p.categoryId,p.productName, p.productImg,p.price,p.deleted ,b.brandName, c.categoryName,b.brandImg,c.categoryImg, cl.colorId, cl.colorName , cl.hex from product p join category c on p.categoryId = c.categoryId join brand b on b.brandId = p.brandId join color cl on p.colorId = cl.colorId where p.productName like %?1% limit 9 offset ?2 ;", nativeQuery = true)
    public List<ProductEntity> findAllProductsByNameAndPage(String name, int page);

}
