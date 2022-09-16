package nlw.com.example.apinwl.service;

import lombok.RequiredArgsConstructor;
import nlw.com.example.apinwl.dto.AnnouncementPostDTO;
import nlw.com.example.apinwl.dto.AnnouncementPutDTO;
import nlw.com.example.apinwl.exception.NotFoundException;
import nlw.com.example.apinwl.model.Announcement;
import nlw.com.example.apinwl.model.ApiTwitchGame;
import nlw.com.example.apinwl.repository.AnnounRepository;
import nlw.com.example.apinwl.repository.ApiTwitchGamesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AnnouncementService implements AnnouncementServiceImp {

    private final RestTemplate restTemplate;

    private final AnnounRepository repository;

    private final ApiTwitchGamesRepository twitchGamesRepository;

    @Override
    @Transactional
    public Announcement create(AnnouncementPostDTO announcementDTO) throws Exception {

        ApiTwitchGame body = this.restTemplate.getForEntity(
                "https://api.twitch.tv/helix/games?id=" + announcementDTO.getGameId(),
                ApiTwitchGame.class).getBody();

        Announcement announSaved = this.repository.save(new Announcement());

        if (Objects.nonNull(body)) {
            ApiTwitchGame build = ApiTwitchGame.builder()
                    .id(body.getId())
                    .box_art_url(body.getBox_art_url())
                    .title(body.getTitle())
                    .build();

            ApiTwitchGame save = this.twitchGamesRepository.save(build);
            announSaved.setGameId(save);
            return this.repository.save(announSaved);
        }
        throw new Exception("Bad");
    }

    @Override
    public Announcement findByIdOrThrowNotFoundException(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found " + "ID: " + id));
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(findByIdOrThrowNotFoundException(id).getId());
    }

    @Override
    public void replace(AnnouncementPutDTO announcementPutDto) {
        Announcement savedPerson = findByIdOrThrowNotFoundException(announcementPutDto.getId());

        Announcement replacePerson = Announcement.builder()
                .id(savedPerson.getId())
                .name(announcementPutDto.getPlayerName())
                .gameId(new Announcement().getGameId())
                .daysOfTheWeek(announcementPutDto.getDaysOfTheWeek())
                .yearsPlaying(announcementPutDto.getYearsPlaying())
                .hoursStart(announcementPutDto.getHoursStart())
                .hoursEnd(announcementPutDto.getHoursEnd())
                .useVoiceChannel(announcementPutDto.getUseVoiceChannel())
                .createdAd(announcementPutDto.getCreatedAd())
                .build();

        this.repository.save(replacePerson);
    }
}
