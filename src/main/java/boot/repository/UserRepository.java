package boot.repository;

import org.springframework.stereotype.Repository;

import boot.domain.User;
import boot.support.AbstractMybatisDaoSupport;

@Repository
public class UserRepository extends AbstractMybatisDaoSupport<User>{

	public User getUser(String username){
		return selectOne(firstSqlSession,"User.getUser", username);
	}
	
	public void insert(User user){
		insert(firstSqlSession,"User.saveUser", user);
	}
	


}
