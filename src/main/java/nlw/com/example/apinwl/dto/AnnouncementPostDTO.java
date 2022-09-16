package nlw.com.example.apinwl.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AnnouncementPostDTO {

    private Long id;
    private String gameTitle;
    private String gameId;
    private String playerName;
    private Integer yearsPlaying;
    private String discord;
    private String daysOfTheWeek;
    private Integer hoursStart;
    private Integer hoursEnd;
    private Boolean useVoiceChannel;
    private Date createdAd;
}
