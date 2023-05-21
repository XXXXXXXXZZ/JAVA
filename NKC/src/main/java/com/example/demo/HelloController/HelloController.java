package com.example.demo.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String Hello(Model model) {

		model.addAttribute("data", "FFF");

		return "hello";
	}

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}

	@GetMapping("hello-string")
	@ResponseBody // html 파일없이 그냥 찍어냄 ?? 쓸일은 별로없음
	public String helloString(@RequestParam("name") String name) {

		return "hello" + name; // "hello spring"
	}

	@GetMapping("hello-api")
//	@ResponseBody 리턴 방식은 기본 JSON 방식 
	@ResponseBody // html 에서 Json 방식 형태로 표현 되는 형식
	public Hello helloApi(@RequestParam("name") String name) {

		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}

	static class Hello {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
