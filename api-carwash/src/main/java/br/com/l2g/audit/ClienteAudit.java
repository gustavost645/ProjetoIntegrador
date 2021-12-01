package br.com.l2g.audit;

import br.com.l2g.entity.Cliente;
import br.com.l2g.util.Utilitarios;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ClienteAudit {

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Cliente o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CLIENTE AUDIT] About to update: " + o.getIdCliente());
    }

    @PreRemove
    private void beforeRemove(Cliente o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CLIENTE AUDIT] About to delete: " + o.getIdCliente());
    }

    @PostPersist
    private void afterAdd(Cliente o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CLIENTE AUDIT] add complete for: " + o.getIdCliente());
    }

    @PostRemove
    private void afterDelete(Cliente o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CLIENTE AUDIT] delete complete for: " + o.getIdCliente());
    }

    @PostUpdate
    private void afterUpdate(Cliente o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CLIENTE AUDIT] update complete for: " + o.getIdCliente());
    }

    @PostLoad
    private void afterLoad(Cliente o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [CLIENTE AUDIT] search: " + o.getIdCliente());
    }
}
