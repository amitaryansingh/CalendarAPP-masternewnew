package calendar.app.services;

import calendar.app.entities.Message;
import calendar.app.entities.PriorityLevel;

import java.time.LocalDate;
import java.util.List;

public interface MessageService {

    Message createMessage(Message message);

    Message getMessageById(Integer id);

    Message updateMessage(Integer id, Message messageDetails);

    void deleteMessage(Integer id);

    List<Message> getAllMessages();

    List<Message> getMessagesByUserId(Integer userId);

    List<Message> getMessagesByCompanyId(Integer companyId);

    List<Message> getMessagesByPriorityLevel(PriorityLevel priorityLevel);

    List<Message> getMessagesBySeenStatus(boolean seen);

    List<Message> getMessagesWithinDateRange(LocalDate startDate, LocalDate endDate);
}
