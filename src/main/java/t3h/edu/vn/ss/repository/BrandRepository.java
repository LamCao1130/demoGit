package t3h.edu.vn.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.edu.vn.ss.entity.BrandEntity;

import java.util.List;

public interface BrandRepository extends JpaRepository<BrandEntity,Integer> {

     List<BrandEntity> findAll();

     BrandEntity save(BrandEntity brand);

     void delete(BrandEntity brand);


     @Query(value = "select * from brand where brandId = ?1" ,nativeQuery = true)
     BrandEntity findById(int id);
}
