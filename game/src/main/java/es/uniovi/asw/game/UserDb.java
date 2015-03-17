package es.uniovi.asw.game;

import java.util.SortedMap;
import java.util.TreeMap;

public class UserDb {

	private SortedMap<String, User> table = new TreeMap<String, User>();

	public void addUser(String name, String password) {
		table.put(name, new User(name, password));
	}

	public Integer size() {
		return table.size();
	}

	public User lookup(String name) {
		return table.get(name);
	}

	public Boolean login(String name, String password) {
		if (table.containsKey(name)) {
			User u = lookup(name);
			return u.getPassword().equals(password);
		} else
			return false;
	}
}
