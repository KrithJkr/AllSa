package com.cpe.wongnai_server.entity;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="Categories")
public class Categories {
  @Id
  @SequenceGenerator(name="categories_seq",sequenceName="categories_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categories_seq")
  @Column(name = "catId", unique = true, nullable = true)
  private @NonNull Long catid;
  private @NonNull String catName;


}
