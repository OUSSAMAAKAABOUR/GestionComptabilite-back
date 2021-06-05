package stage.sir.gestioncomptabilite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.sir.gestioncomptabilite.bean.Refresh;

@Repository

public interface RefreshDao extends JpaRepository<Refresh, Long> {
}
