package com.dev.cms.repositories;

import com.dev.cms.entities.Tag;
import org.springframework.core.metrics.StartupStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<StartupStep.Tags, Long> {
    @Query("select t from Tag t join t.contents c where c.id = :contentId")
    List<Tag> findTagsByContentId(Long contentId);
}
