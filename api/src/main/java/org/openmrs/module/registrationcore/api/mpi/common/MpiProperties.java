package org.openmrs.module.registrationcore.api.mpi.common;

import org.openmrs.GlobalProperty;
import org.openmrs.module.registrationcore.RegistrationCoreConstants;
import org.openmrs.module.registrationcore.api.ModuleProperties;

import java.util.LinkedList;
import java.util.List;

public class MpiProperties extends ModuleProperties {

    public String getServerUrl() {
        String propertyName = RegistrationCoreConstants.GP_MPI_URL;
        return getProperty(propertyName);
    }

    public Integer getGlobalIdentifierDomainId() {
        String propertyName = RegistrationCoreConstants.GP_MPI_GLOBAL_IDENTIFIER_DOMAIN_ID;
        return getIntegerProperty(propertyName);
    }

    public MpiCredentials getMpiCredentials() {
        String usernamePropertyName = RegistrationCoreConstants.GP_MPI_ACCESS_USERNAME;
        String username = getProperty(usernamePropertyName);

        String passwordPropertyName = RegistrationCoreConstants.GP_MPI_ACCESS_PASSWORD;
        String password = getProperty(passwordPropertyName);

        return new MpiCredentials(username, password);
    }

    public List<String> getLocalMpiIdentifierTypeMap() {
        String propertyPrefix = RegistrationCoreConstants.GP_LOCAL_MPI_IDENTIFIER_TYPE_MAP;

        List<String> result = new LinkedList<String>();
        for (GlobalProperty property : administrationService.getGlobalPropertiesByPrefix(propertyPrefix)) {
            result.add(property.getPropertyValue());
        }
        return result;
    }
}
