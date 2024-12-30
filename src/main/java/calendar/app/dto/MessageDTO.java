package calendar.app.dto;

import calendar.app.entities.MessageType;
import calendar.app.entities.PriorityLevel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MessageDTO {
    private Integer id;
    private MessageType name;
    private String description;
    private LocalDate date;
    private boolean mandatoryFlag;
    private PriorityLevel priorityLevel;
    private boolean seen;
    private Integer userId; // ID of the associated user
    private Integer companyId; // ID of the associated company
}
