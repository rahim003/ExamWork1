package kurbanoov.service;

import kurbanoov.model.*;
import kurbanoov.util.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class Persons implements Personsable{
    @Override
    public void createTable() {
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            System.out.println("Create tables");
            session.close();
        }catch (HibernateException ex){
            System.out.println("Create tablisda kata bar  "+ex.getMessage());
        }
    }

    @Override
    public void savePerson(Person person, List<Company> companies, List<Car> cars, List<SocialMedia> socialMedia, List<Garage> garages) {
        try {
            Session session=Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            companies.stream().forEach(company -> company.setPerson(person));
            cars.stream().forEach(car -> car.setGarage((Garage) garages));
            socialMedia.stream().forEach(socialMedia1 -> socialMedia1.setPersonList((List<Person>) socialMedia1));
            person.setCars(cars);
            person.setCompany((Company) companies);
            person.setSocialMedia(socialMedia);
        }catch (HibernateException exception){
            System.out.println(exception.getMessage());
        }
    }
    @Override
    public Company getById(long id) {
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            Person employee=new Person();
            Company details = session.get(Company.class, id);
            details.setPerson(employee);
            session.getTransaction().commit();
            System.out.println(details);
            session.close();
            return details;
        }catch (HibernateException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<?> getAllPerson() {
        Session session=Hibernate.getSessionFactory().openSession();
        session.beginTransaction();
        List<Person>personList=session.createQuery("from Person ").list();
        personList.stream().forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public Person deleteByid(long id) {
        Session session=Hibernate.getSessionFactory().openSession();
        session.beginTransaction();
        Person employee=session.get(Person.class,id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Employee delete in tables");
        return employee;
    }
    }
