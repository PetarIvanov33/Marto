package com.example.nobsv2exam.product;

//import com.example.nobsv2exam.product.model.GetProductsRequest;
import com.example.nobsv2exam.product.model.Product;
import com.example.nobsv2exam.product.model.ProductDTO;
import com.example.nobsv2exam.product.services.CreateProductService;
import com.example.nobsv2exam.product.services.GetProductService;
//import com.example.nobsv2exam.product.services.GetProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductService getProductService;
//    private final GetProductsService getProductsService;

    public ProductController(CreateProductService createProductService, GetProductService getProductService) {
        this.createProductService = createProductService;
        this.getProductService = getProductService;
//        this.getProductsService = getProductsService;
    }


    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
        return createProductService.execute(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id){
        return getProductService.execute(id);
    }

//    @GetMapping("/products")
//    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam(required = false) String search,
//                                                        @RequestParam(required = false) String category,
//                                                        @RequestParam(required = false) String orderBy){
//        return getProductsService.execute(new GetProductsRequest(search, category, orderBy));
//    }

}
