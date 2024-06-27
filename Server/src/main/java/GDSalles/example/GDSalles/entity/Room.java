package GDSalles.example.GDSalles.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, updatable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name="description", length = 1000 , nullable = false)
    private String description;

    //Clé primaire de la table relié à la clé room_id
   @OneToMany(mappedBy = "room")
   private List<Reservation> reservation;

    //https://www.baeldung.com/jpa-many-to-many
    @ManyToMany
    @JoinTable(name = "Room_Equipment", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipment;

    @ManyToMany
    @JoinTable(name = "Room_Group", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> groups;

    //https://www.baeldung.com/jpa-entity-lifecycle-events
    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }
    //https://www.baeldung.com/jpa-entity-lifecycle-events
    @PreUpdate
    protected void onUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }
}
