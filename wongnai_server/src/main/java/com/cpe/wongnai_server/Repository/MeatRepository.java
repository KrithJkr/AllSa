package com.cpe.wongnai_server.Repository;
import com.cpe.wongnai_server.entity.Meat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MeatRepository extends JpaRepository<Meat, Long> {
}
