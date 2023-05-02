package com.example.crystalepoxy.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void updateProduct(Long id, String name, List<ProductDescription> description, Integer price,Integer Length,Integer Height,Integer Width, String category) {
        if(!productRepository.existsById(id)){
            throw new IllegalStateException("product not found");
        }
        Product product = productRepository.findById(id).orElseThrow(()-> new IllegalStateException("Product Id not found"));
        if(name!=null){
            if(product!=null && name.length()>0 && !Objects.equals(product.getName(),name)){
                product.setName(name);
            }
        }
        if(description!=null) {
            if (product != null && !description.isEmpty() && !Objects.equals(product.getDescriptions(), description)) {
                product.setDescriptions(description);
            }
        }
        if(price!=null) {
            if (product != null && price != null && !Objects.equals(product.getPrice(), price)) {
                product.setPrice(price);
            }
        }
        if(Length!=null) {
            if (product != null && Length!=null && !Objects.equals(product.getLength(), Length)) {
                product.setLength(Length);
            }
        }
        if(Height!=null) {
            if (product != null && Height!=null && !Objects.equals(product.getHeight(), Height)) {
                product.setHeight(Height);
            }
        }
        if(Width!=null) {
            if (product != null && Width!=null && !Objects.equals(product.getWidth(), Width)) {
                product.setWidth(Width);
            }
        }
        if(category!=null) {
            if (product != null && category.length() > 0 && !Objects.equals(product.getCategory(), category)) {
                product.setCategory(category);
            }
        }

    }

    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id))
            throw new IllegalStateException("User id not found");
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findProductByCategory(category);
    }
}
