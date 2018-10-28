package com.cpe.wongnai_server.entity;

import lombok.*;
import java.util.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @SequenceGenerator(name = "ingredient_seq",sequenceName = "ingredient_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
    @Column(name = "Iid")
    private @NonNull Long Iid;
    private @NonNull String text;

}
