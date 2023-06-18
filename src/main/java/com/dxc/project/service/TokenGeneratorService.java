package com.dxc.project.service;

import java.util.Map;

import com.dxc.project.model.*;

public interface TokenGeneratorService {
	Map<String,String> generateToken(User user);

}
