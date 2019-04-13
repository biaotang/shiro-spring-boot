package com.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/account/test1")
	public String test1() {
		return "test1 test1";
	}
	
	@RequestMapping("/account/test2")
	//必须要有account:add权限才能访问
	@RequiresPermissions("account:add")
	public String test2() {
		return "test2 test2";
	}
	
}
