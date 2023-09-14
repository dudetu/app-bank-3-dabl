package com.example.appbank2.service;
import com.example.appbank2.entity.Product;
import com.example.appbank2.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Arrange
        when(productRepository.findAll()).thenReturn(List.of(
                new Product(), new Product()
        ));

        // Act
        List<Product> products = productService.getAllProducts();

        // Assert
        assertThat(products).hasSize(2);
    }

    @Test
    void testGetProductById_ExistingProduct() {
        // Arrange
        Long productId = 1L;
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Act
        Product result = productService.getProductById(productId);

        // Assert
        assertThat(result).isEqualTo(product);
    }

    @Test
    void testGetProductById_NonExistingProduct() {
        // Arrange
        Long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThat(productService.getProductById(productId)).isNull();
    }

    @Test
    void testCreateProduct() {
        // Arrange
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        // Act
        Product result = productService.createProduct(product);

        // Assert
        assertThat(result).isEqualTo(product);
    }
}
