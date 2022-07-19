package org.example;

import org.example.model.Director;
import org.example.model.Item;
import org.example.model.Movie;
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
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            Movie movie = session.get(Movie.class,13);
            System.out.println(movie.getOwner().getMovieList());
            movie.getOwner().getMovieList().remove(movie);
            System.out.println(movie.getOwner().getMovieList());
            movie.setOwner(null);
            session.remove(movie);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
