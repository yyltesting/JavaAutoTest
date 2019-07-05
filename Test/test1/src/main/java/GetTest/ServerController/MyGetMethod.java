package GetTest.ServerController;



import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//阐述我是被扫描的
@RestController
@Api(value = "/" , description = "这是我全部的GET方法")

public class MyGetMethod {
	//返回cookies信息的GET请求
	@RequestMapping(value="/getcookies",method = RequestMethod.GET)
	@ApiOperation(value = "通过这个方法可以获取cookie" , httpMethod = "GET")
	public String GetCookies(HttpServletResponse response){
		//HttpServerletRequest 装请求信息的类
		//HttpServerletResponse 装响应信息的类
		Cookie cookie = new Cookie("login","true");
		response.addCookie(cookie);
		return "返回cookies成功";
	}
	//要求客户端携带cookies访问
	//携带cookie信息访问的get请求
	@RequestMapping(value = "/getwithcookies",method = RequestMethod.GET)
	@ApiOperation(value = "要求客户端携带cookies访问" , httpMethod = "GET")
	public String GetWithCookirs(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(Objects.isNull(cookies)){
			return "请携带cookies来";
		}
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("login")&&
				cookie.getValue().equals("true")){
					return "携带正确cookies请求成功";
					}
				}
		return "cookie错误";
	}
	//开发一个需要携带参数才能访问的GET请求
	//第一种实现方式 url:key=value&key=value
	//模拟获取商品列表
	@RequestMapping(value = "/getparam/whit" , method = RequestMethod.GET)
	@ApiOperation(value = "携带第一种参数的请求" , httpMethod = "GET")
	public Map<String, Integer>getlist(@RequestParam Integer start,@RequestParam Integer end){
		Map<String, Integer> mylist = new HashMap<>();
		mylist.put("牛肉面", 12);
		mylist.put("杂酱面", 13);
		mylist.put("番茄鸡蛋面", 10);
		return mylist;
	}
	//开发第二种携带参数的访问get请求
	@RequestMapping(value = "/get/param/{start}/{end}" , method = RequestMethod.GET)
	@ApiOperation(value = "携带第二种参数请求" , httpMethod = "GET")
	public Map<String, Integer> myGetlist(@PathVariable Integer start,@PathVariable Integer end){
		Map<String, Integer> mylist = new HashMap<>();
		mylist.put("牛肉面", 12);
		mylist.put("杂酱面", 13);
		mylist.put("番茄鸡蛋面", 10);
		return mylist;
	}
}



