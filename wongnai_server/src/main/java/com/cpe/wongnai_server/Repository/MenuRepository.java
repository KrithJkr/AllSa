package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MenuRepository extends JpaRepository<Menu, Long> {
}
