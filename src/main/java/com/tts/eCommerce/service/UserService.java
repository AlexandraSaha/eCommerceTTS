package com.tts.eCommerce.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.tts.eCommerce.model.Role;
import com.tts.eCommerce.model.User;
import com.tts.eCommerce.repository.RoleRepository;
import com.tts.eCommerce.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {
private UserRepository userRepository;
private RoleRepository roleRepository;
private BCryptPasswordEncoder bCryptPasswordEncoder;

@Autowired
public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
}

public User findByUsername(String username) {
    return userRepository.findByUsername(username);
}

public User saveNewUser(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(1);
    Role userRole = roleRepository.findByRole("ADMIN");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    return userRepository.save(user);
}
}