package boot.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import boot.domain.User;
import boot.service.UserService;

@Api(value = "用户操作")
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@ApiOperation(value = "根据用户名获取用户", notes="用户名必填")
	@ApiImplicitParam(name = "username", required = true)
	@RequestMapping(value = "/{username}", method = {RequestMethod.GET})
    @ResponseBody
    public String getUser(@PathVariable String username) {
		return userService.getUser(username).getPassword();
    }

	@ApiOperation(value = "保存用户", notes="post请求中请求参数是一个json,包括用户名密码,例如:{\"username\":\"zhangsan\",\"password\":\"123456\"}")
	@ApiImplicitParam(name = "user", required = true)
	@RequestMapping(value = "/saveUser", method = {RequestMethod.POST})
    @ResponseBody
    public String saveUser(@RequestBody User user) {
		try {
			userService.insert(user);
			return "success!";
		} catch (Exception e) {
			return "failure!";
		}
    }
}
