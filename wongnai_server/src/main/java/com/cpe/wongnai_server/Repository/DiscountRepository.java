package com.cpe.wongnai_server.Repository;


import com.cpe.wongnai_server.entity.Discount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public
interface DiscountRepository extends JpaRepository<Discount,Long>{
  List<Discount> findByDiscountrestaurant_Rid(Long rid);
}
