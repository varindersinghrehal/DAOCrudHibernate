package entity;

import java.sql.SQLException;
import java.util.List;

//import jdbc.Users;

public interface DaoUsersHibe {

	Users getUser(int id)throws SQLException;
	List<Users> getAllUsers()throws SQLException;
	void addUser(Users user)throws SQLException;
	void updateUser(Users user)throws SQLException;
	void deleteUser(int id)throws SQLException;
	
}
