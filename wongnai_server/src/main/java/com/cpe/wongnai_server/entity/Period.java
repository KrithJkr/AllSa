package com.cpe.wongnai_server.entity;
import lombok.*;

import java.util.Date;

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
    private @NonNull Date sdate;
    private @NonNull Date edate;
    private @NonNull String Duration;



}