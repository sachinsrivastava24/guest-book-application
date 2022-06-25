package com.guestbook.application.repository;

import com.guestbook.application.entity.GuestBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestBookRepository extends JpaRepository<GuestBookEntity, Integer> {
    List<GuestBookEntity> findByName(String name);
}
