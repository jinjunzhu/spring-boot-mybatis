package boot.repository.dao1;

import boot.domain.User;
import org.springframework.context.annotation.DependsOn;

@DependsOn("mybatisConfig")
public interface UserRepository{

	User getUser(String username);
	
	void insert(User user);
	


}
