package br.com.l2g.audit;

import br.com.l2g.entity.TipoPagamento;
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

public class TipoPagamentoAudit {

    private static Log log = LogFactory.getLog(TipoPagamentoAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(TipoPagamento o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [TIPO_PAGAMENTO AUDIT] About to update: " + o.getIdTipoPagamento());
    }

    @PreRemove
    private void beforeRemove(TipoPagamento o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [TIPO_PAGAMENTO AUDIT] About to delete: " + o.getIdTipoPagamento());
    }

    @PostPersist
    private void afterAdd(TipoPagamento o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [TIPO_PAGAMENTO AUDIT] add complete for: " + o.getIdTipoPagamento());
    }

    @PostRemove
    private void afterDelete(TipoPagamento o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [TIPO_PAGAMENTO AUDIT] delete complete for: " + o.getIdTipoPagamento());
    }

    @PostUpdate
    private void afterUpdate(TipoPagamento o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [TIPO_PAGAMENTO AUDIT] update complete for: " + o.getIdTipoPagamento());
    }
    
    @PostLoad
    private void afterLoad(TipoPagamento o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [TIPO_PAGAMENTO AUDIT] search: " + o.getIdTipoPagamento());
    }
}
