package coworking_space.coworks;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectWriter;
import coworking_space.coworks.Rooms.AbstractRoom;
import coworking_space.coworks.Visitors.AbstractVisitor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Json {

    //Rooms read and write methods
    public static ArrayList<AbstractRoom> readRoomsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enableDefaultTyping();

        try {
            return objectMapper.readValue(new File((filePath)), new TypeReference<ArrayList<AbstractRoom>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeRoomsToFile(ArrayList<AbstractRoom> rooms, String filePath) throws IOException {
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
    //Visitors read and write methods
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
}


