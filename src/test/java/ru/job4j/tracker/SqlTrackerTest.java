package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.repository.SqlTracker;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemAndFindByReplacedIdThenSameName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item1");
        Item replacedItem = new Item("item2");
        Item itemWithId = tracker.add(item);
        tracker.replace(itemWithId.getId(), replacedItem);
        assertThat(tracker.findById(itemWithId.getId()).getName().equals(replacedItem.getName()));
    }

    @Test
    public void whenRemoveThenFindByIdIsNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item1");
        item = tracker.add(item);
        assertThat(tracker.findAll().contains(item));
        tracker.delete(item.getId());
        assertThat(null == tracker.findById(item.getId()));
    }

    @Test
    public void whenCreateThreeItemsThenFindAllContainsAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        item3 = tracker.add(item3);
        assertThat(tracker.findAll().containsAll(List.of(item1, item2, item3)));
    }

    @Test
    public void whenFindByItem2AndItem4ThenReturnListOfTwoItem2AndItem4() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        Item item4 = new Item("item2");
        item2 = tracker.add(item2);
        item4 = tracker.add(item4);
        assertThat(tracker.findByName("item2").containsAll(List.of(item2, item4)));
    }

    @Test
    public void whenFindById2ThenReturnItemWithId2() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        item2 = tracker.add(item2);
        assertThat(item2.equals(tracker.findById(item2.getId())));
    }
}