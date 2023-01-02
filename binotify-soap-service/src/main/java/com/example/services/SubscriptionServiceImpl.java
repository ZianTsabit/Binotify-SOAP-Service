package com.example.services;

import javax.jws.WebService;
import java.sql.*;

@WebService(endpointInterface = "com.example.services.SubscriptionService")
public class SubscriptionServiceImpl implements SubscriptionService {
   
    @Override
    public String createSubscriptionDatabase() {
        // 
        DBHandler db = new DBHandler();
        Connection conn = db.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS subscription " +
                    "(creator_id INTEGER NOT NULL, " +
                    " subscriber_id INTEGER NOT NULL, " +
                    " status ENUM('PENDING','ACCEPTED','REJECTED') NOT NULL DEFAULT 'PENDING', " +
                    " PRIMARY KEY (creator_id, subscriber_id))";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return "Subscription database created";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating subscription database";
        }

    }

    @Override
    public String addSubscription(Integer creator_id, Integer subscriber_id, String status) {
        DBHandler db = new DBHandler();
        Connection conn = db.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO subscription (creator_id, subscriber_id, status) VALUES ('%s', '%s', '%s')";  
            String query = String.format(sql, creator_id, subscriber_id, status);
            int count = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
            return "Added " + count + " subscription";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Something went wrong while adding subscription";
        }
    }
    private void setSubscription(Integer creator_id, Integer subscriber_id, String setValue){
        DBHandler db = new DBHandler();
        Connection conn = db.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE subscription SET status = %s WHERE creator_id = %s AND subscriber_id = %s";
            String query = String.format(sql, setValue, creator_id, subscriber_id);
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String rejectSubscription(Integer creator_id, Integer subscriber_id) {
        setSubscription(creator_id, subscriber_id, "REJECTED");
        return "Subscription request rejected";
    }

    @Override
    public String acceptSubscription(Integer creator_id, Integer subscriber_id) {
        setSubscription(creator_id, subscriber_id, "ACCEPTED");
        return "Subscription request accepted";
    }
}
