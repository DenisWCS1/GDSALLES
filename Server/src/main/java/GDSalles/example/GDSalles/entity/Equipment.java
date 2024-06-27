package GDSalles.example.GDSalles.entity;

import GDSalles.example.GDSalles.model.EquipmentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@ToString
@EqualsAndHashCode
@Data
@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, updatable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
    //https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "equipment")
    Set<Room> rooms;

    //https://www.baeldung.com/jpa-entity-lifecycle-events
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    //https://www.baeldung.com/jpa-entity-lifecycle-events
    @PreUpdate
    protected void onUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }


}
