package t3h.edu.vn.ss.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import t3h.edu.vn.ss.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    public List<CategoryEntity> findAll();

}
