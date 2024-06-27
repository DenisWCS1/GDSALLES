package GDSalles.example.GDSalles.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, updatable = false)
    private LocalDateTime modifiedAt;

    //Clé étrangère de la table relié à la clé primaire room
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    //Clé étrangère de la table relié à la clé primaire user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "start_date", nullable = false, updatable = true)
    private LocalDateTime startdate;
    @Column(name = "end_date", nullable = false, updatable = true)
    private LocalDateTime enddate;


    //https://www.baeldung.com/jpa-entity-lifecycle-events
     @PrePersist
    protected void onCreate(){
         this.createdAt = LocalDateTime.now();
     }
     //https://www.baeldung.com/jpa-entity-lifecycle-events
    @PreUpdate
    protected void onUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }
}
