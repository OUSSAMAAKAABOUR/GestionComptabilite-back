package stage.sir.gestioncomptabilite.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.sir.gestioncomptabilite.bean.OperationSociete;
import stage.sir.gestioncomptabilite.service.OperationSocieteService;

import java.util.List;

@RestController
@RequestMapping(value = "gestion-comptabilite/operationSociete")
public class OperationSocieteProvided {
    @Autowired
    private OperationSocieteService operationSocieteService;
    @GetMapping("/ref/{ref}")
    public OperationSociete findByRef(@PathVariable String ref) {
        return operationSocieteService.findByRef(ref);
    }
    @GetMapping("/ice/{ice}")
    public List<OperationSociete> findBySocieteIce(@PathVariable String ice) {
        return operationSocieteService.findBySocieteIce(ice);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return operationSocieteService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<OperationSociete> findAll() {
        return operationSocieteService.findAll();
    }
    @PostMapping("/")
    public int saveAlone(@RequestBody OperationSociete operationSociete) {
        return operationSocieteService.saveAlone(operationSociete);
    }
    @GetMapping("/etatoperationsociete/ref/{etat}")
    public List<OperationSociete> findByEtatOperationSocieteRef(@PathVariable String etat) {
        return operationSocieteService.findByEtatOperationSocieteRef(etat);
    }
    @PutMapping("/validate")
    public int validateOperation(@RequestBody OperationSociete operationSociete) {
        return operationSocieteService.validateOperation(operationSociete);
    }
    @PutMapping("/refuse")
    public int refuseOperation(@RequestBody OperationSociete operationSociete) {
        return operationSocieteService.refuseOperation(operationSociete);
    }
    @PutMapping("/validateOperationComptable")
    public int validateOperationComptable(@RequestBody OperationSociete operationSociete) {
        return operationSocieteService.validateOperationComptable(operationSociete);
    }
    @PutMapping("/refuseOperationComptable/message/{message}")
    public int refuseOperationComptable(@RequestBody OperationSociete operationSociete,@PathVariable String message) {
        return operationSocieteService.refuseOperationComptable(operationSociete, message);
    }

    @GetMapping("/findoperationwherecomptablenull")
    public List<OperationSociete> findOperationPourAffecterComptable() {
        return operationSocieteService.findOperationPourAffecterComptable();
    }
    @PutMapping("/comptabletraiteur")
    public int affecterComptableTraiteur(@RequestBody OperationSociete operationSociete) {
        return operationSocieteService.affecterComptableTraiteur(operationSociete);
    }
    @PutMapping("/comptablevalidateur")
    public int affecterComptableValidateur(@RequestBody OperationSociete operationSociete) {
        return operationSocieteService.affecterComptableValidateur(operationSociete);
    }
    @GetMapping("/trvoperationforcomptable/code/{code}")
    public List<OperationSociete> findByComptableTaiteurCode(@PathVariable String code) {
        return operationSocieteService.findByComptableTaiteurCode(code);
    }
    @GetMapping("/trvoperationforcomptablevalidateur/code/{code}")
    public List<OperationSociete> findByComptableValidateurCode(@PathVariable String code) {
        return operationSocieteService.findByComptableValidateurCode(code);
    }
}
