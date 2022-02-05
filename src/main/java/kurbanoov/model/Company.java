package kurbanoov.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "company_name",
    unique = true,length = 30)
    private String companyName;
    private String location;
    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "company")
    @JoinColumn(name = "person_id")
    private List<Person>people;
    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    public Company(String companyName, String location) {
        this.companyName = companyName;
        this.location = location;
    }

    public Company(List<Person> people) {
        this.people = people;
    }

    public Company(Person person) {
        this.person = person;
    }

    public Company() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", people=" + people +
                ", person=" + person +
                '}';
    }
}
