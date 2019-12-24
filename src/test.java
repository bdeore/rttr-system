/*
 * Copyright (c)  @Author :Suyog Deore
 * Reproduction or redistribution of Following Codes -or-
 * Libraries without proper permissions is liable to Prosecution.
 */

package sample;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class test {

    private Connection connection;
    public static ArrayList ll = new ArrayList();


    public void test1() throws Exception {
        connection = DBConnection.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT session_time, latitude, longitude FROM primary.latlong ORDER BY session_time DESC");

        while (rs.next()) {
            ll.add((rs.getString(2)));
        }

        System.out.print("coordinates:" +ll.get(0));
    }
}
