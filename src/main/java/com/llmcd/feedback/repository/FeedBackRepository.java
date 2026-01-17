package com.llmcd.feedback.repository;

import com.llmcd.feedback.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {

    Optional<List<FeedBack>> findByPostId(Integer postId);

}
