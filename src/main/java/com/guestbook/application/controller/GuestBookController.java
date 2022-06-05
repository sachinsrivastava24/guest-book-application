package com.guestbook.application.controller;

import com.guestbook.application.entity.GuestBookEntity;
import com.guestbook.application.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @PostMapping("/addGuestBookEntry")
    public GuestBookEntity addGuestEntry(@RequestBody GuestBookEntity guestBookEntity) {
        return guestBookService.saveGuestBook(guestBookEntity);
    }

    @PostMapping("/addGuestBookEntries")
    public List<GuestBookEntity> addGuestEntries(@RequestBody List<GuestBookEntity> guestBookEntries) {
        return guestBookService.saveGuestBookEntries(guestBookEntries);
    }

    @GetMapping("/guestEntries")
    public List<GuestBookEntity> findAllGuestEntry() {
        return guestBookService.getGuestBookEntries();
    }

    @GetMapping("/guestEntryById/{id}")
    public GuestBookEntity findGuestById(@PathVariable int id) {
        return guestBookService.getGuestBookEntryById(id);
    }

    @GetMapping("/guestEntryByName/{name}")
    public GuestBookEntity findGuestByName(@PathVariable String name) {
        return guestBookService.getGuestBookEntryByName(name);
    }

    @PutMapping("/updateGuestBookEntry")
    public GuestBookEntity updateGuestEntry(@RequestBody GuestBookEntity guestBookEntity) {
        return guestBookService.updateGuestBookEntry(guestBookEntity);
    }

    @DeleteMapping("/deleteGuestEntry/{id}")
    public String deleteGuestEntry(@PathVariable int id) {
        return guestBookService.deleteGuestBookEntry(id);
    }
}
