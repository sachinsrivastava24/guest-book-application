package com.guestbook.application.repository;

import com.guestbook.application.entity.GuestBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<GuestBookEntity, Integer> {
    GuestBookEntity findByName(String name);
}
