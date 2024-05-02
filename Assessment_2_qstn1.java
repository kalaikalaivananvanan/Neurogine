import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.beanio.types.FixedLengthStringTypeHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileGenerator {

    public static void main(String[] args) throws IOException {
        StreamFactory factory = StreamFactory.newInstance();
        StreamBuilder builder = new StreamBuilder("dataFile")
                .format("fixedlength")
                .parser(new DelimitedParserBuilder('|'))
                .addRecord(HeaderRecord.class)
                .addRecord(DataRecord.class)
                .addRecord(TrailerRecord.class);

        factory.define(builder);

        String filePath = "output.txt";

        List<Object> records = new ArrayList<>();
        records.add(new HeaderRecord());
        records.add(new DataRecord("6813162459", "RM2.00"));
        records.add(new DataRecord("2039229524", "RM10.00"));
        records.add(new DataRecord("2299488320", "RM5.00"));
        records.add(new TrailerRecord());

        BeanWriter writer = factory.createWriter("dataFile", new FileWriter(filePath));
        for (Object record : records) {
            writer.write(record);
        }
        writer.flush();
        writer.close();

        System.out.println("Data file generated successfully at: " + filePath);
    }

    public static class HeaderRecord {
        @org.beanio.annotation.Field(length = 1, at = 1)
        public String recordType = "H";

        @org.beanio.annotation.Field(length = 15, at = 14)
        public String fileType = "DATA_FILE";
    }

    public static class DataRecord {
        @org.beanio.annotation.Field(length = 14, at = 20)
        public String referenceNo;

        @org.beanio.annotation.Field(length = 16, at = 40)
        public String amount;

        public DataRecord(String referenceNo, String amount) {
            this.referenceNo = referenceNo;
            this.amount = amount;
        }
    }

    public static class TrailerRecord {
        @org.beanio.annotation.Field(length = 1, at = 1)
        public String recordType = "T";

        @org.beanio.annotation.Field(length = 15, at = 14)
        public String fileType = "DATA_FILE";
    }
}
