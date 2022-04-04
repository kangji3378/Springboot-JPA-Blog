package com.cos.blog.ttestt;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML 파일)
// @Controller

//사용자가 요청 -> 응답(Data)

@RestController
public class HttpControllerTtestt {
	
	private static final String TAG="HttpControllerTtestt : ";
	
	// localhost:8080/blog/http/lombok
	@GetMapping("/http/loombok")
	public String lombokTest() {
		Member m= Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG+"getter : "+ m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"getter : "+  m.getUsername());
		return "lombook test 완료";
	}
	
	
	// http://localhost:8080/blog/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {//id=1&username=kang&password=123&email=kang.nate.com

		return "get 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}