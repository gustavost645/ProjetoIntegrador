package br.com.l2g.audit;

import br.com.l2g.entity.Servico;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServicoAudit {

    private static Log log = LogFactory.getLog(ServicoAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Servico o) {
        log.info("[SERVICO AUDIT] About to update: " + o.getIdServico());
    }

    @PreRemove
    private void beforeRemove(Servico o) {
        log.info("[SERVICO AUDIT] About to delete: " + o.getIdServico());
    }

    @PostPersist
    private void afterAdd(Servico o) {
        log.info("[SERVICO AUDIT] add complete for: " + o.getIdServico());
    }

    @PostRemove
    private void afterDelete(Servico o) {
        log.info("[SERVICO AUDIT] delete complete for: " + o.getIdServico());
    }

    @PostUpdate
    private void afterUpdate(Servico o) {
        log.info("[SERVICO AUDIT] update complete for: " + o.getIdServico());
    }
    
    @PostLoad
    private void afterLoad(Servico o) {
        log.info("[SERVICO AUDIT] search: " + o.getIdServico());
    }
}
