package br.com.l2g.audit;

import br.com.l2g.entity.Cidade;
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

public class CidadeAudit {

    private static Log log = LogFactory.getLog(CidadeAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Cidade o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CIDADE AUDIT] About to update: " + o.getIdCidade());
    }

    @PreRemove
    private void beforeRemove(Cidade o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CIDADE AUDIT] About to delete: " + o.getIdCidade());
    }

    @PostPersist
    private void afterAdd(Cidade o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CIDADE AUDIT] add complete for: " + o.getIdCidade());
    }

    @PostRemove
    private void afterDelete(Cidade o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CIDADE AUDIT] delete complete for: " + o.getIdCidade());
    }

    @PostUpdate
    private void afterUpdate(Cidade o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CIDADE AUDIT] update complete for: " + o.getIdCidade());
    }

    @PostLoad
    private void afterLoad(Cidade o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CIDADE AUDIT] search: " + o.getIdCidade());
    }
}
