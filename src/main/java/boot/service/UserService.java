package boot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import boot.domain.User;
import boot.repository.dao1.UserRepository;


@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	public User getUser(String username){
		return userRepository.getUser(username);
	}
	
	public void insert(User user){
		userRepository.insert(user);
	}

}
