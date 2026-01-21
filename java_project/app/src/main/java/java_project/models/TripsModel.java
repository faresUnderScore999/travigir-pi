package java_project.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java_project.utils.DatabaseConnection;

public class TripsModel {
    
    public static void addTrip(Trip trip) throws SQLException {
        String sql = "INSERT INTO trips (title, description, destination, start_date, end_date, price, image_url) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, trip.getTitle());
            pstmt.setString(2, trip.getDescription());
            pstmt.setString(3, trip.getDestination());
            pstmt.setDate(4, Date.valueOf(trip.getStartDate()));
            pstmt.setDate(5, Date.valueOf(trip.getEndDate()));
            pstmt.setDouble(6, trip.getPrice());
            pstmt.setString(7, trip.getImageUrl());
            pstmt.executeUpdate();
        }
    }

    public static List<Trip> getAllTrips() throws SQLException {
        List<Trip> trips = new ArrayList<>();
        String sql = "SELECT * FROM trips ORDER BY created_at DESC";
        
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Trip trip = new Trip(
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("destination"),
                    rs.getDate("start_date").toLocalDate(),
                    rs.getDate("end_date").toLocalDate(),
                    rs.getDouble("price"),
                    rs.getString("image_url")
                );
                trip.setId(rs.getInt("id"));
                trips.add(trip);
            }
        }
        return trips;
    }

    public static void deleteTrip(int tripId) throws SQLException {
        String sql = "DELETE FROM trips WHERE id = ?";
        
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tripId);
            pstmt.executeUpdate();
        }
    }
}
