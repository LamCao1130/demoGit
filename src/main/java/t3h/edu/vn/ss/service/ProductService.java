package t3h.edu.vn.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t3h.edu.vn.ss.entity.ProductEntity;
import t3h.edu.vn.ss.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> findAllProductsAllTable(){
        return productRepository.findAllProductsAllTable();
    }

    public List<ProductEntity> find12NewProduct(){
        return productRepository.findAllProducts12();
    }

    public List<ProductEntity> findProductByBrandId(int brandId){
        return productRepository.findAllProductsByBrandId(brandId);
    }

    public List<ProductEntity> findProductByBrandIdAndPage(int brandId, int page){
        return productRepository.findAllProductsByBrandIdLim9(brandId, (page-1)*9);
    }

    public List<ProductEntity> findProductByName(String name){
        return productRepository.findAllProductsByName(name);
    }

    public List<ProductEntity> findProductByNameAndPage(String name,int page){
        return productRepository.findAllProductsByNameAndPage(name ,(page-1)*9);
    }

}
