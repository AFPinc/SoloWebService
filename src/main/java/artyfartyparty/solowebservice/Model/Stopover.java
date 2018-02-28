package artyfartyparty.solowebservice.Model;

import javax.persistence.*;

@Entity(name="stopover")
public class Stopover {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ride_id")
    private Ride ride;

    public Stopover() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRide(Ride rides) {
        this.ride = rides;
    }
}
