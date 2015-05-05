package persistence;

import java.util.List;

import logica.User;

public interface UserDAO {

	List<User> getUsers();
	
	void save(long id);
	
	void remove(long id);
	
	void update(User user);
	
}
