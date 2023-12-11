package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// How to declare an ArrayList:
// ArrayList<dataType> variableName = new ArrayList<>();

public class Slot
{
    public String startTimeString;
    public String endTimeString;

    public ArrayList<Reservation> reservations;
    public double fees;

    // coworking_space.coworks.Json constructor configuration
    @JsonCreator

    // start & end time are strings coming from GUI in a fixed format and use equals() to compare
    public Slot(@JsonProperty("startTime") String startTimeString,
                @JsonProperty("endTime") String endTimeString,
                @JsonProperty("fees") double fees)
    {
        this.startTimeString = startTimeString;
        this.endTimeString = endTimeString;
        this.reservations = new ArrayList<Reservation>();
        this.fees = fees;
    }

    // Constructor
    @JsonCreator
    public Slot() {this.reservations = new ArrayList<Reservation>();}

    // Getter Start time
    @JsonIgnore
    public String getStartTime() {return startTimeString;}

    // Setter Start time
    @JsonIgnore
    public void setStartTime(String startTimeString) {this.startTimeString = startTimeString;}

    // Getter End time
    @JsonIgnore
    public String getEndTime() {return endTimeString;}

    // Setter End time
    @JsonIgnore
    public void setEndTime(String endTimeString)  {this.endTimeString = endTimeString;}

    // Getter Reservation
    @JsonProperty
    public List<Reservation> getReservations() {return reservations;}

    // Setter Reservation
    public void setReservations(ArrayList<Reservation> reservations)
    {
        this.reservations = reservations;
    }

    // Getter Fees
    public double getFees() {return fees;}

    // Setter Fees
    @JsonIgnore
    public void setFees(double fees) {this.fees = fees;}

    // addReservation: Reservation	Adds an existing Reservation object to the list
    /*public void addReservation(Reservation reservation)
    {
        reservations.add(reservation);
    }*/

    public void removeReservation(Reservation reservation)
    {
        reservations.remove(reservation);
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

        public Reservation() {this.visitor=null;}
        public Reservation(AbstractVisitor visitor) {this.visitor = visitor;}

        public AbstractVisitor getVisitor() {return visitor;}

        public void setVisitor(AbstractVisitor visitor) {this.visitor = visitor;}
    }
}

