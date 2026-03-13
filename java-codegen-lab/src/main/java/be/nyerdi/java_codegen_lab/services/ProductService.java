package be.nyerdi.java_codegen_lab.services;

import be.nyerdi.java_codegen_lab.dtos.ProductDTO;
import be.nyerdi.java_codegen_lab.entities.Product;
import be.nyerdi.java_codegen_lab.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;


    @Transactional(readOnly = true)
    public List<ProductDTO> listProducts() {
        return repository.findAll().stream()
                .map(p -> new ProductDTO(p.getId(), p.getLabel(), p.getPrice(), p.getDescription()))
                .toList();
    }


    @Transactional
    public ProductDTO createProduct(ProductDTO dto) {
        Product product = Product.builder()
                .label(dto.label())
                .price(dto.price())
                .description(dto.description())
                .build();

        Product saved = repository.save(product);
        return new ProductDTO(saved.getId(), saved.getLabel(), saved.getPrice(), saved.getDescription());
    }
}

