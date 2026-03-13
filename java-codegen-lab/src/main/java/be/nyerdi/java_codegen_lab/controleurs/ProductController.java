package be.nyerdi.java_codegen_lab.controleurs;

import be.nyerdi.java_codegen_lab.dtos.ProductDTO;
import be.nyerdi.java_codegen_lab.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Product", description = "API de gestion du catalogue produits (PostgreSQL)")
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Récupérer tous les produits",
            description = "Retourne la liste complète des produits stockés en base de données PostgreSQL"
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getAll() {
        return productService.listProducts();
    }

    @Operation(
            summary = "Créer un produit",
            description = "Valide et enregistre un nouveau produit. Renvoie l'objet créé avec son ID généré."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@Valid @RequestBody ProductDTO dto) {
        return productService.createProduct(dto);
    }
}

