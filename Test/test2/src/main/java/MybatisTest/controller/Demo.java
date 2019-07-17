package MybatisTest.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import MybatisTest.model.Rap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@Api(value="v1",description="第一版")
public class Demo {
	//首先获取一个执行sql语句得对象
	@Autowired
	private SqlSessionTemplate template;
	
	@ApiOperation(value="获取数据库数据",httpMethod="GET")
	@RequestMapping(value="/getusercode",method=RequestMethod.GET)
	public int getUserCount(){
		return template.selectOne("getUserCount");
	}
	
	@ApiOperation(value="添加用户",httpMethod="POST")
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public int adduser(@RequestBody Rap rap){
		int result=template.insert("addUser",rap);
		return result;
	}
	
	@ApiOperation(value="更新用户",httpMethod="POST")
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public int updateuser(@RequestBody Rap rap){
		return template.update("updateUser", rap);
	}
	
	@ApiOperation(value="删除用户",httpMethod="POST")
	@RequestMapping(value="/deleteuser",method=RequestMethod.POST)
	public int delectuser(@RequestParam int id){
		return template.delete("deleteUser", id);
	}
		

}