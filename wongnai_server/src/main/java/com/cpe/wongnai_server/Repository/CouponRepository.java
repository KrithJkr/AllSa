package com.cpe.wongnai_server.Repository;
import com.cpe.wongnai_server.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CouponRepository extends JpaRepository<Coupon,Long>{
  Coupon findByCodeName(String codeName);
}