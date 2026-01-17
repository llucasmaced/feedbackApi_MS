package com.llmcd.feedback.service;

import com.llmcd.feedback.model.FeedBack;
import com.llmcd.feedback.repository.FeedBackRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackService {

    //Tambem podemos user autowired
    private final FeedBackRepository feedBackRepository;

    public FeedBackService(FeedBackRepository feedBackRepository) {
        this.feedBackRepository = feedBackRepository;
    }

    public Integer saveFeedback(Integer iduser,Integer rating, String coment, Integer postId) throws BadRequestException {

        if(rating == null){
            throw new IllegalArgumentException("rating can't be null");
        }
        if (iduser == null){
            throw new IllegalArgumentException("iduser can't be null");
        }
        if(postId == null){
            throw new IllegalArgumentException("postId can't be null");
        }

        if (rating > 5 || rating < 0){
            throw new IllegalArgumentException("Rating range is 0 - 5");
        }
        try {
            FeedBack feedBack = new FeedBack(iduser, rating, coment, postId);
            feedBackRepository.save(feedBack);
            return feedBack.getId();
        } catch (Exception e){
            throw new BadRequestException("Can't continue now");
        }

    }


    public Optional<List<FeedBack>> findFeedbackPost(Integer postId){
        return feedBackRepository.findByPostId(postId);
    }

}
