import model.PatientCsv;
import model.PatientDto;
import service.PatientServiceImpl;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SampleClient {


    public static void main(String[] theArgs) {


        try {
            List<PatientCsv> patientCsvList = getCSVFileStream();

            for (PatientCsv p : patientCsvList){

                System.out.println("Searching...[" + p.getLastName() + "]");
                getPatientByFamilySorted(p.getLastName());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getPatientByFamilySorted(String family) {

        PatientServiceImpl patientService = new PatientServiceImpl();

        List<PatientDto> results = patientService.getPatientByFamilySorted(family);

        for (PatientDto p : results){
            System.out.println(p.toString());
        }
    }

    public static List<PatientCsv> getCSVFileStream() throws IOException {

        Path path = FileSystems.getDefault().getPath("src","main","resources","patients.csv");

        return Files.lines(path)
                .map(SampleClient::getPatient)
                .collect(Collectors.toList());

    }

    public static PatientCsv getPatient(String line){
        String[] fields = line.split(",");
        if(fields.length != 2)
            throw new RuntimeException("Invalid CSV line -" + line);
        return new PatientCsv(fields[0],fields[1]);
    }
}
