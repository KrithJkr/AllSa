package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ProfileRepository extends JpaRepository<Profile, Long> {

}