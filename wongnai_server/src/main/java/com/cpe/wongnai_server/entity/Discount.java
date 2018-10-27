package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Discount")
public class Discount {
    @Id 
    @SequenceGenerator(name = "discount_seq", sequenceName = "discount_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_seq")
    private @NonNull Long Id;
    private @NonNull String Name;
    private @NonNull String Title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
    @JoinColumn(name = "rid", insertable = true)
    private  Restaurant Restaurants;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DisCategory.class)
    @JoinColumn(name = "tid", insertable = true)
    private  DisCategory DiscountCategory;

}