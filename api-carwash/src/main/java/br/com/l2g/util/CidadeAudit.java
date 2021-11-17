package br.com.l2g.util;

import br.com.l2g.entity.Cidade;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CidadeAudit {

    private static Log log = LogFactory.getLog(CidadeAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Cidade cidade) {
        log.info("[CIDADE] About to update: " + cidade.getIdCidade());
    }

    @PreRemove
    private void beforeRemove(Cidade cidade) {
        log.info("[CIDADE] About to delete: " + cidade.getIdCidade());
    }

    @PostPersist
    private void afterAdd(Cidade cidade) {
        log.info("[CIDADE AUDIT] add complete for: " + cidade.getIdCidade());
    }

    @PostRemove
    private void afterDelete(Cidade cidade) {
        log.info("[CIDADE AUDIT] delete complete for: " + cidade.getIdCidade());
    }

    @PostUpdate
    private void afterUpdate(Cidade cidade) {
        log.info("[CIDADE AUDIT] update complete for: " + cidade.getIdCidade());
    }
    
    @PostLoad
    private void afterLoad(Cidade cidade) {
        log.info("[CIDADE] search: " + cidade.getIdCidade());
    }
}
