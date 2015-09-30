package alchemist;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

public class CdiConfiguration {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass());
    }

    @Produces
    @Dependent
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }

}
