package nlw.com.example.apinwl.repository;

import nlw.com.example.apinwl.model.ApiTwitchGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiTwitchGamesRepository extends JpaRepository<ApiTwitchGame, Long> {
}
