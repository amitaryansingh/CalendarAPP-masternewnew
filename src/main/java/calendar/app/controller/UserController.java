//package calendar.app.controller;
//
//import calendar.app.entities.Message;
//import calendar.app.entities.PriorityLevel;
//import calendar.app.entities.User;
////import calendar.app.services.MessageService;
//import calendar.app.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/calendarapp/user")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//    private final MessageService messageService;
//
//    // Fetch user profile by ID
//    @GetMapping("/profile/{id}")
//    public ResponseEntity<User> getUserProfile(@PathVariable Integer id) {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }
//
//    // Fetch messages associated with the user
//    @GetMapping("/messages/{userId}")
//    public ResponseEntity<List<Message>> getMessagesByUserId(@PathVariable Integer userId) {
//        List<Message> messages = messageService.getMessagesByUserId(userId);
//        return ResponseEntity.ok(messages);
//    }
//
//    // Fetch messages by priority level
//    //calendarapp/user/messages/priority?priorityLevel=HIGH
//    @GetMapping("/messages/priority")
//    public ResponseEntity<List<Message>> getMessagesByPriorityLevel(@RequestParam("priorityLevel") String priorityLevel) {
//        try {
//            // Assuming PriorityLevel is an Enum with values like LOW, MED, HIGH
//            List<Message> messages = messageService.getMessagesByPriorityLevel(PriorityLevel.valueOf(priorityLevel.toUpperCase()));
//            return ResponseEntity.ok(messages);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    // Fetch messages by seen status
//
//    @GetMapping("/messages/seen")
//    public ResponseEntity<List<Message>> getMessagesBySeenStatus(@RequestParam("seen") boolean seen) {
//        List<Message> messages = messageService.getMessagesBySeenStatus(seen);
//        return ResponseEntity.ok(messages);
//    }
//
//    // Fetch messages within a date range
//    @GetMapping("/messages/date-range")
//    public ResponseEntity<List<Message>> getMessagesWithinDateRange(
//            @RequestParam("startDate") String startDate,
//            @RequestParam("endDate") String endDate) {
//        try {
//            LocalDate start = LocalDate.parse(startDate);
//            LocalDate end = LocalDate.parse(endDate);
//            List<Message> messages = messageService.getMessagesWithinDateRange(start, end);
//            return ResponseEntity.ok(messages);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//}
