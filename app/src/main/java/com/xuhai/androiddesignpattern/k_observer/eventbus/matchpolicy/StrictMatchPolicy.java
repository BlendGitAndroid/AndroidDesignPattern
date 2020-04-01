package com.xuhai.androiddesignpattern.k_observer.eventbus.matchpolicy;

import com.xuhai.androiddesignpattern.k_observer.eventbus.EventType;

import java.util.LinkedList;
import java.util.List;

public class StrictMatchPolicy implements MatchPolicy {
    @Override
    public List<EventType> findMatchEventTypes(EventType type, Object aEvent) {
        List<EventType> result = new LinkedList<EventType>();
        result.add(type);
        return result;
    }
}
