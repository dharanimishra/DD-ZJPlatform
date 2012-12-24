package com.ziksana.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.todo.Todo;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;

@Controller
@RequestMapping("/secure")
public class TodoController {
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	TodoService todoService;
	
	
	
	/**
	 * Retrive all todo items to display on the dashboard
	 */
	@RequestMapping(value = "/showmytodo/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showMyTodos(@PathVariable String memberId) {
		logger.info("Entering showMyTodos(): " + memberId);
		ModelAndView modelView = new ModelAndView("xml/todolist");
		//MemberPersona memberPersona = memberService.getMemberPersona(Integer.valueOf(memberId));
		
		modelView.addObject("todoItems", todoService.getTodos());
		logger.info("Exiting showMyTodos(): " + memberId);
		return modelView;
	}
	

	/**
	 * Retrive Three todo items to display on the dashboard
	 */
	@RequestMapping(value = "/showtodo/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showTodos(@PathVariable String memberId) {
		logger.info("Entering showMyTodos(): " + memberId);
		ModelAndView modelView = new ModelAndView("xml/todolist");
		
		
		modelView.addObject("todoItems", todoService.getMapperTodos());
		logger.info("Exiting showMyTodos(): " + memberId);
		return modelView;
	}
	
	/**
	 * Creating new TODO item based on the Todo object
	 * @return mav
	 */
	@RequestMapping(value = "/createtodo", method = RequestMethod.POST)
	public @ResponseBody ModelAndView createTodo(
			@RequestParam(value = "category", required = true) String category,
			@RequestParam(value = "notificationContent", required = true) String notificationContent) {

		logger.info("Entering  the Create New Todo item");
		logger.info("category  :"+category);
		logger.info("NotificationContent  :"+notificationContent);
		// service call
		Todo todo = new Todo();
		todo.setCategory(category);
		todo.setNotificationContent(notificationContent.toString());
		todo.setActivationDate(new Date());
		todo.setNotificationType(2);
		MemberPersona creatingMember = new MemberPersona();
		creatingMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
		.getToken().getMemberPersonaId().getStorageID()));
		logger.info("Member Role Id :"+creatingMember.getMemberRoleId());
		todo.setCreatingMember(creatingMember);
		todo.setForMember(creatingMember);
		try {			
			todoService.createTodo(todo);
			
		} catch (Exception exception) {
			logger.error("Caught Exception. class ="+ exception.getClass().getName() + ",message ="+ exception.getMessage());
		}
		// retrun the Todo domain object
		ModelAndView modelView = new ModelAndView("xml/todolist");
		modelView.addObject("todoItems", todoService.getTodos());
		return modelView;

	}

	@RequestMapping(value = "/gettodopopupwindow", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("xml/moretodo");
		

		return modelAndView;
		
	}
	/**
	 * Delete a todo item based on todo item id
	 */
	@RequestMapping(value = "/deletetodo/{todoItemId}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteTodoItem(@PathVariable String todoItemId) {
		logger.info("Entering deleteTodoItem(): " + todoItemId);
		
		todoService.deleteTodo(Integer.valueOf(todoItemId));
		
		logger.info("Exiting deleteTodoItem(): " + todoItemId);
		return "Successfully Deleted";
	}

}
