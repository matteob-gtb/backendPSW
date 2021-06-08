package reservations.journey_planner.demo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@ToString
@Table(name = "RESERVATION", schema = "JOURNEY_PLANNER")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "ROUTE")
    private Route bookedRoute;

    @Column(name = "reservation_booking_date", updatable = false)
    @CreationTimestamp
    private Timestamp reservationBookingDate;

    @Override
    public String toString() {
        return "Reservation : id : #" + id + "\n"+
                "bookedRoute : " + bookedRoute.toString() +"\n"+
                "reservationBookingDate : " + reservationBookingDate +"\n"+
                "n° of reservedSeats : " + reservedSeats.size();
    }

    @OneToMany(targetEntity = SeatsAndReservation.class,cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, mappedBy = "reservation", orphanRemoval = true)
    private List<SeatsAndReservation> reservedSeats = new ArrayList<>();


}
