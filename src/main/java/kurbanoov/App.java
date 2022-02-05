package kurbanoov;

import kurbanoov.model.*;
import kurbanoov.service.Persons;
import kurbanoov.service.Personsable;
import kurbanoov.util.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )throws Exception{
        Personsable personsable=new Persons();
        Person person=new Person("Rahim", (byte) 18,"rahimkurbanov45@gmail.com","male");
        List<Company>companies=new ArrayList<>();
        companies.add(new Company("Peaksoft","Bishkek"));
        companies.add(new Company("Maven","Osh"));
        companies.add(new Company("Jyldyz","Jalal-Abad"));
        List<SocialMedia>socialMedia=new ArrayList<>();
        socialMedia.add(new SocialMedia("Instagram"));
        socialMedia.add(new SocialMedia("Telegram"));
        socialMedia.add(new SocialMedia("Whatsapp"));
        List<Garage>garages=new ArrayList<>();
        garages.add(new Garage("House","true"));
        garages.add(new Garage("Truck","folse"));
        garages.add(new Garage("Ish","true"));
        List<Car>cars=new ArrayList<>();
        cars.add(new Car("Lexus","Germany"));
        cars.add(new Car("Huindai","Korea"));
        cars.add(new Car("Mersedes-Benz","Russia"));
        personsable.savePerson(person,companies,cars, socialMedia, garages);
    }


}
