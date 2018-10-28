package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="Menu")
public class Menu{
  @Id
	@SequenceGenerator(name="menu_seq",sequenceName="menu_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="menu_seq")
	@Column(name="menuId",unique = true, nullable = true)
	private @NonNull Long menuId;
	private @NonNull String MenuName;
  private @NonNull String picUrl;
    //with Catagories
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catId")
    private Categories catId;
    //with Member
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    private Member memberId;
    //with Meat
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meatId")
    private Meat meatId;
    //with Cooking
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cookingId")
    private Cooking cookingId;
	

    
}
