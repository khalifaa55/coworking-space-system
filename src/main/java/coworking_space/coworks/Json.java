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

    //source root path
    // coworking_space.coworks.GeneralRoom file path: "generalRooms.json"
    public static ArrayList<AbstractRoom> readRoomsFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enableDefaultTyping();

        try (InputStream inputStream = Json.class.getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + filePath);
            }
            return objectMapper.readValue(inputStream, new TypeReference<ArrayList<AbstractRoom>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /////////////////////////////////////////////////////////

    //content root path
    //coworking_space.coworks.GeneralRoom file path: "src/main/resources/generalRooms.json"
    public static void writeRoomsToFile(ArrayList<AbstractRoom> rooms, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        // Write the ArrayList<Student> objects to the specified file
        try {
            objectWriter.writeValue(new File(filePath), rooms);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    ////////////////////////////////////////////////////////
    public static ArrayList<AbstractVisitor> readVisitorsFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = Json.class.getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + filePath);
            }
            return objectMapper.readValue(inputStream, new TypeReference<ArrayList<AbstractVisitor>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    ////////////////////////////////////////////////////////
        public static void writeVisitorsToFile(ArrayList<AbstractVisitor> visitors, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
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


