package com.llmcd.feedback.controller;

import com.llmcd.feedback.model.FeedBack;
import com.llmcd.feedback.service.FeedBackService;
import com.llmcd.feedback.shared.SendFeedBackDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    private final FeedBackService feedBackService;

    public FeedbackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @PostMapping("/sendFeedback")
    public ResponseEntity<?> feedbackInsert(@RequestBody SendFeedBackDTO data) throws BadRequestException {
        Integer id = feedBackService.saveFeedback(data.iduser(), data.rating(), data.comment(), data.postId());
        HashMap<String, String> response= new HashMap<>();
        response.put("message", "FeedBack was include with sucess");
        response.put("id", id.toString());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/serchFeedback")
    public Optional<List<FeedBack>> feedbackSearch(@RequestParam Integer postId){
        return feedBackService.findFeedbackPost(postId);
    }

}
