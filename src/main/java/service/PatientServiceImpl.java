package service;

import model.PatientDto;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import resource.FHIRClient;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Override
    public List<PatientDto> getPatientByFamilySorted(String family){

        List<PatientDto> patients = new ArrayList<>();

        FHIRClient fhirClient = new FHIRClient();
        Bundle resource = fhirClient.getPatientByFamilySorted(family);

        resource.getEntry().forEach(entry -> {

            PatientDto dto = new PatientDto();

            Patient patient = (Patient) entry.getResource();

            dto.setId(patient.getIdentifierFirstRep().getValue());
            dto.setFirstName(patient.getNameFirstRep().getGivenAsSingleString());
            dto.setLastName(patient.getNameFirstRep().getFamily());
            dto.setDob(patient.getBirthDate().toString());

            patients.add(dto);
        });

    return patients;
    }
}
