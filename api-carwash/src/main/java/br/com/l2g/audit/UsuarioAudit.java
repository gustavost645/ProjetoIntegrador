package br.com.l2g.audit;

import br.com.l2g.entity.Usuario;
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

public class UsuarioAudit {

    private static Log log = LogFactory.getLog(UsuarioAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Usuario o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [USUARIO AUDIT] About to update: " + o.getIdUsuario());
    }

    @PreRemove
    private void beforeRemove(Usuario o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [USUARIO AUDIT] About to delete: " + o.getIdUsuario());
    }

    @PostPersist
    private void afterAdd(Usuario o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [USUARIO AUDIT] add complete for: " + o.getIdUsuario());
    }

    @PostRemove
    private void afterDelete(Usuario o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [USUARIO AUDIT] delete complete for: " + o.getIdUsuario());
    }

    @PostUpdate
    private void afterUpdate(Usuario o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [USUARIO AUDIT] update complete for: " + o.getIdUsuario());
    }
    
    @PostLoad
    private void afterLoad(Usuario o) {
        Utilitarios.salvaTxt("log.txt", Utilitarios.dataHora()+ " - [USUARIO AUDIT] search: " + o.getIdUsuario());
    }
}
