package com.nt.service;

import java.util.List;

import com.nt.Binding.FogotBinding;
import com.nt.Binding.LoginBinding;
import com.nt.Binding.RegBinding;
import com.nt.Binding.unlockBinding;
import com.nt.Entity.UserDetails;

public interface UserService {
	
	
	public String login(LoginBinding loginBinding);
	public boolean singUp(RegBinding regBinding);
	public boolean unlocked(unlockBinding unlock);
	public String fogotPwd(FogotBinding binding);
	
	
	
	

}
