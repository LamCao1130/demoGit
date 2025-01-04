package t3h.edu.vn.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t3h.edu.vn.ss.Entity.BrandEntity;

import java.util.List;

public interface BrandRepository extends JpaRepository<BrandEntity,Integer> {

     List<BrandEntity> findAll();

}
