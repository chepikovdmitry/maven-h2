package by.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.jws.soap.SOAPBinding;

public class App
{

    public static void main( String[] args )

    {
        SessionFactory sessionFactory;
        try {
        StandardServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metaData =
                new MetadataSources(standardRegistry).getMetadataBuilder().build();


            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
        System.err.println("Enitial SessionFactory creation failed" + th);
        throw new ExceptionInInitializerError(th);
    }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User alex = new User("alex");
        session.save(alex);
        transaction.commit();
        session.close();
        System.out.println( "Hello World!" );
    }
}
