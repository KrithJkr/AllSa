package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Cooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CookingRepository extends JpaRepository<Cooking, Long> {
  Cooking findByCookingName(String cookingName);
}
