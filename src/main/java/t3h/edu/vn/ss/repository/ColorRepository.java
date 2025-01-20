package t3h.edu.vn.ss.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import t3h.edu.vn.ss.entity.ColorEntity;

import java.util.List;


public interface ColorRepository extends JpaRepository<ColorEntity, Integer> {
    List<ColorEntity> findAll();
}
