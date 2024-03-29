package com.org.hazelcache04.server;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.org.hazelcache01.entity.User;
import com.org.hazelcache02.database.Users;

public class MyApplication {

	private final Map<String, User> loggedOnUsers;

	private final Users userDB = new Users();

	private final SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss-SS");

	private long lastChange;

	public MyApplication() {

		HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance();

		loggedOnUsers = hazelcast.getMap("Users");
	}

	/**
	 * A user logs on to the application
	 *
	 * @param username
	 *            The user name
	 */
	public void logon(String username) {

		User user = userDB.getByEntity(username);

		loggedOnUsers.put(username, user);
		lastChange = System.currentTimeMillis();
	}

	/**
	 * The user logs out (or off depending on your pov).
	 */
	public void logout(String username) {

		loggedOnUsers.remove(username);
		lastChange = System.currentTimeMillis();
	}

	/**
	 * @return Return true if the user is logged on
	 */
	public boolean isLoggedOn(String username) {
		return loggedOnUsers.containsKey(username);
	}

	/**
	 * Return a list of the currently logged on users – perhaps to sys admin.
	 */
	public Collection<User> loggedOnUsers() {
		return loggedOnUsers.values();
	}

	/**
	 * Display the logged on users
	 */
	public void displayUsers() {

		StringBuilder sb = new StringBuilder("Logged on users:\n");
		Collection<User> users = loggedOnUsers.values();
		for (User user : users) {
			sb.append(user);
			sb.append("\n");
		}
		sb.append(loggedOnUsers.size());
		sb.append(" — ");
		sb.append(sdf.format(new Date(lastChange)));
		sb.append("\n");
		System.out.println(sb.toString());
	}

}
