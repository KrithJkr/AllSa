package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Restaurant")

public class Restaurant {
    @Id
    @SequenceGenerator(name = "restaurant_seq", sequenceName = "restaurant_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    private @NonNull
    Long rid;
    private @NonNull String address;
    private @NonNull
    String restaurantName;
    private @NonNull String restaurantImg;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ResCategory.class)
    @JoinColumn(name = "cid", insertable = true)
    private ResCategory categories;
}
