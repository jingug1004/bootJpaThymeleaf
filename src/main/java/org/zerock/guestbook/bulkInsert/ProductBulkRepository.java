package org.zerock.guestbook.bulkInsert;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductBulkRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAll(List<Product> products) {
        String sql = "INSERT INTO product (title, price) " +
                "VALUES (?, ?)";

        jdbcTemplate.batchUpdate(sql,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Product product = products.get(i);
                        ps.setString(1, product.getTitle());
                        ps.setLong(2, product.getPrice());
                    }

                    @Override
                    public int getBatchSize() {
                        return products.size();
                    }
                });
    }

}