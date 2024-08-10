package com.nt.service;

import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Binding.FogotBinding;
import com.nt.Binding.LoginBinding;
import com.nt.Binding.RegBinding;
import com.nt.Binding.unlockBinding;
import com.nt.Entity.UserDetails;
import com.nt.Repository.UserDetailsRepo;
import com.nt.Utility.EmailUtils;
import com.nt.Utility.PasswordUtlis;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private HttpSession session;
	
	@Override
	public String login(LoginBinding login) {
		UserDetails user = userDetailsRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if (user == null) {
			return "Invalid Details";
		}
		if (user.getStatus().equals("LOCKED")) {
			return "Account In Locked Stage..Please Unlock Account";
		}
		session.setAttribute("userId",user.getUserId());
		return "Success";
	}

	@Override
	public boolean singUp(RegBinding regBinding) {
		UserDetails user = userDetailsRepo.findByEmail(regBinding.getEmail());
		if (user != null) {
			return false;
		}
		// copy the copy the binding object into entity obj
		UserDetails userDetails = new UserDetails();
		BeanUtils.copyProperties(regBinding, userDetails);
		// generate the password;
		String pwd = PasswordUtlis.generatePassword();
		userDetails.setPassword(pwd);
		// set the password status;
		userDetails.setStatus("LOCKED");
		// insret the obj
		userDetailsRepo.save(userDetails);
		// send the mail
		String to = regBinding.getEmail();
		String subject = "Unlock Your Acccount | Ashok IT";
		StringBuffer body = new StringBuffer("");
		body.append("<h1>User The Below Temporary Password To Unlock Your Account</h1>");
		body.append(" Temporary Password :  " + pwd);
		body.append("<br>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click Here to Unlock Your Account</a>");
		emailUtils.sendMail(to, subject, body.toString());
		return true;
	}

	@Override
	public boolean unlocked(unlockBinding unlock) {
		UserDetails user = userDetailsRepo.findByEmail(unlock.getEmail());
		if (user.getPassword().equals(unlock.getTempPwd())) {
			user.setPassword(unlock.getNewPwd());
			user.setStatus("UNLOCKED");
			userDetailsRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public String fogotPwd(FogotBinding binding) {
		UserDetails user = userDetailsRepo.findByEmail(binding.getEmail());
		if (user == null) {
			return "Invalid";
		}
		// send the mail
		String to = binding.getEmail();
		String subject = "Your Account Password | Ashok IT";
		StringBuffer body = new StringBuffer("");
		body.append("<h1>User The Below Password to Use Login Account</h1>");
		body.append("  Password :  " + user.getPassword());
		body.append("<br>");

		emailUtils.sendMailFogotPws(to, subject, body.toString());

		
		return "Success";
	}

}
