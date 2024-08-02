package org.grv.r2dbc_example.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Builder
@Data
@Entity
@Table(schema = "wani",name = "access_point")
public class AccessPoint {

    private static final long serialVersionUID = -2952600829946862314L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "cp_url")
    private String cpUrl;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "mac_addr")
    private String macid;
    @Column(name = "ssid")
    private String ssid;
    @Column(name = "status")
    private String status;
    @Column(name = "location")
    private String name;
    @Column(name = "location_state")
    private String locationState;
    @Column(name = "location_type")
    private String type;
    @OneToOne
    @JoinColumn(name = "pdoa_id")
    private PDOA pdoaid;
    @OneToMany(mappedBy = "ap",cascade = CascadeType.ALL)
    private List<Tag> tags;
}
