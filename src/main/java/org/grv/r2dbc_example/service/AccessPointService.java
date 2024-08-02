package org.grv.r2dbc_example.service;

import org.grv.r2dbc_example.entity.AccessPoint;
import reactor.core.publisher.Mono;

public interface AccessPointService {

    Mono<AccessPoint> transferAccessPoint(Long id);
}
