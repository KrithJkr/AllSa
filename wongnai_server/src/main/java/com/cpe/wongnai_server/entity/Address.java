package com.cpe.wongnai_server.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Data
@Entity
@Table(name="address")
public class Address {
    @Id
	@SequenceGenerator(name="address_seq",sequenceName="address_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")      
	@Column(name="ADDRESS_ID",unique = true, nullable = true)
    private @NonNull Long province_id;
    private @NonNull String provincename;

    public Address() {
    }
    public Address(Long province_id,String provincename) {
        this.province_id = province_id;
        this.provincename = provincename;
    }
}