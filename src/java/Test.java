
import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.service.StressMeasurementService;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LQwabe
 */
public class Test {

    public static void main(String[] args) {
        StressMeasurementService stressMeasurementService = new StressMeasurementService();

        //List<StressMeasurement> list = stressMeasurementService.getAllStressMeasurements();
        String str= "cs";
        List<String> list = stressMeasurementService.searchByMethod(str);
        for (String ss : list) {
            System.out.println(ss);

        }

    }
}
