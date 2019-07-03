/**
 * 
 */
package com.imooc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;

/**
 * @author linhaifeng1
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@PostMapping
	public User create(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getId());
		user.setId("1");
		return user;
	}
	
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	@GetMapping("/user")
	@GetMapping
	@JsonView(User.UserSimpleView.class)
//	public List<User> query(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {
	public List<User> query(UserQueryCondition condition, @PageableDefault(page = 2, size = 17, sort = "username,asc")Pageable pagebale) {
		
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		
		System.out.println(pagebale.getPageSize());
		System.out.println(pagebale.getPageNumber());
		System.out.println(pagebale.getSort());
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
//	@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
//	@GetMapping("/user/{id:\\d+}")
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable(name = "id") String userId) {
		User user = new User();
		user.setUsername("tom");
		return user;
	}
	
}