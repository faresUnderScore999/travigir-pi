// The Service: Its job is Business Logic.
//  This includes complex calculations, data validation, or coordinating between different models

package java_project.services;

import java.sql.SQLException;
import java.util.List;
import java_project.models.Trip;
import java_project.models.TripsModel;

public class TripService {
    
    /**
     * Retrieves all trips from the database
     * @return a list of all trips
     * @throws SQLException if a database error occurs
     */
    public List<Trip> getAllTrips() throws SQLException {
        return TripsModel.getAllTrips();
    }
    
    /**
     * Adds a new trip to the database
     * @param trip the trip to add
     * @throws SQLException if a database error occurs
     */
    public void addTrip(Trip trip) throws SQLException {
        TripsModel.addTrip(trip);
    }
    
    /**
     * Deletes a trip from the database
     * @param tripId the ID of the trip to delete
     * @throws SQLException if a database error occurs
     */
    public void deleteTrip(int tripId) throws SQLException {
        TripsModel.deleteTrip(tripId);
    }
}
