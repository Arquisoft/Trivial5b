package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.User;

public interface UserDAO {

	List<User> getUsers();
	
	void save(long id);
	
	void remove(long id);
	
	void update(User user);
	
}
