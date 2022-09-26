package repository;

import repository.user.User;

public interface UserDao {
	public int updateUserByUserCode(User user);
	public int updatePasswordByUserCode(int userCode, String password);
	public int deleteUser(int userCode);
}
