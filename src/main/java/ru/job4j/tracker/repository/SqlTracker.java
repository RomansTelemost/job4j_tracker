package ru.job4j.tracker.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
            return item;
        } catch (Exception e) {
            LOG.error("add" + item, e);
        }
        return null;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("UPDATE ITEMS SET name = ?, created = ? WHERE id = ?")) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.setInt(3, id);
            return preparedStatement.execute();
        } catch (Exception e) {
            LOG.error("replace", e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (Statement statement = cn.createStatement()) {
            return statement.executeUpdate(String.format(
                    "DELETE FROM ITEMS WHERE ID = %s", id)) > 0;
        } catch (Exception e) {
            LOG.error("delete", e);
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> resultList = new ArrayList<>();
        try (Statement statement = cn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ITEMS");
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                resultList.add(item);
            }
        } catch (Exception e) {
            LOG.error("findAll", e);
        }
        return resultList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (Statement statement = cn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM ITEMS WHERE name like %s", "'%" + key + "%'"));
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            LOG.error("findByName", e);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        try (Statement statement = cn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM ITEMS WHERE ID = %s", id));
            if (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                return item;
            }
        } catch (Exception e) {
            LOG.error("findById", e);
        }
        return null;
    }
}
