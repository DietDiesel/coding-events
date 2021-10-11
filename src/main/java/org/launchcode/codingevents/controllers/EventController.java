package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    HashMap<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        events.put("WWDC", "Single-minded zealots awaiting instructions from the mothership");
        events.put("SpringLaunchBootCode", "Literally every front-end technology, ever");
        events.put("Lazy Larry's Swap & Shop Shack", "Only for the OG devs");

        model.addAttribute("events", events);
        return "events/index";
    }

    // URL /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    // URL /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, String eventDesc) {
        events.put(eventName, eventDesc);

        return "redirect:";
    }
}
