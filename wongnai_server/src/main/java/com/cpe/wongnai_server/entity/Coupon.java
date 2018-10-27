package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Coupon")
public class Coupon {
    @Id 
    @SequenceGenerator(name = "coupon_seq", sequenceName = "coupon_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_seq")
    private @NonNull Long Cid;
    private @NonNull String code;

    
}