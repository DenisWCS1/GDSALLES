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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, updatable = false)
    private LocalDateTime modifiedAt;

    //Clé primaire de la table relié à la clé user_id
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservation;

    @Column(name="username", length = 100, nullable = false)
    private String username;
    private String email;

    //https://www.baeldung.com/jpa-many-to-many
    @ManyToMany
    @JoinTable(name = "User_Group", joinColumns = @JoinColumn(name ="user_id"), inverseJoinColumns = @JoinColumn(name ="group_id"))
    private Set<Group> groups;

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
