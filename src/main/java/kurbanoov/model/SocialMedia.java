package kurbanoov.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "social_media")
public class SocialMedia {
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true)
    private String socialMedia;
    @ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "person_id")
    private List<Person> personList;


    public SocialMedia(String instagram) {

    }

    public SocialMedia() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "id=" + id +
                ", socialMedia='" + socialMedia + '\'' +

                '}';
    }
}
