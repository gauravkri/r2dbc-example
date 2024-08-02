package org.grv.r2dbc_example.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "pdoa",schema = "wani")
public class PDOA implements Serializable {

    private static final long serialVersionUID = 8835220699504258700L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long pdoaPK;
    @Column(name = "cr_pdoa_id")
    private String id;
    @Column(name = "ap_url")
    private String apUrl;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "rating")
    private String rating;
    @Column(name = "status")
    private String status;
    @Column(name = "exp")
    private String exp;
    @Lob
    @Column(name = "value")
    private String value;
}
