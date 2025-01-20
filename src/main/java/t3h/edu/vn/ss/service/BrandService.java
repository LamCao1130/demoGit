package t3h.edu.vn.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t3h.edu.vn.ss.entity.BrandEntity;
import t3h.edu.vn.ss.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public BrandEntity addBrand(BrandEntity brand) {
        return brandRepository.save(brand);
    }

    public void deleteBrand(BrandEntity brand) {
        brandRepository.delete(brand);
    }

    public BrandEntity getBrandById(int id) {
        return brandRepository.findById(id);
    }

    public List<BrandEntity> findAllBrand() {
        return brandRepository.findAll();
    }


}
