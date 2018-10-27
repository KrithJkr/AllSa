package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Creditcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CreditcardRepository extends JpaRepository<Creditcard, Long > {
    Creditcard findByBank(String bank);
    Creditcard findByNumber(Long number);
}