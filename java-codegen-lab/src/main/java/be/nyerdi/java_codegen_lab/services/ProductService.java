package be.nyerdi.java_codegen_lab.services;

import be.nyerdi.java_codegen_lab.dtos.ProductDTO;
import be.nyerdi.java_codegen_lab.entities.Product;
import be.nyerdi.java_codegen_lab.mappers.ProductMapper;
import be.nyerdi.java_codegen_lab.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Transactional(readOnly = true)
    public List<ProductDTO> listProducts() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }


    @Transactional
    public ProductDTO createProduct(ProductDTO dto) {
        Product entity = mapper.toEntity(dto);
        Product saved = repository.save(entity);
        return mapper.toDto(saved);
    }
}

