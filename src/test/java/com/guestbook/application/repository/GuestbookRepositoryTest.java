package com.guestbook.application.repository;

import com.guestbook.application.entity.GuestBookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import javax.transaction.Transactional;

/**
 * Integration tests for {@link GuestBookRepository}.
 * <p>
 * Bootstraps the application using the {@link com.guestbook.application.GuestBookApplication} configuration class. Enables transaction rollbacks after
 * test methods using the {@link Transactional} annotation.
 *
 * @author Oliver Drotbohm
 * @author Paul Henke
 */
@SpringBootTest
@Transactional
public class GuestbookRepositoryTest{

	@Autowired
	GuestBookRepository repository;

	@Test
	void persistsGuestbookEntry() {
		GuestBookEntity entry = repository.save(new GuestBookEntity(1,"Sachin", "I am a guest"));
		assertThat(repository.findAll()).contains(entry);
	}
}