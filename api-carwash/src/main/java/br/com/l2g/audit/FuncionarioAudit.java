package br.com.l2g.audit;

import br.com.l2g.entity.Funcionario;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FuncionarioAudit {

    private static Log log = LogFactory.getLog(FuncionarioAudit.class);

    @PrePersist
    @PreUpdate
    private void beforeUpdate(Funcionario o) {
        log.info("[FUNCIONARIO AUDIT] About to update: " + o.getIdFuncionario());
    }

    @PreRemove
    private void beforeRemove(Funcionario o) {
        log.info("[FUNCIONARIO AUDIT] About to delete: " + o.getIdFuncionario());
    }

    @PostPersist
    private void afterAdd(Funcionario o) {
        log.info("[FUNCIONARIO AUDIT] add complete for: " + o.getIdFuncionario());
    }

    @PostRemove
    private void afterDelete(Funcionario o) {
        log.info("[FUNCIONARIO AUDIT] delete complete for: " + o.getIdFuncionario());
    }

    @PostUpdate
    private void afterUpdate(Funcionario o) {
        log.info("[FUNCIONARIO AUDIT] update complete for: " + o.getIdFuncionario());
    }
    
    @PostLoad
    private void afterLoad(Funcionario o) {
        log.info("[FUNCIONARIO AUDIT] search: " + o.getIdFuncionario());
    }
}
