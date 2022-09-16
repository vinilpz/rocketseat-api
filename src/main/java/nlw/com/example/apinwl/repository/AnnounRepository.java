package nlw.com.example.apinwl.repository;

import nlw.com.example.apinwl.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounRepository extends JpaRepository<Announcement, Long> {
}
