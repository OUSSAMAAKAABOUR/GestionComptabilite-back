package stage.sir.gestioncomptabilite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.sir.gestioncomptabilite.bean.Refresh;
import stage.sir.gestioncomptabilite.dao.RefreshDao;

import java.util.List;

@Service

public class refreshService {
    @Autowired
    private RefreshDao refreshDao ;

    public List<Refresh> findAll() {
        return refreshDao.findAll();
    }
    public int update(Refresh refresh){
        List<Refresh> refreshlist  = findAll();
        refresh.setId(refreshlist.get(0).getId());
        refreshDao.save(refresh);
        return 1;

    }
}
