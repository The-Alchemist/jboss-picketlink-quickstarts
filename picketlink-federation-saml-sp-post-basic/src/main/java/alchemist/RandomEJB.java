package alchemist;

import java.security.Principal;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.logging.Logger;


@SecurityDomain("sp")
@RolesAllowed("manager")
@Named
@Stateless
public class RandomEJB {

    @Inject
    private Logger logger;

    @Resource
    private EJBContext ejbContext;

    public Principal getPrincipal() {
        Principal callerPrincipal = this.ejbContext.getCallerPrincipal();
        logger.infov("EJB says that the caller principal is: {0}", callerPrincipal);

        return callerPrincipal;
    }
}
