package PostTest.ServerController;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;





//阐述我是被扫描的
@RestController
@Api(value = "/" , description = "这是我全部的POST方法")


public class PostMethod {
	//这个变量用来装取cookies
	public static Cookie cookie;
	
	//用户登录成功后获取cookie并访问其他接口
	@RequestMapping(value="/postcookies",method = RequestMethod.POST)
	@ApiOperation(value = "登陆成功后成功获取cookie" , httpMethod = "POST")
	//用户名和密码登录且在前端是必填项
	public String login(HttpServletResponse response ,
			@RequestParam(value = "userName",required = true) String username , 
			@RequestParam(value = "passWord",required = true) String password){
		if (username.equals("yyl")&&(password.equals("123456"))) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			return "恭喜你登录成功";
		}
		else {
			return "用户名或密码错误";
		}
	}
	//需要cookie认证的获取用户列表操作
	@RequestMapping(value="/getuserlist",method=RequestMethod.POST)
	@ApiOperation(value="登录成功后获取用户列表",httpMethod="POST")
	public String getUserList(HttpServletRequest request,
			@RequestBody User u){
		User user;
		//获取cookie
		Cookie[] cookies = request.getCookies();
		//验证cookie是否合法
		for(Cookie c : cookies){
			if(c.getName().equals("login")
					&&c.getValue().equals("true")
					&&u.getUsername().equals("yyl")
					&&u.getPassword().equals("123456")){
			user = new User();
			user.setName("牛逼");
			user.setAge("22");
			user.setSex("大");
			return user.toString();
			}
		}
		return "参数不合法";
	}


}
