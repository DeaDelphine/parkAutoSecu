package com.assosetvous.assosetvous.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Entity
@Table(name="IMAGE")
public class Image {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    @Column(name = "IDIMAGE")
    private Long id;
    @Column(name = "DESCRIPTIF")
    private String descriptif;
    @Column(name = "URL")
    private String url;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="vehicule_id")
    private Vehicule vehicule;
}
