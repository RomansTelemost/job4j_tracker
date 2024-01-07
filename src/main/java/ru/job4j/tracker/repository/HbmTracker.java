package ru.job4j.tracker.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private static final Logger LOG = LoggerFactory.getLogger(HbmTracker.class.getName());

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Error while add item " + item, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            int effectedRows = session.createQuery(
                    "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            result = effectedRows > 0;
        } catch (Exception e) {
            LOG.error("Error while replace item " + item + " with id " + id, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            LOG.error("Error while delete item with id " + id, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> items = List.of();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("FROM Item", Item.class);
            items = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Error while findAll", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> items = List.of();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery(
                    "FROM Item WHERE name LIKE :pName", Item.class);
            query.setParameter("pName", "%" + key + "%");
            items = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Error while findByName" + key, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item item = null;
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery(
                    "FROM Item WHERE id = :pId", Item.class);
            query.setParameter("pId", id);
            item = query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Error while findById " + id, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
