package com.cpe.wongnai_server.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Data
@Entity
@Table(name="creditcard")
public class Creditcard {
    @Id
	@SequenceGenerator(name="creditcard_seq",sequenceName="creditcard_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="creditcard_seq")      
	@Column(name="CREDITCARD_ID",unique = true, nullable = true)
    private @NonNull Long credit_id;
    private @NonNull Long number;
    private @NonNull String bank;

    public Creditcard() {
    }
    public Creditcard(Long credit_id,Long number,String bank) {
        this.credit_id = credit_id;
        this.number = number;
        this.bank = bank;
    }
}