package br.com.l2g.audit;

import br.com.l2g.entity.Servico;
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

public class ServicoAudit {

    private static Log log = LogFactory.getLog(ServicoAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Servico o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SERVICO AUDIT] About to update: " + o.getIdServico());
    }

    @PreRemove
    private void beforeRemove(Servico o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SERVICO AUDIT] About to delete: " + o.getIdServico());
    }

    @PostPersist
    private void afterAdd(Servico o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SERVICO AUDIT] add complete for: " + o.getIdServico());
    }

    @PostRemove
    private void afterDelete(Servico o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SERVICO AUDIT] delete complete for: " + o.getIdServico());
    }

    @PostUpdate
    private void afterUpdate(Servico o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SERVICO AUDIT] update complete for: " + o.getIdServico());
    }
    
    @PostLoad
    private void afterLoad(Servico o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [SERVICO AUDIT] search: " + o.getIdServico());
    }
}
