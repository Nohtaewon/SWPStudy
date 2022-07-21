package org.zerock.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@RequestMapping("/sample/*")
@Log4j
@Controller
public class SampleController {

	@GetMapping("/all")
	public void doAll() {
		log.info("do all can access everybody");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("logined member");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin only");
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER'")
	@GetMapping("/annomember")
	public void doMember2() {
		log.info("logined annotation member");
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoadmin")
	public void doAdmin2() {
		log.info("admin annotation only");
	}
}
