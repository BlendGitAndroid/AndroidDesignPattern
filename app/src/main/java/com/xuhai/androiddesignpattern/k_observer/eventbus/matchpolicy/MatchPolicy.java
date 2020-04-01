package com.xuhai.androiddesignpattern.k_observer.eventbus.matchpolicy;

import com.xuhai.androiddesignpattern.k_observer.eventbus.EventType;

import java.util.List;

public interface MatchPolicy {
    List<EventType> findMatchEventTypes(EventType type, Object aEvent);
}
