package coworking_space.coworks;

import java.io.IOException;
import java.util.ArrayList;

public class Filetest {
    public static void main(String[] args) {
        final String WRITE_VISITORS_PATH = "C:\\Users\\DELL\\IdeaProjects\\coworking-space-system\\src\\main\\resources\\visitors.json";
        final String READ_VISITORS_PATH = "C:\\Users\\DELL\\IdeaProjects\\coworking-space-system\\src\\main\\resources\\visitors.json";
        try {
            Coworks_Main.visitors= Json.readVisitorsFromFile(READ_VISITORS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AbstractVisitor s=new GeneralVisitor("Bansah",12);
        Coworks_Main.visitors.add(s);
        for (AbstractVisitor v:  Coworks_Main.visitors) {
            System.out.println(v.name);
            System.out.println(v.password);
            System.out.println(v.id);
            System.out.println(v.phoneNumber);
            System.out.println(v.userEmail);
            System.out.println(v.type);
            System.out.println("#############################################");

        }
        try {
            Json.writeVisitorsToFile(Coworks_Main.visitors,WRITE_VISITORS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
