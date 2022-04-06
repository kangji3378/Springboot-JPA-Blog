package com.cos.blog.ttestt;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyController {
	
	@Autowired//의존성 주입(DI)
	private UserRepository userRepository;
	
	// {id} 주소로 파마레터를 전달 받을 수 있음
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4 을 찾으면 내가 데이터베이스에서 못 찾아오게 되면 user가 null이 됨
		//그럼 return null 이 리턴되므로 프로그램에 문제가 생길 수 있음
		//Optional로 너의 User객체를 감싸서 가져올테니 null인지 아닌지 판단 후 return
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는  없습니다. id : "+id);
			}
		});
		return user;
		
	}
	
	// htttp://localhost:8000/blog/dummy/join (요청)
	@PostMapping("/dummy/join")
		public String join(User user) {
			System.out.println("id : "+user.getId());
			System.out.println("username : "+user.getUsername());
			System.out.println("password : "+user.getPassword());
			System.out.println("email : "+user.getEmail());
			System.out.println("role : "+user.getRole());
			System.out.println("createDate : "+user.getCreateDate());
			
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return"회원가입 완료";
	}
}
