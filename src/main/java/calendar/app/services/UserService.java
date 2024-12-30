package calendar.app.services;

import calendar.app.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDetailsService userDetailsService();

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Integer id);

    UserDTO updateUser(Integer id, UserDTO userDTO);

    void deleteUser(Integer id);

    List<UserDTO> getAllUsers();

    UserDTO findByEmail(String email);
}
