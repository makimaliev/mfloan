package kg.gov.mf.loan.core.util;

import kg.gov.mf.loan.core.component.AuthenticationFacade;
import kg.gov.mf.loan.core.component.AutowireHelper;
import kg.gov.mf.loan.core.model.GenericModel;
import kg.gov.mf.loan.core.model.LogAction;
import kg.gov.mf.loan.core.model.MFLog;
import kg.gov.mf.loan.core.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

public class MFEntityListener {

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    public MFEntityListener() {}

    @PostPersist
    public void entityPrePersist(Object o) {
        perform(o, LogAction.INSERTED);
    }

    @PostUpdate
    public void entityPostUpdate(Object o) {
        perform(o, LogAction.UPDATED);
    }

    @PostRemove
    public void entityPostRemove(Object o) {
        perform(o, LogAction.DELETED);
    }

    @Transactional
    void perform(Object o, LogAction logAction)
    {
        AutowireHelper.autowire(this, this.loggerService);
        AutowireHelper.autowire(this, this.authenticationFacade);

        Authentication auth = authenticationFacade.getAuthentication();
        String user = "System";
        String ip = "localhost";

        if(auth.isAuthenticated())
        {
            user = ((UserDetails) auth.getPrincipal()).getUsername();
            ip = ((WebAuthenticationDetails)auth.getDetails()).getRemoteAddress();
        }

        MFLog log = new MFLog();
        log.setCreatedBy(user);
        log.setIp(ip);
        log.setEntity(o.getClass().getSimpleName());
        log.setEntityId(((GenericModel)o).getId());
        log.setAction(logAction.value());
        loggerService.add(log);
    }
}
