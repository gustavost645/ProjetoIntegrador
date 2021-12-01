package br.com.l2g.audit;

import br.com.l2g.entity.Setor;
import br.com.l2g.util.Utilitarios;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SetorAudit {

    private static Log log = LogFactory.getLog(SetorAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Setor o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SETOR AUDIT] About to update: " + o.getIdSetor());
    }

    @PreRemove
    private void beforeRemove(Setor o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SETOR AUDIT] About to delete: " + o.getIdSetor());
    }

    @PostPersist
    private void afterAdd(Setor o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SETOR AUDIT] add complete for: " + o.getIdSetor());
    }

    @PostRemove
    private void afterDelete(Setor o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SETOR AUDIT] delete complete for: " + o.getIdSetor());
    }

    @PostUpdate
    private void afterUpdate(Setor o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SETOR AUDIT] update complete for: " + o.getIdSetor());
    }
    
    @PostLoad
    private void afterLoad(Setor o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SETOR AUDIT] search: " + o.getIdSetor());
    }
}
