package inz_proj_app.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Passwords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String passwordHash;
    private String nazwaStrony;
    private String lastChange;  // Data


//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "passwords_roles",
//            joinColumns = @JoinColumn(
//                    name = "passwords_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"))
//    private Collection < Role > roles;

    public Passwords() {}

    public Passwords(String email, String passwordHash, String nazwaStrony, String lastChange) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.nazwaStrony = nazwaStrony;
        this.lastChange = lastChange;
    }

    public Passwords(String email, String passwordHash, String nazwaStrony, String lastChange, Collection < Role > roles) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.nazwaStrony = nazwaStrony;
        this.lastChange = lastChange;
//        this.roles = roles;
    }

//    Jeśli dobrze rozumiem to ta linia powinna pójść do model/User:
//    @OneToMany(mappedBy = "user")

    @ManyToOne
    private User user;

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

    public String getNazwaStrony() {
        return nazwaStrony;
    }

    public void setNazwaStrony(String nazwaStrony) {
        this.nazwaStrony = nazwaStrony;
    }

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

//    public Collection < Role > getRoles() {
//        return roles;
//    }

//    public void setRoles(Collection < Role > roles) {
//        this.roles = roles;
//    }

    @Override
    public String toString() {
        return "Password{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", lastChange='" + lastChange + '\'' +
//                ", roles=" + roles +
                '}';
    }
}
