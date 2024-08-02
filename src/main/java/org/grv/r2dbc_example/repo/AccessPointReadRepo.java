package org.grv.r2dbc_example.repo;

import lombok.extern.slf4j.Slf4j;
import org.grv.r2dbc_example.config.db.DatabaseClientConfig;
import org.grv.r2dbc_example.config.db.R2dbcConfig;
import org.grv.r2dbc_example.entity.AccessPoint;
import org.grv.r2dbc_example.entity.PDOA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class AccessPointReadRepo  {

    private final DatabaseClient databaseClient;


    public AccessPointReadRepo(@Qualifier("replicaDatabaseClient") DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Mono<AccessPoint> findById(Long id) {
        String sql = String.format("SELECT * FROM access_point WHERE id = %d", id);
        return databaseClient.sql(sql)
                .map((row, rowMetadata) -> AccessPoint.builder().cpUrl(row.get("cp_url", String.class))
                        .id(row.get("id", Long.class))
                        .name(row.get("location", String.class))
                        .ssid(row.get("ssid", String.class))
                        .latitude(row.get("latitude",Double.class))
                        .longitude(row.get("longitude", Double.class))
                        .macid(row.get("mac_addr", String.class))
                        .status(row.get("status", String.class))
                        .type(row.get("location_type", String.class))
//                        .pdoaid(row.get("pdoa_id", PDOA.class))
                        .build())
                .one()
                .doOnNext(accessPoint -> log.info("Fetched AccessPoint: {}", accessPoint))
                .doOnError(error -> log.error("Error fetching AccessPoint with id {}: {}", id, error.getMessage()));

    }

}
