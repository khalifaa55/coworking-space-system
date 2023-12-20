package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;


// How to declare an ArrayList:
// ArrayList<dataType> variableName = new ArrayList<>();

public class Slot implements Comparable
{
    public String startTime;
    public String endTime;
    public ArrayList<Reservation> reservations;
    public double fees;
    public LocalDate slotDate;

    //@JsonFormat(pattern = "yyyy-MM-dd"); default format for LocalDate dtype.
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonIgnore
    public LocalDate currentDate;

    // coworking_space.coworks.Json constructor configuration
    @JsonCreator
    // start & end time are strings coming from GUI in a fixed format and use equals() to compare
    public Slot(@JsonProperty("startTime") String startTime,
                @JsonProperty("endTime") String endTime,
                @JsonProperty("fees") double fees,
                @JsonProperty("slotDate") LocalDate slotDate)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservations = new ArrayList<Reservation>();
        this.fees = fees;
        this.slotDate = slotDate;
        this.currentDate = LocalDate.now(); // Captures today's date
    }

    // Constructor
    public Slot() {this.reservations = new ArrayList<Reservation>();}

    // Getter Start time
    @JsonIgnore
    public String getStartTime() {return startTime;}

    // Setter Start time
    @JsonIgnore
    public void setStartTime(String startTime) {this.startTime = startTime;}

    // Getter End time
    @JsonIgnore
    public String getEndTime() {return endTime;}

    // Setter End time
    @JsonIgnore
    public void setEndTime(String endTime)  {this.endTime = endTime;}

    // Setter slotDate
    @JsonIgnore
    public void setSlotDate(LocalDate slotDate) {this.slotDate = slotDate;}

    // Getter slotDate
    @JsonIgnore
    public LocalDate getSlotDate() {return slotDate;}

    // Getter Reservation
    @JsonProperty
    public ArrayList<Reservation> getReservations() {return reservations;}

    // Setter Reservation
    public void setReservations(ArrayList<Reservation> reservations)
    {
        this.reservations = reservations;
    }

    // Getter Fees
    public double getFees() {return fees;}

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
    public LocalDate getDate30DaysFromNow()
    {
        return currentDate.plusDays(30);
    }

    /*  createReservation AbstractVisitor:	Creates a new Reservation object with the
     provided visitor and adds it to the list  */
    public Reservation createReservation(AbstractVisitor visitor ,LocalDate date)
    {
        Reservation reservation = new Reservation(visitor, date);
        reservations.add(reservation);
        return reservation;
    }
    @Override
    public int compareTo(Object obj)
    {
        Slot otherSlot = (Slot) obj;
        if(this.slotDate.isBefore(otherSlot.slotDate))
        {
            return -1;
        }
        else if(this.slotDate.isAfter(otherSlot.slotDate))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    // Inner class
    public static class Reservation implements Comparable
    {


        private static int ID;

        public AbstractVisitor visitor;
        public LocalDate reservationDate;

        // Constructors
        public Reservation() {} // no argument constructor that acts like a default one

        public Reservation(AbstractVisitor visitor) {
            this.visitor = visitor;
        }

        public Reservation(AbstractVisitor visitor, LocalDate reservationDate, int ID) // Constructor overloading
        {
            this.visitor = visitor;
            this.reservationDate = reservationDate;
            Reservation.ID = ID;
        }

        // Getter reservationDate
        public LocalDate getReservationDate()
        {
            return this.reservationDate;
        }

        // Getter visitor
        public AbstractVisitor getVisitor()
        {
            return visitor;
        }

        // Setter visitor
        public void setVisitor(AbstractVisitor visitor)
        {
            this.visitor = visitor;
        }

        // Getter ID
        public static int getID() {return ID;}

        // Setter ID
        public static void setID(int ID) {Reservation.ID = ID;}
        @Override
        public int compareTo(Object obj)
        {
            Reservation otherReservation = (Reservation) obj;
            if (this.reservationDate.isBefore(otherReservation.reservationDate))
            {
                return -1;
            }
            else if (this.reservationDate.isAfter(otherReservation.reservationDate))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}