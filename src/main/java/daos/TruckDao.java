package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import models.Truck;
import util.DbUtil;

public class TruckDao {

	private Connection conn;

	public TruckDao() {
		conn = DbUtil.getConnection();
	}
	
	public List<Truck> getAllTrucks() {
		List<Truck> listTruck = new ArrayList<Truck>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from truck");
			while (rs.next()) {
				Truck truck = new Truck();
				truck.setId(rs.getInt("id"));
				truck.setModel(rs.getString("model"));
				truck.setDriver(rs.getString("driver"));
				truck.setTotalKm(rs.getString("totalKm"));
				truck.setCurrentLocation(rs.getString("currentLocation"));
				truck.setDestiny(rs.getInt("destiny"));
				listTruck.add(truck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listTruck;
	}

    public void addTruck(Truck truck) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into truck(model,driver,totalkm,currentLocation, destiny) values (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setString(2, truck.getDriver());
            preparedStatement.setString(3, truck.getTotalKm());
            preparedStatement.setString(4, truck.getCurrentLocation());
            preparedStatement.setInt(5, truck.getDestiny());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateTruck(Truck truck) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update truck set model=?, driver=?, totalkm=?, currentLocation=?, destiny=? " +
                            "where id=?");
            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setString(2, truck.getDriver());
            preparedStatement.setString(3, truck.getTotalKm());
            preparedStatement.setString(4, truck.getCurrentLocation());
            preparedStatement.setInt(5, truck.getDestiny());
            preparedStatement.setInt(6, truck.getId());
            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Truck getTruckById(int id) {
        Truck truck = new Truck();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from truck where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                truck.setId(rs.getInt("id"));
                truck.setModel(rs.getString("model"));
                truck.setDriver(rs.getString("driver"));
                truck.setTotalKm(rs.getString("totalKm"));
                truck.setCurrentLocation(rs.getString("currentLocation"));
                truck.setDestiny(rs.getInt("destiny"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return truck;
    }

	
    public void deleteTruck(int id) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("delete from truck where id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
