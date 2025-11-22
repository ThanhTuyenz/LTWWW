package iuh.fit.se.seeds;


import iuh.fit.se.entities.Permission;
import iuh.fit.se.entities.Role;
import iuh.fit.se.entities.User;
import iuh.fit.se.repositories.PermissionRepository;
import iuh.fit.se.repositories.RoleRepository;
import iuh.fit.se.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(PermissionRepository permissionRepository,
                      RoleRepository roleRepository,
                      UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            Permission read = permissionRepository.save(new Permission(null, "DOCUMENT:READ"));
            Permission write = permissionRepository.save(new Permission(null, "DOCUMENT:WRITE"));

            Role userRole = new Role(null, "ROLE_USER", Set.of(read));
            Role adminRole = new Role(null, "ROLE_ADMIN", Set.of(read, write));
            roleRepository.saveAll(List.of(userRole, adminRole));

            User user = new User(null, "user", passwordEncoder.encode("123456"), true, Set.of(userRole));
            User admin = new User(null, "admin", passwordEncoder.encode("123456"), true, Set.of(adminRole));
            userRepository.saveAll(List.of(user, admin));
        }
    }
}
