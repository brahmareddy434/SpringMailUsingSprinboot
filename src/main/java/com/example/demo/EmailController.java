package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class EmailController {
	@Autowired
	private EmailService emailService;

	@PostMapping
	public void sent() {
		emailService.mailsend("brahma.reddy@mendlegion.com", "Welocome", "Welcome to soft suave");
	}

	@PostMapping("/sent")
	public void Sent(@RequestParam("to") String to, @RequestParam("text") String text,@RequestParam("file") MultipartFile file,@RequestParam("date") Date date) throws Exception

	{
		emailService.sentondate(to, text,file,date);
	}

}
