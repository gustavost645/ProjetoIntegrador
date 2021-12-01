package br.com.l2g.audit;

import br.com.l2g.entity.Marca;
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

public class MarcaAudit {

    private static Log log = LogFactory.getLog(MarcaAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Marca o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [MARCA AUDIT] About to update: " + o.getIdMarca());
    }

    @PreRemove
    private void beforeRemove(Marca o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [MARCA AUDIT] About to delete: " + o.getIdMarca());
    }

    @PostPersist
    private void afterAdd(Marca o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [MARCA AUDIT] add complete for: " + o.getIdMarca());
    }

    @PostRemove
    private void afterDelete(Marca o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [MARCA AUDIT] delete complete for: " + o.getIdMarca());
    }

    @PostUpdate
    private void afterUpdate(Marca o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [MARCA AUDIT] update complete for: " + o.getIdMarca());
    }
    
    @PostLoad
    private void afterLoad(Marca o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [MARCA AUDIT] search: " + o.getIdMarca());
    }
}
