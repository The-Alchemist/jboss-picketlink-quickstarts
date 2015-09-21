package org.jboss.as.quickstarts.picketlink.authentication.form;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.picketlink.Identity;
import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.basic.Grant;
import org.picketlink.idm.model.basic.Role;

public class CustomRoleProvider {
    @Inject
    private Identity identity;
    @Inject
    private IdentityManager identityManager;
    @Inject
    private RelationshipManager relationshipManager;
    
    
    private final Logger logger = Logger.getLogger(getClass().getName());

    public void init(@Observes LoggedInEvent event) {
        Account account = identity.getAccount();
        String userName = account.getId();
        
        /*
         * from https://docs.jboss.org/picketlink/2/latest/reference/html-single/#Creating_Custom_Relationships
         */
        Role admin = new Role("CUSTOM_ADMIN_KP");
        identityManager.add(admin);
        // Use the RelationshipManager to create relationships, such as role assignments and group memberships:
        // Grant the admin role to the user
        relationshipManager.add(new Grant(account, admin));
        logger.info("KARL: adding role for " + account.getId());

    }

}
