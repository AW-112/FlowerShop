package com.udacity.demoapplication.data.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String CANDY_ID = "candyId";
    private static final String DELIVERY_ID = "deliveryId";

    private static final String SELECT_ALL_CANDY = "SELECT * FROM candy";

    private static final String INSERT_DELIVERY =
            "INSERT INTO candy_delivery (candy_id,delivery_id) " +
            "VALUES (:" + CANDY_ID + ", :" + DELIVERY_ID + ")";

    private static final String FIND_CANDY_BY_DELIVERY =
            "SELECT c.* FROM candy c " +
            "INNER JOIN candy_delivery cd ON candy_id = c.id " +
            "WHERE cd.delivery_id = :deliveryId";

    private static final RowMapper<CandyData> candyDataRowMapper = new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> list() {
        return jdbcTemplate.query(SELECT_ALL_CANDY,candyDataRowMapper);
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryId) {
        jdbcTemplate.update(INSERT_DELIVERY,
                new MapSqlParameterSource()
                    .addValue(CANDY_ID,candyId)
                    .addValue(DELIVERY_ID,deliveryId)
        );
    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryId) {
        return jdbcTemplate.query(
                FIND_CANDY_BY_DELIVERY,
                new MapSqlParameterSource()
                    .addValue(DELIVERY_ID,deliveryId),
                candyDataRowMapper);
    }
}
