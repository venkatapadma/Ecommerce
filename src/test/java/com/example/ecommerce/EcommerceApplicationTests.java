package com.example.ecommerce;

import com.example.ecommerce.repo.ProductSearchRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ActiveProfiles("test")
class EcommerceApplicationTests {

    @MockitoBean
    private ProductSearchRepo productSearchRepo;

    @Test
    void contextLoads() {
    }

}
