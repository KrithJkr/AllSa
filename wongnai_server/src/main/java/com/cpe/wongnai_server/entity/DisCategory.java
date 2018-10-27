package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "DisCategory")
public class DisCategory {
    @Id 
    @SequenceGenerator(name = "Discategory_seq", sequenceName = "Discategory_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Discategory_seq")
    private @NonNull Long Tid;
    private @NonNull String Type;

}