package kurbanoov.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "first_name",
    length = 25)
    private String firstName;
    private byte age;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String gender;
    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "company_id")
    private Company company;
    @OneToMany(cascade =CascadeType.ALL )
    @Column(name = "social_media_id")
    private List<SocialMedia>socialMedia;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "car_id")
    private List<Car>cars;

    public Person(String firstName, byte age, String email, String gender) {
        this.firstName = firstName;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    public Person(Company company) {
        this.company = company;
    }

    public Person(List<SocialMedia> socialMedia) {
        this.socialMedia = socialMedia;
    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<SocialMedia> getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(List<SocialMedia> socialMedia) {
        this.socialMedia = socialMedia;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", company=" + company +
                ", socialMedia=" + socialMedia +
                ", cars=" + cars +
                '}';
    }
}
