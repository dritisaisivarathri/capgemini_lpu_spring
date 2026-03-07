package com.capgemini.assignment7_EventAnnouncementSystem_6Mar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment7_EventAnnouncementSystem_6Mar.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventType(String eventType);

    List<Event> findByTitleContaining(String title);

}