package com.ziksana.controller.recommendations;

import static com.ziksana.util.Util.getHeader;

import java.util.Date;
import java.util.List;

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

import com.ziksana.domain.common.ZiksanaMessage;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.domain.todo.Todo;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.recommendations.RecommendationsService;
import com.ziksana.service.todo.TodoService;

/**
 * @author vtg-p13
 * 
 * @version $Revision: 1.0 $
 */
@Controller
@RequestMapping("/zrecommendations")
public class RecommendationsController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RecommendationsController.class);

	@Autowired
	private RecommendationsService recomendationsService;

	@Autowired
	private TodoService todoService;

	/**
	 * 
	 * @param category
	 *            category of the recommendations(Possible values are )
	 * @return
	 */
	@RequestMapping(value = "/getrecommendationbycategory/{category}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showRecommendationsByCategory(@PathVariable Integer category) {

		ModelAndView modelAndView = new ModelAndView("xml/zrecommendations");

		try {
			List<Recommendation> recommendations = recomendationsService
					.getRecommendations(category);

			// Creating ziksana message
			ZiksanaMessage<Recommendation> message = new ZiksanaMessage<Recommendation>();

			message.setContent(recommendations);
			message.setHeader(getHeader(getClass().getSimpleName().toUpperCase()));

			modelAndView.addObject("recommendations", recommendations);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Exit Recommend By category");
		return modelAndView;
	}

	@RequestMapping(value = "/getallrecomendations", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getRecommendationsAllRecommendations() {

		ModelAndView modelAndView = new ModelAndView("xml/zrecommendations");

		try {
			List<Recommendation> recommendations = recomendationsService
					.getAllRecommendations();

			modelAndView.addObject("recommendations", recommendations);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/getthreerecomendations", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getRecommendations() {

		ModelAndView modelAndView = new ModelAndView("xml/zrecommendations");

		try {
			List<Recommendation> recommendations = recomendationsService
					.getMapperRecommendation();

			modelAndView.addObject("recommendations", recommendations);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/updaterecommendation", method = RequestMethod.POST)
	public @ResponseBody
	Integer updateRecommendationCategory(
			@RequestParam(value = "recommendationId", required = true) Integer recommendationId,
			@RequestParam(value = "category", required = true) Integer category) {

		Recommendation recommend = new Recommendation();
		int updatedRow = 0;
		try {
			recommend = recomendationsService
					.getRecommendationByRecommendationId(recommendationId);

			// get ignorecount and increment by one
			int ignoreCount = recommend.getIgnoreCount();
			LOGGER.debug("ignoreCount==>" + ignoreCount);
			ignoreCount = ignoreCount + 1;
			LOGGER.debug("ignoreCount incremented==>" + ignoreCount);

			updatedRow = recomendationsService.updateRecommendationsCategoryById(
					recommendationId, category, ignoreCount);
			LOGGER.debug("updated row==>" + updatedRow);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return updatedRow;

	}

	@RequestMapping(value = "/createtodoandrecomendationupdation", method = RequestMethod.POST)
	public @ResponseBody
	Integer createTodoAndUpdateRecommendation(
			@RequestParam(value = "categoryName", required = true) String categoryName,
			@RequestParam(value = "notificationContent", required = true) String notificationContent,

			@RequestParam(value = "recommendationId", required = true) Integer recommendationId,
			@RequestParam(value = "category", required = true) Integer category) {

		int updatedRow = 0;
		try {
			// creating a todo
			Todo todo = new Todo();
			todo.setCategory(categoryName);
			todo.setNotificationContent(notificationContent.toString());
			todo.setActivationDate(new Date());
			
			todo.setNotificationType(491);
			todo.setPriority(163);
			MemberPersona creatingMember = new MemberPersona();
			creatingMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
					.getToken().getMemberPersonaId().getStorageID()));
			LOGGER.debug("Member Role Id :" + creatingMember.getMemberRoleId());
			todo.setCreatingMember(creatingMember);
			todo.setForMember(creatingMember);
			try {
				todoService.createTodo(todo);

			} catch (Exception exception) {
				LOGGER.error("Caught Exception. class ="
						+ exception.getClass().getName() + ",message ="
						+ exception.getMessage());
			}

			// update the recommendation status
			// get recommendation by recommendationId
			Recommendation recommend = new Recommendation();
			recommend = recomendationsService
					.getRecommendationByRecommendationId(recommendationId);

			// get ignorecount and increment by one
			int ignoreCount = recommend.getIgnoreCount();
			LOGGER.debug("ignoreCount==>" + ignoreCount);
			ignoreCount = ignoreCount + 1;
			LOGGER.debug("ignoreCount incremented==>" + ignoreCount);

			updatedRow = recomendationsService.updateRecommendationsCategoryById(
					recommendationId, category, ignoreCount);
			LOGGER.debug("updated row==>" + updatedRow);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return updatedRow;

	}

	
	@RequestMapping(value = "/recommendationpopupage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPopupWindow() {

		ModelAndView modelAndView = new ModelAndView("common/zrecommendation");

		return modelAndView;

	}

}