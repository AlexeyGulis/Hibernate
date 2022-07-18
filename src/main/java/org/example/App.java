package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            Person person = new Person("Phil", 23);

            Item newItem = new Item("PC 2", person);

            person.setItemList(new ArrayList<Item>(Collections.singletonList(newItem)));

            //без каскадирования необходимо сохранять все созданные объекты

            session.save(newItem);

            session.save(person);

            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
