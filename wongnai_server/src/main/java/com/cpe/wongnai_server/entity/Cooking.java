package com.cpe.wongnai_server.entity;

import lombok.*;
import javax.persistence.*;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="Cooking")
public class Cooking {
   @Id
	  @SequenceGenerator(name="cooking_seq",sequenceName="cooking_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cooking_seq")
  	@Column(name="cookingId",unique = true, nullable = true)
    private @NonNull Long cookingId;
    @Column(length=1024)
  	private  String cookingName;


}
