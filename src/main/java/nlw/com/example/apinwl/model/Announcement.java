package nlw.com.example.apinwl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private Integer yearsPlaying;
    @NotEmpty
    private String discord;
    @NotEmpty
    private String daysOfTheWeek;
    @NotEmpty
    private Integer hoursStart;
    @NotEmpty
    private Integer hoursEnd;
    @NotEmpty
    private Boolean useVoiceChannel;
    @NotEmpty
    private Date createdAd;
    // Many ADs to One game
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_game")
    private ApiTwitchGame gameId;

}
