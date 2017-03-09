import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import examples.Staff;
import net.sf.jxls.transformer.XLSTransformer;

public class ChartTest {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        List<Staff> staffs = new ArrayList<Staff>();

        Staff s1 = new Staff("Zhang San", 6000D, 3000D);
        staffs.add(s1);

        Staff s2 = new Staff("Li Si", 5000D, 2000D);
        staffs.add(s2);

        Staff s3 = new Staff("Wang Wu", 4000D, 1000D);
        staffs.add(s3);

        String srcFilePath = "e:/simple.xlsx";
        String destFilePath = "e:/template-simple.xlsx";
        Map<String, List<Staff>> beanParams = new HashMap<String, List<Staff>>();
        beanParams.put("staffs", staffs);

        XLSTransformer former = new XLSTransformer();
        former.transformXLS(srcFilePath, beanParams, destFilePath);

        System.out.println("the end !!!");
    }

}