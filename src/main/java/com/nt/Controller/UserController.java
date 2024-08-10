package com.nt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.Binding.FogotBinding;
import com.nt.Binding.LoginBinding;
import com.nt.Binding.RegBinding;
import com.nt.Binding.unlockBinding;
import com.nt.Entity.UserDetails;
import com.nt.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("unlock")
	public String unlock(@RequestParam String email, Model model) {
		unlockBinding unlock = new unlockBinding();
		unlock.setEmail(email);
		System.out.println(email);
		model.addAttribute("unlock", unlock);
		return "unlock";
	}

	@PostMapping("unlock")
	public String unlock(@ModelAttribute("unlock") unlockBinding unlockbind, Model model) {
		System.out.println(unlockbind);
		if (unlockbind.getNewPwd().equals(unlockbind.getConfirmPwd())) {
			boolean status = userService.unlocked(unlockbind);
			if (status) {
				model.addAttribute("sucmsg", "Account Unlocked SuccessFully");
				
			} else {
				model.addAttribute("errmsg", "Invalid Temprary Password");
							}
		} else {
			model.addAttribute("errmsg", "New Password and Confirm Password Should Be Same..");
			System.out.println("new and confirm passwort not same");
		}
		return "unlock";
	}

	@GetMapping("signup")
	public String singUp(Model model) {
		model.addAttribute("user", new RegBinding());
		return "signup";
	}

	@PostMapping("signup")
	public String getSignUpDate(@ModelAttribute("user") RegBinding regBinding, Model model) {
		boolean status = userService.singUp(regBinding);
		if (status) {
			model.addAttribute("sucMsg", " Account Created Successfully please Check Your Email");
		} else {
			model.addAttribute("errMsg", " Please Enter Unique Email This Email Already used..!");
		}
		return "signup";
	}

	@GetMapping("login")
	public String login(Model model) {
		LoginBinding login = new LoginBinding();
		model.addAttribute("login", login);
		return "login";
	}

	@PostMapping("login")
	public String login(@ModelAttribute("login") LoginBinding bind, Model model) {
		String status = userService.login(bind);
		if (status.contains("Success")) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("errMsg", status);
		}
		return "login";
	}

	@GetMapping("forgot")
	public String forgatPwd(FogotBinding fogotBinding, Model model) {
		model.addAttribute("forgot", fogotBinding);
		return "forgotPwd";
	}

	@PostMapping("forgot")
	public String PostforgatPwd(@ModelAttribute("forgot") FogotBinding fogotBinding, Model model) {
		System.out.println(fogotBinding.getEmail());
		String status = userService.fogotPwd(fogotBinding);
		if (status.contains("Success")) {
			model.addAttribute("sucmsg", "Your Password Send on Your Email , Please Check It..!");
		} else {
			model.addAttribute("errmsg", "Invalid Email");
		}
		return "forgotPwd";
	}

	public UserController() {
		// TODO Auto-generated constructor stub
	}

}
