package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import logica.User;
import persistence.Jdbc;
import persistence.UserDAO;

public class UserJdbcDAO implements UserDAO {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try {
			con = Jdbc.getConnection();
			ps = con.prepareStatement("select * from tuser");
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setApellidos(rs.getString("LOGIN"));
				user.setNombre(rs.getString("NAME"));
				user.setApellidos(rs.getString("LASTNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				users.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null && rs != null)
				Jdbc.close(rs, ps);
			if (con != null)
				Jdbc.close(con);
		}
		return users;
	}

	public void save(long id) {
		// TODO Auto-generated method stub

	}

	public void remove(long id) {
		// TODO Auto-generated method stub

	}

	public void update(User user) {
		// TODO Auto-generated method stub

	}

}
