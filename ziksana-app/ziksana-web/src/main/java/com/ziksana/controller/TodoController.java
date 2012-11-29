package com.ziksana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.member.MemberPersona;
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
	 * Delete a todo item based on todo item id
	 */
	@RequestMapping(value = "/deletetodo/{memberId}/{todoItemId}", method = RequestMethod.DELETE)
	public @ResponseBody ModelAndView deleteTodoItem(@PathVariable String memberId, @PathVariable String todoItemId) {
		logger.info("Entering deleteTodoItem(): " + memberId + " " + todoItemId);
		ModelAndView modelView = new ModelAndView("jsonView");
				
		//todoService.deleteTodoItem(Integer.valueOf(memberId), Integer.valueOf(todoItemId));
		
		logger.info("Exiting deleteTodoItem(): " + memberId + " " + todoItemId);
		return modelView;
	}

}
