package org.grv.r2dbc_example.repo;

import lombok.extern.slf4j.Slf4j;
import org.grv.r2dbc_example.entity.AccessPoint;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class AccessPointWirteRepo {

    private final DatabaseClient databaseClient;

    public AccessPointWirteRepo(@Qualifier("masterDatabaseClient") DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Mono<AccessPoint> save(AccessPoint entity) {
        String sql = String.format("INSERT INTO access_point (id,cp_url, latitude, longitude, mac_addr, ssid, status, location, location_type) " +
                        "VALUES ('%s','%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                entity.getId(),
                entity.getCpUrl(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getMacid(),
                entity.getSsid(),
                entity.getStatus(),
                entity.getName(),
                entity.getType());
        return databaseClient.sql(sql)
                .fetch()
                .rowsUpdated()
                .doOnSuccess(count -> log.info("Inserted {} row(s)", count))
                .doOnError(error -> log.error("Error occurred while inserting: {}", error.getMessage()))
                .then(Mono.just(entity));
    }

}
