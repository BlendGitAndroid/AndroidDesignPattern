package com.blend.androiddesignpattern.k_observer.eventbus.matchpolicy;

import com.blend.androiddesignpattern.k_observer.eventbus.EventType;

import java.util.List;

public interface MatchPolicy {
    List<EventType> findMatchEventTypes(EventType type, Object aEvent);
}
