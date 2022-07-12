package web.service;

import java.util.Map;

import repository.user.User;

public interface AuthService {
	public Map<String, ?> signin(String username, String password);
	
}
