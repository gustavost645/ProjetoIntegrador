package br.com.l2g.audit;

import br.com.l2g.entity.Veiculo;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class VeiculoAudit {

    private static Log log = LogFactory.getLog(VeiculoAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Veiculo o) {
        log.info("[VEICULO AUDIT] About to update: " + o.getIdVeiculos());
    }

    @PreRemove
    private void beforeRemove(Veiculo o) {
        log.info("[VEICULO AUDIT] About to delete: " + o.getIdVeiculos());
    }

    @PostPersist
    private void afterAdd(Veiculo o) {
        log.info("[VEICULO AUDIT] add complete for: " + o.getIdVeiculos());
    }

    @PostRemove
    private void afterDelete(Veiculo o) {
        log.info("[VEICULO AUDIT] delete complete for: " + o.getIdVeiculos());
    }

    @PostUpdate
    private void afterUpdate(Veiculo o) {
        log.info("[VEICULO AUDIT] update complete for: " + o.getIdVeiculos());
    }
    
    @PostLoad
    private void afterLoad(Veiculo o) {
        log.info("[VEICULO AUDIT] search: " + o.getIdVeiculos());
    }
}
