package com.cpe.wongnai_server.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="Meat")
public class Meat {
  @Id
  @SequenceGenerator(name="meat_seq",sequenceName="meat_seq")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="meat_seq")
  @Column(name="meatId",unique = true, nullable = true)
  private @NonNull Long meatId;
  private @NonNull String meatName;
}
