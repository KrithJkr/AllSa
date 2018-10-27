package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Ratings")

public class Rating {
    @Id
    @SequenceGenerator(name = "rating_seq", sequenceName = "rating_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    private @NonNull
    Long rateid;
    private @NonNull
    Long ratinglevel;

}