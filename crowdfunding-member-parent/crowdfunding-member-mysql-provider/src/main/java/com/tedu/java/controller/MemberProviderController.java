package com.tedu.java.controller;

import com.tedu.java.entity.po.MemberPO;
import com.tedu.java.service.api.MemberService;
import com.tedu.java.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MemberProviderController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/get/memberpo/by/login/acct/remote")
	public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
		
		try {
			
			// 1.调用本地Service完成查询
			MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
			
			// 2.如果没有抛异常，那么就返回成功的结果
			return ResultEntity.successWithData(memberPO);
		} catch (Exception e) {
			e.printStackTrace();
			
			// 3.如果捕获到异常则返回失败的结果
			return ResultEntity.failed(e.getMessage());
		}
		
	}

}
