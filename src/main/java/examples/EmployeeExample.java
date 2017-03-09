package examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import model.SummaryReport;

import org.jxls.template.SimpleExporter;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;

import model.Employee;

public class EmployeeExample {
    public void export(String template) {
        try (OutputStream os1 = new FileOutputStream(
                "target/simple_export_output1.xls")) {
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee("Mike", new Date(), new BigDecimal(
                    "1000"), new BigDecimal("20000")));
            employees.add(new Employee("Jason", new Date(), new BigDecimal(
                    "2000"), new BigDecimal("40000")));
            List<String> headers = Arrays.asList("Name", "Birthday", "Payment");
            SimpleExporter exporter = new SimpleExporter();
            exporter.gridExport(headers, employees, "name, birthDate, payment",
                    os1);
            // now let's show how to register custom template
            try (InputStream is = getClass().getClassLoader()
                    .getResourceAsStream(template)) {
                try (OutputStream os2 = new FileOutputStream(
                        "target/simple_export_output2.xlsx")) {
                    exporter.registerGridTemplate(is);
                    headers = Arrays.asList("Name", "Payment", "Birth Date");
                    exporter.gridExport(headers, employees,
                            "name,payment, birthDate,", os2);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getExcel(OutputStream outputStream) throws SQLException,
            IOException {
        Collection<SummaryReport> summaries = new ArrayList<>();
        summaries.add(new SummaryReport(1000, "device1", 1520003.5,
                2222.9, 5.9, 20000000, 508));
        summaries.add(new SummaryReport(2000, "device2", 19866523.5,
                12222.9, 15.9, 12000000, 15));
        try (InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("templates\\export\\summary.xlsx")) {
            org.jxls.common.Context jxlsContext = PoiTransformer
                    .createInitialContext();
            jxlsContext.putVar("summaries", summaries);
            jxlsContext.putVar("from", "2016.09.21 21:01:05");
            jxlsContext.putVar("to", "2016.12.21 11:01:05");
            jxlsContext.putVar("distanceUnit", "m");
            jxlsContext.putVar("speedUnit", "mph");
            jxlsContext.putVar("timezone", "na");
            JxlsHelper.getInstance().setUseFastFormulaProcessor(false)
                    .processTemplate(inputStream, outputStream, jxlsContext);
        }
    }
    static EmployeeExample soln = new EmployeeExample();
    public static void main(String[] args) {
        //soln.export("simple_export_template.xlsx");
        try {
            OutputStream os = new FileOutputStream(
                    "target/simple_export_output3.xls");
            soln.getExcel(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
