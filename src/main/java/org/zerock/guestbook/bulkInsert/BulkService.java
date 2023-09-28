package org.zerock.guestbook.bulkInsert;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BulkService {
    private static final int COUNT = 10_000;
    //    @Autowired
//    private ProductRepository productRepository;
    private final ProductBulkRepository productBulkRepository;

//    void init() {
//        Product product = new Product("초기", 10_000L);
//        productRepository.save(product);
//    }

//    void 일반_insert() {
//        long startTime = System.currentTimeMillis();
//        for (long i = 2; i <= COUNT; i++) {
//            String title = "이름: " + i;
//            long price = i + 1L;
//            Product product = new Product(title, price);
//            productRepository.save(product);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("---------------------------------");
//        System.out.printf("수행시간: %d\n", endTime - startTime);
//        System.out.println("---------------------------------");
//    }

    Product 벌크_insert() {
        long startTime = System.currentTimeMillis();
        List<Product> products = new ArrayList<>();
        for (long i = 0; i < COUNT; i++) {
            String title = "이름: " + i;
            long price = i + 1L;
            Product product = new Product(title, price);
            products.add(product);
        }
        productBulkRepository.saveAll(products);
        long endTime = System.currentTimeMillis();
        System.out.println("---------------------------------");
        System.out.printf("수행시간: %d\n", endTime - startTime);
        System.out.println("---------------------------------");

        return null;
    }

}