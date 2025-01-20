package t3h.edu.vn.ss.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t3h.edu.vn.ss.entity.CategoryEntity;
import t3h.edu.vn.ss.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

}
