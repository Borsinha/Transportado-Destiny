package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import models.Destiny;
import util.DbUtil;


public class DestinyDao {
	
	private Connection conn;

	public DestinyDao() {
		conn = DbUtil.getConnection();
	}
	
	public List<Destiny> getAllDestiny() {
		List<Destiny> listDestiny = new ArrayList<Destiny>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from destiny");
			while (rs.next()) {
				Destiny destiny = new Destiny();
				destiny.setId(rs.getInt("id"));
				destiny.setState(rs.getString("state"));
				listDestiny.add(destiny);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listDestiny;
	}

    public void addDestiny(Destiny destiny) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into destiny(nome, street, number, cep, city, state) values (?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, destiny.getName());
            preparedStatement.setString(2, destiny.getStreet());
            preparedStatement.setString(3, destiny.getNumber());
            preparedStatement.setString(4, destiny.getCep());
            preparedStatement.setString(5, destiny.getCity());
            preparedStatement.setString(6, destiny.getState());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateDestiny(Destiny destiny) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update destiny set nome=?, street=?, number=?, cep=?, city=?, state=?" +
                            "where id=?");
            preparedStatement.setString(1, destiny.getName());
            preparedStatement.setString(2, destiny.getStreet());
            preparedStatement.setString(3, destiny.getNumber());
            preparedStatement.setString(4, destiny.getCep());
            preparedStatement.setString(5, destiny.getCity());
            preparedStatement.setString(6, destiny.getState());
            preparedStatement.setInt(7, destiny.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Destiny getDestinyById(int id) {
    	Destiny destiny = new Destiny();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from destiny where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
				destiny.setId(rs.getInt("id"));
				destiny.setName(rs.getString("nome"));
				destiny.setStreet(rs.getString("street"));
				destiny.setNumber(rs.getString("number"));
				destiny.setCep(rs.getString("cep"));
				destiny.setCity(rs.getString("city"));
				destiny.setState(rs.getString("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return destiny;
    }

	
    public void deleteDestiny(int id) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("delete from destiny where id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
