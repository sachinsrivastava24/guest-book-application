package com.guestbook.application.service;

import com.guestbook.application.entity.GuestBookEntity;
import com.guestbook.application.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookService {

    @Autowired
    private GuestBookRepository guestBookRepository;

    public GuestBookEntity saveGuestBook(GuestBookEntity guestBookEntity) {
        return guestBookRepository.save(guestBookEntity);
    }

    public List<GuestBookEntity> saveGuestBookEntries(List<GuestBookEntity> guestBookEntries) {
        return guestBookRepository.saveAll(guestBookEntries);
    }

    /**
     * Find all the guest entry from database
     * @return
     */
    public List<GuestBookEntity> getGuestBookEntries() {
        return guestBookRepository.findAll();
    }

    /***
     * Find the entry by ID if ID is not available return user details as null
     * @param id
     * @return
     */
    public GuestBookEntity getGuestBookEntryById(int id) {
        return guestBookRepository.findById(id).orElse(null);
    }

    /***
     * Find the guest user entry by Name
     * @param name
     * @return
     */
    public GuestBookEntity getGuestBookEntryByName(String name) {
        return guestBookRepository.findByName(name);
    }

    /***
     * Delete the guest user entry by ID
     * @param id
     * @return
     */
    public String deleteGuestBookEntry(int id) {
         guestBookRepository.deleteById(id);
         return "User Entry removed :" +id;
    }

    /***
     * Update the guest existing entry against guest ID
     * @param guestBookEntity
     * @return
     */
    public GuestBookEntity updateGuestBookEntry(GuestBookEntity guestBookEntity) {
        GuestBookEntity existingEntry = guestBookRepository.findById(guestBookEntity.getId())
                .orElse(null);
        existingEntry.setName(guestBookEntity.getName());
        existingEntry.setText(guestBookEntity.getText());
        return guestBookRepository.save(existingEntry);
    }
}
