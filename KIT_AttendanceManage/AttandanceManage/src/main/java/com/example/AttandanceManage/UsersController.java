package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UsersController {
	@Autowired
	UserCrudRepository userRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/users")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "roleAdmin/users/index";
	}

	@GetMapping("/user/add")
	public String add(Model model) {
		return "roleAdmin/users/add";
	}

	@PostMapping("/user/create")
	public String create(@ModelAttribute MyUser user) {
		String sql = "INSERT INTO my_user (name, role, password) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getName(), "ADMIN", "12345");

		return "redirect:/users";
	}
	@GetMapping("/user/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("users", userRepository.findByName("user3").get());
		return "roleAdmin/users/edit";
	}
	@PostMapping("/user/update/{id}")
	public String update(@ModelAttribute MyUser user) {
		System.out.println(user);
		userRepository.save(user);

		return "redirect:/users";
	}

	@PostMapping("/user/delete/{id}")
	public String delete(@ModelAttribute MyUser user) {
		userRepository.delete(user);
		return "redirect:/users";
	}
}


