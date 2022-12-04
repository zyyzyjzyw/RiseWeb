package com.tedu.java.service.api;


import com.tedu.java.entity.po.MemberPO;

public interface MemberService {

	MemberPO getMemberPOByLoginAcct(String loginacct);

}
