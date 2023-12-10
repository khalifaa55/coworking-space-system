package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// ArrayList<dataType> variableName = new ArrayList<>();

public class Slot {

    public String startTimeString;
    public String endTimeString;
    @JsonIgnore
    public LocalDateTime startTime;
    @JsonIgnore
    public LocalDateTime endTime;
    public ArrayList<Reservation> reservations;
    public double fees;

    // coworking_space.coworks.Json constructor configuration
    @JsonCreator
    public Slot(@JsonProperty("startTime") String startTimeString,
                @JsonProperty("endTime") String endTimeString,
                @JsonProperty("fees") double fees) {
        this.startTimeString = startTimeString;
        this.endTimeString = endTimeString;
        this.reservations = new ArrayList<Reservation>();
        this.fees = fees;

        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        startTime = LocalDateTime.parse(startTimeString, formatter);
        endTime = LocalDateTime.parse(endTimeString, formatter);*/
    }

    @JsonCreator
    public Slot() {
        this.reservations = new ArrayList<Reservation>();
    }

    // Getters
    @JsonIgnore
    public String getStartTime() {
        return startTimeString;
    }

    @JsonIgnore
    public void setStartTime(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    @JsonIgnore
    public String getEndTime() {
        return endTimeString;
    }

    @JsonIgnore
    public void setEndTime(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    @JsonProperty
    public List<Reservation> getReservations() {
        return reservations;
    }


    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public double getFees() {
        return fees;
    }

    @JsonIgnore
    public void setFees(double fees) {
        this.fees = fees;
    }

    // Methods
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
    public void updateFees(double fees) {this.fees = fees;}
    public Reservation createReservation(AbstractVisitor visitor) {
        Reservation reservation = new Reservation(visitor);
        reservations.add(reservation);
        return reservation;
    }

    // Inner class
    public static class Reservation {

        private AbstractVisitor visitor;

        public Reservation(){
            this.visitor=null;
        }
        public Reservation(AbstractVisitor visitor) {
            this.visitor = visitor;
        }

        public AbstractVisitor getVisitor() {
            return visitor;
        }

        public void setVisitor(AbstractVisitor visitor) {
            this.visitor = visitor;
        }
    }
}
