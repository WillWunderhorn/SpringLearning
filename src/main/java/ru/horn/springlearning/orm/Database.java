package ru.horn.springlearning.orm;

import ru.horn.springlearning.jsonParse.JsonParser;

import java.sql.*;

public class Database {
    String table = JsonParser.getJsonDatabase();
    String username = JsonParser.getJsonUsername();
    String password = JsonParser.getJsonPassword();
    String connectionUrl = JsonParser.getJsonUrl();

    public void addArtist(Artists artists) {
        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("REPLACE INTO artists(id, name, age, type) VALUES " +
                    "(" +Artists.getId()+", "+ "'" + Artists.getName()+ "'" + ", "+Artists.getAge()+", "+ "'"+ Artists.getType()+ "'"+ " )"
            );

        } catch (SQLException ex) {
            System.out.println("ADDING FAILED" + "\n" + ex);
        }
    }

    public void addRemoveById(int id) {
        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("DELETE FROM " +table+" WHERE id = "+id+""
            );

        } catch (SQLException ex) {
            System.out.println("REMOVING BY ID FAILED" + "\n" + ex);
        }
    }

    public void clearTable() {
        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("TRUNCATE TABLE " +table
            );

        } catch (SQLException ex) {
            System.out.println("TRUNCATING FAILED" + "\n" + ex);
        }
    }

    public void showTable(){
        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            String script = "SELECT * FROM " + table;
            ResultSet rs = statement.executeQuery(script);

            while (rs.next()){
                Artists artists = new Artists(Artists.getId(), Artists.getName(), Artists.getAge(), Artists.getType());
                Artists.setId(rs.getInt(1));
                artists.setName(rs.getString(2));
                artists.setAge(rs.getInt(3));
                artists.setType(rs.getString(4));
                System.out.println(artists);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
