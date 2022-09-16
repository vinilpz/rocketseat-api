package nlw.com.example.apinwl.service;

import nlw.com.example.apinwl.dto.AnnouncementPostDTO;
import nlw.com.example.apinwl.dto.AnnouncementPutDTO;
import nlw.com.example.apinwl.model.Announcement;

public interface AnnouncementServiceImp {

    Announcement create(AnnouncementPostDTO announcementDTO) throws Exception;

    Announcement findByIdOrThrowNotFoundException(Long id);

    void deleteById(Long id);

    void replace(AnnouncementPutDTO announcementPutDto);

}
