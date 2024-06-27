package GDSalles.example.GDSalles.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, updatable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "surname", length = 100, nullable = false)
    private String surname;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;

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
