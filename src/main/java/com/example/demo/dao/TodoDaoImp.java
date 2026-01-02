package com.example.demo.dao;

import com.example.demo.config.HibernateConfig;
import com.example.demo.domain.Todo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoDaoImp implements TodoDao {

    @Override
    public void save(Todo todo) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(todo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Todo> findById(UUID id) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            Todo todo = session.find(Todo.class, id);
            return Optional.ofNullable(todo);
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
