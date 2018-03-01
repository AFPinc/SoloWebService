package artyfartyparty.solowebservice.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="ride")
public class Ride {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "locationFromId")
    private Location locationFrom;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "locationToId")
    private Location locationTo;

    private Date fromDate;
    private Date toDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "ride", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Stopover> stopovers = new HashSet<Stopover>();

    public Ride() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(Location locationFrom) {
        this.locationFrom = locationFrom;
    }

    public Location getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(Location locationTo) {
        this.locationTo = locationTo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Stopover> getStopovers() {
        return stopovers;
    }

    public void setStopovers(Set<Stopover> stopovers) {
        this.stopovers = stopovers;
    }
}
