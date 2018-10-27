package com.cpe.wongnai_server.Repository;

import java.util.List;

import com.cpe.wongnai_server.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByRestaurants_Rid(Long rid);

    @Query("SELECT ROUND(AVG(c.rating),2) FROM Comment c WHERE c.restaurants.rid = :id")
    List<Comment> findAllRating(@Param("id") Long rid);

}