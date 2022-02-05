package kurbanoov.service;

import kurbanoov.model.*;

import java.util.List;

public interface Personsable {
    void createTable();
    void savePerson(Person person, List<Company> companies, List<Car>cars,
                     List<SocialMedia>socialMedia, List<Garage>garages);
    Company getById(long id);
    List<?>getAllPerson();
    Person deleteByid(long id);


}
