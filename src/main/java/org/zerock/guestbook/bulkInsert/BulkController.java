package org.zerock.guestbook.bulkInsert;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.guestbook.blog.dto.BlogAddArticleRequest;

@RequiredArgsConstructor
@RestController
public class BulkController {

    private final BulkService bulkService;

    @PostMapping("/api/bulkInsert01")
    public ResponseEntity<Product> bulkInsert01(@RequestBody BlogAddArticleRequest request) {
        Product bulkSavedArticle = bulkService.벌크_insert();

        return ResponseEntity.status(HttpStatus.CREATED).body(bulkSavedArticle);
    }

}