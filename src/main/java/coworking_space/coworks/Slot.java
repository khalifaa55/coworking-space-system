package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;


// How to declare an ArrayList:
// ArrayList<dataType> variableName = new ArrayList<>();

public class Slot
{
    public String startTime;
    public String endTime;
    public ArrayList<Reservation> reservations;
    public double fees;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate currentDate;

    // coworking_space.coworks.Json constructor configuration
    @JsonCreator
    // start & end time are strings coming from GUI in a fixed format and use equals() to compare
    public Slot(@JsonProperty("startTime") String startTime,
                @JsonProperty("endTime") String endTime,
                @JsonProperty("fees") double fees)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservations = new ArrayList<Reservation>();
        this.fees = fees;
        this.currentDate = LocalDate.now();   // Capture today's date
    }

    // Constructor
    public Slot() {this.reservations = new ArrayList<Reservation>();}

    // Getter Start time
    @JsonIgnore
    public String getStartTime() {return this.startTime;}

    // Setter Start time
    @JsonIgnore
    public void setStartTime(String startTime) {this.startTime = startTime;}

    // Getter End time
    @JsonIgnore
    public String getEndTime() {return this.endTime;}

    // Setter End time
    @JsonIgnore
    public void setEndTime(String endTime)  {this.endTime = endTime;}

    // Getter Reservation
    @JsonProperty
    public List<Reservation> getReservations() {return reservations;}

    // Setter Reservation
    public void setReservations(ArrayList<Reservation> reservations)
    {
        this.reservations = reservations;
    }

    // Getter Fees
    public double getFees() {return this.fees;}

    // Setter Fees
    public void setFees(double fees) {this.fees = fees;}

    // Getter for the current date
    public LocalDate getCurrentDate() {return currentDate;}

    // A function to remove a reservation object
    public void removeReservation(Reservation reservation)
    {
        reservations.remove(reservation);
    }

    // Method to compute the date 30 days from the current date
    @JsonIgnore
    public String getDate30DaysFromNow()
    {
        LocalDate date30DaysLater = currentDate.plusDays(30);

        // Define the desired date format using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the date using the defined formatter
        return date30DaysLater.format(formatter);
    }
    // A function for the admin to update the fees for reserving a room
    public void updateFees(double fees) {this.fees = fees;}

    // createReservation	AbstractVisitor	Creates a new Reservation object with the
    // provided visitor and adds it to the list
    public Reservation createReservation(AbstractVisitor visitor)
    {
        Reservation reservation = new Reservation(visitor);
        reservations.add(reservation);
        return reservation;
    }

    // Inner class

    public static class Reservation
    {
        private AbstractVisitor visitor;

        public Reservation(AbstractVisitor visitor) {this.visitor = visitor;}
        public Reservation(){this.visitor = null;}
        public AbstractVisitor getVisitor() {return visitor;}

        public void setVisitor(AbstractVisitor visitor) {this.visitor = visitor;}
    }
}