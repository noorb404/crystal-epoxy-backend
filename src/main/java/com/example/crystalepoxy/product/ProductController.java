package com.example.crystalepoxy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = {"https://crystal-epoxy-frontend.herokuapp.com/"})
@RequestMapping(path="/")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {

        List<Product> products = productService.getProductsByCategory(category);
        return products;

    }

    @PostMapping("products/add")
    public void AddProduct(@RequestBody ProductRequest productRequest) {
        Product product = new Product(
                productRequest.getName(),
                productRequest.getDescriptions(),
                productRequest.getWidth(),
                productRequest.getHeight(),
                productRequest.getLength(),
                productRequest.getPrice(),
                productRequest.getCategory(),
                productRequest.getImage()
        );

        productService.addProduct(product);
    }

    @DeleteMapping(path="{productId}")
    public void deleteProduct(@PathVariable("productId") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long id,
            @RequestBody Product product){
        productService.updateProduct(id,product.getName(),product.getDescriptions(),product.getPrice(),product.getLength(),product.getHeight(),product.getWidth(),product.getCategory());
    }

}
