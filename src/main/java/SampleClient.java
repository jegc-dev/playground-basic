import model.PatientDto;
import service.PatientServiceImpl;

import java.util.List;

public class SampleClient {


    public static void main(String[] theArgs) {

        getPatientByFamilySorted("smith");

    }

    public static void getPatientByFamilySorted(String family) {

        PatientServiceImpl patientService = new PatientServiceImpl();

        List<PatientDto> results = patientService.getPatientByFamilySorted(family);

        for (PatientDto p : results){
            System.out.println(p.toString());
        }
    }
}
