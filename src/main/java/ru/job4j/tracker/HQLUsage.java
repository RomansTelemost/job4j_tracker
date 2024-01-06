package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HQLUsage {
    /**
     * HQL поддерживает блоки SQL WHERE, HAVING, GROUP BY, ORDER BY, LIMIT, OFFSET.
     */
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            Query query = session.createQuery("from Item");
            for (Object st : query.list()) {
                System.out.println(st);
            }
            Query<Item> query2 = session.createQuery("from ru.job4j.tracker.Item", Item.class);
            for (Object st : query2.list()) {
                System.out.println(st);
            }
            unique(session);
            findById(session, 5);
            update(session, 6);
            Query query3 = session.createQuery("from Item");
            for (Object st : query3.list()) {
                System.out.println(st);
            }

            /* working with session */
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void unique(Session session) {
        /**
         * as - не обязательно
         */
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = 4", Item.class);
        System.out.println(query.uniqueResult());
    }

    public static void findById(Session session, int id) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = :fId", Item.class);
        query.setParameter("fId", id);
        System.out.println(query.uniqueResult());
    }

    /**
     * Синтаксис запроса на обновление записи идентичен с SQL.
     * @param session
     * @param id
     */
    public static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "UPDATE Item SET name = :fName WHERE id = :fId")
                    .setParameter("fName", "new name")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /**
     * Запрос типа "INSERT ... VALUES ..." в HQL не поддерживается.
     * Использовать save. Пример метода save ниже
     * @param session
     */
    public static void insert(Session session) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "INSERT INTO Item (name) SELECT i.name FROM ДругойОбъект as i")
                    .executeUpdate();
            session.getTransaction().commit();

            /**
             * Query query = session.createQuery("INSERT INTO Item(name)" +
             * "SELECT name FROM Другая_таблица");
             * int rsl = query.executeUpdate();
             */

        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
