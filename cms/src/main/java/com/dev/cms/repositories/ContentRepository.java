package com.dev.cms.repositories;

import com.dev.cms.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query("select c from Content c join c.tags t where t.id = :tagId")
    List<Content> findContentsByTagId(Long tagId);
}
