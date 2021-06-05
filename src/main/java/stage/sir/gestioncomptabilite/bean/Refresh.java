package stage.sir.gestioncomptabilite.bean;

import javax.persistence.*;

@Entity
public class Refresh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Connection refreshcnx ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Connection getRefreshcnx() {
        return refreshcnx;
    }

    public void setRefreshcnx(Connection refreshcnx) {
        this.refreshcnx = refreshcnx;
    }
}
