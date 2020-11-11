package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
}
