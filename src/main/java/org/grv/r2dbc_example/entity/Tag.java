package org.grv.r2dbc_example.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Entity
@Table(schema = "wani", name = "access_point_tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 7827690368258017608L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "ap_id")
    private AccessPoint ap;
}
