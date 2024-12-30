package calendar.app.dto;

import calendar.app.entities.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Integer id;
    private String firstname;
    private String secondname;
    private String email;
    private String password; // Include the password field
    private Role role;
    private Set<Integer> companyIds; // IDs of associated companies
    private Set<Integer> messageIds; // IDs of associated messages
}
