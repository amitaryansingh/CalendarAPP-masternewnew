package calendar.app.services.impl;

import calendar.app.entities.Message;
import calendar.app.entities.PriorityLevel;
import calendar.app.repository.MessageRepository;
import calendar.app.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message createMessage(Message message) {
        // Validate mandatory fields (e.g., name, priorityLevel)
        if (message.getName() == null) {
            throw new IllegalArgumentException("Message name cannot be null");
        }
        if (message.getPriorityLevel() == null) {
            throw new IllegalArgumentException("Priority level cannot be null");
        }
        return messageRepository.save(message);
    }

    @Override
    public Message getMessageById(Integer id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message with ID " + id + " not found"));
    }

    @Override
    public Message updateMessage(Integer id, Message messageDetails) {
        // Fetch existing message
        Message existingMessage = getMessageById(id);

        // Update fields only if new values are provided
        if (messageDetails.getName() != null) {
            existingMessage.setName(messageDetails.getName());
        }
        if (messageDetails.getDescription() != null) {
            existingMessage.setDescription(messageDetails.getDescription());
        }
        if (messageDetails.getDate() != null) {
            existingMessage.setDate(messageDetails.getDate());
        }
        existingMessage.setMandatoryFlag(messageDetails.isMandatoryFlag());
        if (messageDetails.getPriorityLevel() != null) {
            existingMessage.setPriorityLevel(messageDetails.getPriorityLevel());
        }
        existingMessage.setSeen(messageDetails.isSeen());

        return messageRepository.save(existingMessage);
    }

    @Override
    public void deleteMessage(Integer id) {
        // Check if the message exists before deleting
        if (!messageRepository.existsById(id)) {
            throw new RuntimeException("Message with ID " + id + " not found");
        }
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getMessagesByUserId(Integer userId) {
        return messageRepository.findByUserId(userId);
    }

    @Override
    public List<Message> getMessagesByCompanyId(Integer companyId) {
        return messageRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Message> getMessagesByPriorityLevel(PriorityLevel priorityLevel) {
        return messageRepository.findByPriorityLevel(priorityLevel);
    }

    @Override
    public List<Message> getMessagesBySeenStatus(boolean seen) {
        return messageRepository.findBySeen(seen);
    }

    @Override
    public List<Message> getMessagesWithinDateRange(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }
        return messageRepository.findMessagesWithinDateRange(startDate, endDate);
    }
}
