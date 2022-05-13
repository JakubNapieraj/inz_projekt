package inz_proj_app.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Passwords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String passwordHash;
    private String url;
    private LocalDateTime lastChange;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Passwords() {}

    public Passwords(String email, String passwordHash, String url, LocalDateTime lastChange) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.url = url;
        this.lastChange = lastChange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String nazwaStrony) {
        this.url = nazwaStrony;
    }

    public LocalDateTime getLastChange() {
        return lastChange;
    }

    public void setLastChange(LocalDateTime lastChange) {
        this.lastChange = lastChange;
    }
    @Override
    public String toString() {
        return "Password{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", lastChange='" + lastChange + '\'' +
                '}';
    }
}

