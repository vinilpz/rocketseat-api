package nlw.com.example.apinwl.controller;

import lombok.RequiredArgsConstructor;
import nlw.com.example.apinwl.dto.AnnouncementPostDTO;
import nlw.com.example.apinwl.dto.AnnouncementPutDTO;
import nlw.com.example.apinwl.model.Announcement;
import nlw.com.example.apinwl.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Announcement save(@Valid @RequestBody AnnouncementPostDTO announcementDTO) throws Exception {
        return this.announcementService.create(announcementDTO);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/games/id/{id}/ads")
    public Announcement findById(@PathVariable Long id) {
        return this.announcementService.findByIdOrThrowNotFoundException(id);
    }

    @DeleteMapping(value = "/games/id/{id}/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        this.announcementService.deleteById(id);
    }

    @PutMapping(path = "/games/replace/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void edit(@RequestBody AnnouncementPutDTO personPutRequestBody) {
        this.announcementService.replace(personPutRequestBody);
    }

}
