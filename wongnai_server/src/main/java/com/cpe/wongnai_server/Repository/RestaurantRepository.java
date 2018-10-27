package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Restaurant findByRestaurantName(String restaurantName);
}