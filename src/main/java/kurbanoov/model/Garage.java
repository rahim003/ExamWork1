package kurbanoov.model;

import javax.persistence.*;

@Entity
@Table
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String isEmpty;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "garage")
    private Car car;

    public Garage(String name, String isEmpty) {
        this.name = name;
        this.isEmpty = isEmpty;
    }

    public Garage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(String isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isEmpty='" + isEmpty + '\'' +
                '}';
    }
}
