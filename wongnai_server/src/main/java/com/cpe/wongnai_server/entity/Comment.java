package com.cpe.wongnai_server.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Comments")
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    private @NonNull Long cmid;
    private @NonNull String text;
    //private String img;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    private Member members;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rid")
    private Restaurant restaurants;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rateid")
    private Rating rating;
    
}
