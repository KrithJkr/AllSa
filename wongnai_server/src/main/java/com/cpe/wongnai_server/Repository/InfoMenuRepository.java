package com.cpe.wongnai_server.Repository;


import com.cpe.wongnai_server.entity.InfoMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoMenuRepository extends JpaRepository<InfoMenu, Long> {

}
