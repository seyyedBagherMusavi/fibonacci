package com.smart.demo.conf;

import com.smart.demo.model.Role;
import com.smart.demo.model.User;
import com.smart.demo.repo.RoleRepository;
import com.smart.demo.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitData implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder BcEncoder;

    public void run(ApplicationArguments args) {
        Role role = roleRepository.findRoleByRoleName("Role_ADMIN").orElse( null);
        if(role == null){
            role = new Role();
            role.setRoleName("Role_ADMIN");
            roleRepository.saveAndFlush(role);
        }
        User user = userRepository.findByUserName("admin").orElse(null);
        if(user == null) {
            String userName = "admin";
            String password = BcEncoder.encode("user");
            user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setRole(role);
            userRepository.saveAndFlush(user);
        }
    }
}
