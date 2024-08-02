package org.grv.r2dbc_example.service;

import org.grv.r2dbc_example.entity.AccessPoint;
import org.grv.r2dbc_example.repo.AccessPointReadRepo;
import org.grv.r2dbc_example.repo.AccessPointWirteRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccessPointServiceImpl implements AccessPointService {

    private final AccessPointReadRepo accessPointReadRepo;
    private final AccessPointWirteRepo accessPointWirteRepo;

    public AccessPointServiceImpl(AccessPointReadRepo accessPointReadRepo, AccessPointWirteRepo accessPointWirteRepo) {
        this.accessPointReadRepo = accessPointReadRepo;
        this.accessPointWirteRepo = accessPointWirteRepo;
    }

    public Mono<AccessPoint> transferAccessPoint(Long id){
       return accessPointReadRepo.findById(id)
                .flatMap(accessPointWirteRepo::save);
    }

}
