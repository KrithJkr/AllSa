package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Period")
public class Period {
    @Id 
    @SequenceGenerator(name = "period_seq", sequenceName = "period_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "period_seq")
    private @NonNull Long Pid;
    private @NonNull String Sdate;
    private @NonNull String Edate;
    private @NonNull String Duration;
}