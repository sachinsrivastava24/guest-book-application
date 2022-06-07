package com.guestbook.application.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.guestbook.application.entity.GuestBookEntity;
import com.guestbook.application.repository.GuestBookRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Integration tests for {@link GuestBookController}.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class GuestbookControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    GuestBookRepository repository;

    @Test
    void testGetEndPointsForGuestEntryById() throws Exception {
        GuestBookEntity entry = repository.findAll().iterator().next();
        mvc.perform(get("/guestEntryById/{id}", entry.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void testPostEndPointsForAddGuestBookEntry() throws Exception {
        GuestBookEntity entry = repository.findAll().iterator().next();
        mvc.perform(MockMvcRequestBuilders
                .post("/addGuestBookEntry"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPutEndPointsForUpdateGuestBookEntry() throws Exception {
        GuestBookEntity entry = repository.findAll().iterator().next();
        entry.setId(1);
        mvc.perform(MockMvcRequestBuilders
                        .put("/updateGuestBookEntry"))
                .andExpect(status().isBadRequest());
        Assert.assertEquals(1, entry.getId());
    }

    @Test
    void testDeleteEndPointsForDeleteGuestEntry() throws Exception {
        GuestBookEntity entry = repository.findAll().iterator().next();
        mvc.perform(MockMvcRequestBuilders
                        .delete("/deleteGuestEntry/{id}", entry.getId()))
                .andExpect(status().isOk());
    }
}
