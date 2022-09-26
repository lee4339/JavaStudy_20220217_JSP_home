package web.service;

import repository.UserDao;
import repository.user.User;

public class ProfileServiceImpl implements ProfileService{
	private final UserDao userDao;
	
	public ProfileServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean updateProfile(int userCode, String name, String email) {
		User user = User.builder()
				.user_code(userCode)
				.name(name)
				.email(email)
				.build();
		
		boolean flag = false;
		
		int result = userDao.updateUserByUserCode(user);
		
		if(result == 1) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean updatePassword(int userCode, String password) {
		int flag = userDao.updatePasswordByUserCode(userCode, password);
		return flag != 0 ? true : false;
	}

	@Override
	public boolean deleteUser(int userCode) {
		int flag = userDao.deleteUser(userCode);
		return flag != 0 ? true : false;
	}

}
