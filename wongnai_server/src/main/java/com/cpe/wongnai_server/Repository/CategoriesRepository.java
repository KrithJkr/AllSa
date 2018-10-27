package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
