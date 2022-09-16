package nlw.com.example.apinwl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ApiTwitchGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String box_art_url;
    // One game to Many ADs
    @OneToOne(cascade = CascadeType.ALL)
    private Announcement announcement;

}
