package resource;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;
import org.hl7.fhir.r4.model.Bundle;

public class FHIRClient {

    public static final String SERVER_BASE = "http://hapi.fhir.org/baseR4";

    public static IGenericClient getClient(){
        // Create a FHIR client
        FhirContext fhirContext = FhirContext.forR4();
        IGenericClient client = fhirContext.newRestfulGenericClient(SERVER_BASE);
        client.registerInterceptor(new LoggingInterceptor(false));

        return client;
    }

    public Bundle getPatientByFamilySorted(String family) {

        IGenericClient client = getClient();

        // Search for Patient resources
        return ((IGenericClient) client)
                .search()
                .forResource("Patient")
                .where(org.hl7.fhir.r4.model.Patient.FAMILY.matches().value(family))
                .returnBundle(Bundle.class)
                .sort().ascending(org.hl7.fhir.r4.model.Patient.FAMILY)
                .sort().ascending(org.hl7.fhir.r4.model.Patient.GIVEN)
                .execute();
    }


}
