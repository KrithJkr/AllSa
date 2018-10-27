package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MemberRepository extends JpaRepository<Member, Long> {
}
