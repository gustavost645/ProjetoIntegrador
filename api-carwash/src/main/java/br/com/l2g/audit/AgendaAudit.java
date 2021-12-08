package br.com.l2g.audit;

import br.com.l2g.entity.Agenda;
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

public class AgendaAudit {

    private static Log log = LogFactory.getLog(AgendaAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Agenda o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [AGENDA AUDIT] About to update: " + o.getIdAgenda());
    }

    @PreRemove
    private void beforeRemove(Agenda o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [AGENDA AUDIT] About to delete: " + o.getIdAgenda());
    }

    @PostPersist
    private void afterAdd(Agenda o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [AGENDA AUDIT] add complete for: " + o.getIdAgenda());
    }

    @PostRemove
    private void afterDelete(Agenda o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [AGENDA AUDIT] delete complete for: " + o.getIdAgenda());
    }

    @PostUpdate
    private void afterUpdate(Agenda o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [AGENDA AUDIT] update complete for: " + o.getIdAgenda());
    }

    @PostLoad
    private void afterLoad(Agenda o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [AGENDA AUDIT] search: " + o.getIdAgenda());
    }
}
