package com.llmcd.feedback.controller;

import com.llmcd.feedback.model.FeedBack;
import com.llmcd.feedback.service.FeedBackService;
import com.llmcd.feedback.shared.SendFeedBackDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Feedback", description = "Management of feedbacks")
public class FeedbackController {

    private final FeedBackService feedBackService;

    public FeedbackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @PostMapping("/sendFeedback")
    @Operation(summary = "Register feedback", description = "rating valid range = 0 - 5")
    public ResponseEntity<?> feedbackInsert(@RequestBody SendFeedBackDTO data) throws BadRequestException {
        Integer id = feedBackService.saveFeedback(data.iduser(), data.rating(), data.comment(), data.postId());
        HashMap<String, String> response= new HashMap<>();
        response.put("message", "FeedBack was include with sucess");
        response.put("id", id.toString());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/serchFeedback")
    @Operation(summary = "Find feedbacks of a postage", description = "Use param postId")
    public Optional<List<FeedBack>> feedbackSearch(@RequestParam Integer postId){
        return feedBackService.findFeedbackPost(postId);
    }

}
