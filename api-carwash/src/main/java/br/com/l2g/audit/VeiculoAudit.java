package br.com.l2g.audit;

import br.com.l2g.entity.Veiculo;
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

public class VeiculoAudit {

    private static Log log = LogFactory.getLog(VeiculoAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Veiculo o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [VEICULO AUDIT] About to update: " + o.getIdVeiculo());
    }

    @PreRemove
    private void beforeRemove(Veiculo o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [VEICULO AUDIT] About to delete: " + o.getIdVeiculo());
    }

    @PostPersist
    private void afterAdd(Veiculo o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [VEICULO AUDIT] add complete for: " + o.getIdVeiculo());
    }

    @PostRemove
    private void afterDelete(Veiculo o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [VEICULO AUDIT] delete complete for: " + o.getIdVeiculo());
    }

    @PostUpdate
    private void afterUpdate(Veiculo o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [VEICULO AUDIT] update complete for: " + o.getIdVeiculo());
    }
    
    @PostLoad
    private void afterLoad(Veiculo o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [VEICULO AUDIT] search: " + o.getIdVeiculo());
    }
}
