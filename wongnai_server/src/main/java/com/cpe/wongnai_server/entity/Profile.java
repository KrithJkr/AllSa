package com.cpe.wongnai_server.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @SequenceGenerator(name = "profile_seq", sequenceName = "profile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    @Column(name="PROFILE_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull Long age;

    public Profile() {
    }

    public Profile(Long id,String firstname,String lastname,Long age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "P_NAME")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cnumber")
    private Creditcard creditcard;
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Member_ID")
    private Member member;

}