package com.ziksana.controller.calendar;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.DHXStatus;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.ziksana.domain.calendar.Calendar;
import com.ziksana.service.calendar.ICalendarService;

@Controller
public class CalendarController {
	
@Autowired
private ICalendarService calendarService;
	
@Value("#{pagination['eventsitemsperpage']}")
private String itemsPerPage;


	@RequestMapping(value = "/calendarevents/{pageIndex}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getCalendarDatas(@PathVariable String pageIndex) {
		// creates and configures scheduler instance
		ModelAndView mnv = new ModelAndView("xml/calendar");
		
		List<Calendar> calendarList = new ArrayList<Calendar>();
		int calenderSize =0;
		calendarList = calendarService.getTodayCalenderEvents(Integer.parseInt(pageIndex),Integer.parseInt(itemsPerPage));
		
		 calenderSize = calendarService.getCalendarSize();
		
			mnv.addObject("calendarList", calendarList);
		
			mnv.addObject("calendarSize", calenderSize);
	
	    return mnv;
	}



	@RequestMapping("/01_simple_init")
    public ModelAndView scheduler_01(HttpServletRequest request) throws Exception {
    	// creates and configures scheduler instance
		
		
    	DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
    	java.util.Calendar cal;
    
    	
    	s.setInitialDate(2013, 1, 7);
    	s.config.setScrollHour(8);
    	s.setWidth(900);
    	

    	s.load("03_events", DHXDataFormat.JSON);
    	s.data.dataprocessor.setURL("03_events");
    	
    	ModelAndView mnv = new ModelAndView("calendar/article");
    	
    	mnv.addObject("title", "Scheduler - Simple init");
        	// puts scheduler code in view
		mnv.addObject("body", s.render());

        return mnv;
    }
	@RequestMapping("/03_events")
    @ResponseBody public String events_03(HttpServletRequest request) {
    	CustomEventManager evs = new CustomEventManager(request);
    	return evs.run();
    }
	 class CustomEventManager extends DHXEventsManager{

		public CustomEventManager(HttpServletRequest arg0) {
			super(arg0);
			
		}
		public Iterable getEvents() {
	        ArrayList events = new ArrayList();

	        
	        List<Calendar> calendarList = new ArrayList<Calendar>();
	        calendarList = calendarService.getAllCalenderEvents();
	        for(Calendar c :calendarList){
	        	DHXEvent ev = new DHXEvent();
	        	ev.setId(c.getEventId());
	        	ev.setText(c.getEventName());
	        	ev.setStart_date(c.getStartDate());
	        	ev.setEnd_date(c.getEndDate());
	        	events.add(ev);
	        }
	        return events;
	}
		public Integer saveEvent(DHXEv event, DHXStatus status) {
			
			try {
				Calendar cal = new Calendar();
				
	 
				if (status == DHXStatus.UPDATE){
					cal.setEventId(event.getId());
					cal.setEventName(event.getText());
					cal.setStartDate(event.getStart_date());
					cal.setEndDate(event.getEnd_date());
					calendarService.updateCalendarInfo(cal);
				}else if (status == DHXStatus.DELETE){
					calendarService.deleteCalendarInfo(event.getId());
				}else if (status == DHXStatus.INSERT){
					cal.setEventName(event.getText());
					cal.setStartDate(event.getStart_date());
					cal.setEndDate(event.getEnd_date());
					calendarService.saveCalendarObject(cal);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return event.getId();
		}
		

}
}