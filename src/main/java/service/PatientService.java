package service;

import model.PatientDto;

import java.util.List;

public interface PatientService {

    List<PatientDto> getPatientByFamilySorted(String family);
}
