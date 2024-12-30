package calendar.app.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CompanyDTO {
    private Integer id;
    private String name;
    private String logoUrl;
    private String location;
    private String linkedInProfile;
    private List<String> emails;
    private List<String> phoneNumbers;
    private String comments;
    private String communicationPeriodicity;
    private Set<Integer> userIds; // IDs of associated users
    private Set<Integer> messageIds; // IDs of associated messages
}
