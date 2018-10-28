package com.cpe.wongnai_server.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "infomenu")
public class InfoMenu {
        @Id
        @SequenceGenerator(name = "Infomenu_seq",sequenceName = "Infomenu_seq")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Infomenu_seq")
    @Column(name = "Mid")
    private @NonNull Long Mid;
    private Double cal;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Sid")
    private Story stext;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Iid")
    private Ingredient text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nid")
    private Nutrition nutrition;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "infomenuid")
    private Menu menus;

}
