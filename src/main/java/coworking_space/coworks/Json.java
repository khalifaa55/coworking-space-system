package coworking_space.coworks;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Json {

    public static ArrayList<AbstractRoom> readGeneralRoomsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enableDefaultTyping();

        try {
            return objectMapper.readValue(new File((filePath)), new TypeReference<ArrayList<AbstractRoom>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeGeneralRoomsToFile(ArrayList<AbstractRoom> rooms, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        try {
            objectWriter.writeValue(new File(filePath), rooms);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/////////////////////////////////////////////////////////

    public static ArrayList<AbstractRoom> readTeachingRoomsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enableDefaultTyping();

        try {
            return objectMapper.readValue(new File((filePath)), new TypeReference<ArrayList<AbstractRoom>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeTeachingRoomsToFile(ArrayList<AbstractRoom> rooms, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        try {
            objectWriter.writeValue(new File(filePath), rooms);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/////////////////////////////////////////////////////////

    public static ArrayList<AbstractRoom> readMeetingRoomsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enableDefaultTyping();

        try {
            return objectMapper.readValue(new File((filePath)), new TypeReference<ArrayList<AbstractRoom>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeMeetingRoomsToFile(ArrayList<AbstractRoom> rooms, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        try {
            objectWriter.writeValue(new File(filePath), rooms);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ////////////////////////////////////////////////////////
    public static ArrayList<AbstractVisitor> readVisitorsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enableDefaultTyping();

        try {
            return objectMapper.readValue(new File((filePath)), new TypeReference<ArrayList<AbstractVisitor>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    ////////////////////////////////////////////////////////
        public static void writeVisitorsToFile(ArrayList<AbstractVisitor> visitors, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        // Write the ArrayList<Student> objects to the specified file
        try {
            objectWriter.writeValue(new File(filePath), visitors);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /////////////////////////////////////////////////////////

    public static ArrayList<Slot> readSlotsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        // Read the ArrayList<Slot> objects from the specified file
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Slot>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////
    public static void writeSlotsToFile(ArrayList<Slot> slots, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        // Write the ArrayList<Slot> objects to the specified file
        try {
            objectWriter.writeValue(new File(filePath), slots);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


