package br.com.l2g.audit;

import br.com.l2g.entity.ArqLog;
import br.com.l2g.entity.Cliente;
import br.com.l2g.repository.ArqLogRepository;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ClienteAudit {
    
    ArqLogRepository repository;
    
    @PrePersist
    @PreUpdate
    private void beforeUpdate(Cliente o) {
        salvarLog("[CLIENTE AUDIT] About to update: " + o.getIdCliente());
    }

    @PreRemove
    private void beforeRemove(Cliente o) {
        salvarLog("[CLIENTE AUDIT] About to delete: " + o.getIdCliente());
    }

    @PostPersist
    private void afterAdd(Cliente o) {
        salvarLog("[CLIENTE AUDIT] add complete for: " + o.getIdCliente());
    }

    @PostRemove
    private void afterDelete(Cliente o) {
        salvarLog("[CLIENTE AUDIT] delete complete for: " + o.getIdCliente());
    }

    @PostUpdate
    private void afterUpdate(Cliente o) {
        salvarLog("[CLIENTE AUDIT] update complete for: " + o.getIdCliente());
    }

    @PostLoad
    private void afterLoad(Cliente o) {
        salvarLog("[CLIENTE AUDIT] search: " + o.getIdCliente());
    }

    private void salvarLog(String descricao) {
        ArqLog log = new ArqLog();
        log.setTabelaLog("cliente");
        log.setDescricaoLog(descricao);               
        repository.save(log);
        //logService.save(log);
    }

}
