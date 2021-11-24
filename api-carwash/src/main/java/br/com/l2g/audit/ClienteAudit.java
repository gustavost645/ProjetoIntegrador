package br.com.l2g.audit;

import br.com.l2g.entity.Cliente;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClienteAudit {

    private static Log log = LogFactory.getLog(ClienteAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Cliente o) {
        log.info("[CLIENTE AUDIT] About to update: " + o.getIdCliente());
    }

    @PreRemove
    private void beforeRemove(Cliente o) {
        log.info("[CLIENTE AUDIT] About to delete: " + o.getIdCliente());
    }

    @PostPersist
    private void afterAdd(Cliente o) {
        log.info("[CLIENTE AUDIT] add complete for: " + o.getIdCliente());
    }

    @PostRemove
    private void afterDelete(Cliente o) {
        log.info("[CLIENTE AUDIT] delete complete for: " + o.getIdCliente());
    }

    @PostUpdate
    private void afterUpdate(Cliente o) {
        log.info("[CLIENTE AUDIT] update complete for: " + o.getIdCliente());
    }
    
    @PostLoad
    private void afterLoad(Cliente o) {
        log.info("[CLIENTE AUDIT] search: " + o.getIdCliente());
    }
}
