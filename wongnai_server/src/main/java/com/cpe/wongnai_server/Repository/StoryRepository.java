package com.cpe.wongnai_server.Repository;
import com.cpe.wongnai_server.entity.Story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story,Long> {
	Story findByStext(String stext);
}
