package stage.sir.gestioncomptabilite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.sir.gestioncomptabilite.bean.Comptable;
import stage.sir.gestioncomptabilite.bean.Connection;
import stage.sir.gestioncomptabilite.bean.Login;
import stage.sir.gestioncomptabilite.bean.Societe;
import stage.sir.gestioncomptabilite.dao.ConnectionDao;

import java.util.List;

@Service

public class ConnectionService {
    @Autowired
    private ConnectionDao connectionDao;
    @Autowired
    private SocieteService societeService;

    public List<Connection> findByType(String type) {
        return connectionDao.findByType(type);
    }

    public int deleteByType(String type) {
        return connectionDao.deleteByType(type);
    }

    public int deleteByUsername(String username) {
        return connectionDao.deleteByUsername(username);
    }

    public Connection findByUsernameAndPassword(String username, String password) {
        return connectionDao.findByUsernameAndPassword(username, password);
    }
    public int associer(String username, String password, String ref){
        Connection login = findByUsernameAndPassword(username, password);
        Societe societelogin = societeService.findByIce(ref);
        if (login == null) return -1;
        if (societelogin == null) return -2;
        else {
        login.setSocieteLogin(societelogin);
        return 1;}
    }

    public int loger(String username, String password) {
        Connection login = findByUsernameAndPassword(username, password);
        if (login == null) return -1;

        else if (login.getEtat().equals("valider") && login.getType().equals("Societe") ) return  1;
        else if (login.getEtat().equals("valider") && login.getType().equals("admin") ) return  2;
        else if (login.getEtat().equals("valider") && login.getType().equals("comptable") ) return  3;
        else if (login.getEtat().equals("en cour") ) return  0;
        else {
            return -2;
        }
    }

    public List<Connection> findByUsername(String usename) {
        return connectionDao.findByUsername(usename);
    }

    public List<Connection> findAll() {
        return connectionDao.findAll();
    }

    public int save(Connection connection) {
        if (connectionDao.findByUsernameAndPassword(connection.getUsername(), connection.getPassword()) != null) {
            return -1;
        } else {
            connection.setEtat("en cour");
            connection.setType("Societe");
            connection.setSocieteLogin(null);
            connection.setComptable(null);
            connectionDao.save(connection);
            return 1;
        }

    }
    public int update(Connection connection,String ref) {
        Societe societelogin = societeService.findByIce(ref);
        if (societelogin == null) return -1;
        connection.setSocieteLogin(societelogin);
            connectionDao.save(connection);
            return 1;


    }
    public int etatLogin(String username, String password){
        Connection login = findByUsernameAndPassword(username, password);
        if(login.getSocieteLogin() == null) return -1;
        else {

            return 1;
        }
    }

    public int save2(Connection connection, Comptable comptable) {
        if (connectionDao.findByUsernameAndPassword(connection.getUsername(), connection.getPassword()) != null) {
            return -1;
        } else {
            connection.setEtat("valider");
            connection.setType("Comptable");
            connection.setSocieteLogin(null);
            connection.setComptable(comptable);
            connectionDao.save(connection);
            return 1;
        }

    }
    public int validatecompte(Connection connection){
        Connection connection1 = connectionDao.findByUsernameAndPassword(connection.getUsername(),connection.getPassword());
        connection.setId(connection1.getId());
        connection.setEtat("valider");
        connectionDao.save(connection);
        return 1;
    }
    public int refusecompte(Connection connection){
        Connection connection1 = connectionDao.findByUsernameAndPassword(connection.getUsername(),connection.getPassword());
        connection.setId(connection1.getId());
        connection.setEtat("refuser");
        connectionDao.save(connection);
        return 1;
    }

    public List<Connection> findByEtat(String etat) {
        return connectionDao.findByEtat(etat);
    }

    public Connection findByComptableCode(String code) {
        return connectionDao.findByComptableCode(code);
    }
}
