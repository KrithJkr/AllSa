package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Rescategory")
public class ResCategory {
    @Id
    @SequenceGenerator(name = "Rescategory_seq", sequenceName = "Rescategory_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Rescategory_seq")
    private @NonNull Long cid;
    private @NonNull String categoryName;
}