package boot.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.domain.User;
import boot.service.UserService;

@Controller
public class UserController {


	
	@Resource
	private UserService userService;

	@RequestMapping("/{username}")
    @ResponseBody
    public String getPassword(@PathVariable String username) {
		String passwd = userService.getUser(username).getPassword();
		return passwd;
    }
	
	@RequestMapping("/saveUser/{username}")
    @ResponseBody
    public String saveUser(@PathVariable String username) {
		User user = new User();
		user.setUsername(username);
		user.setPassword("111111");
		try {
			userService.insert(user);
			return "success!";
		} catch (Exception e) {
			return "failure!";
		}
    }


}
