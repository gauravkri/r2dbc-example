package org.grv.r2dbc_example.controller;


import org.grv.r2dbc_example.entity.AccessPoint;
import org.grv.r2dbc_example.service.AccessPointService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class ApController {

    private final AccessPointService accessPointService;

    public ApController(AccessPointService accessPointService) {
        this.accessPointService = accessPointService;
    }


    @GetMapping("accesspoint/{id}")
    public Mono<AccessPoint> transerAccessPoint(@PathVariable Long id){
        return accessPointService.transferAccessPoint(id);
    }


}
