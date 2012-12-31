/**
 * 
 */
package com.ziksana.controller;

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

import com.ziksana.domain.common.Header;
import com.ziksana.domain.common.ZiksanaMessage;
import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.recommendations.RecommendationsService;
import static com.ziksana.util.Util.*;

/**
 * @author vtg-p13
 * 
 * @version $Revision: 1.0 $
 */
@Controller
@RequestMapping("/secure")
public class RecommendationsController {
	private static final Logger logger = LoggerFactory
			.getLogger(RecommendationsController.class);

	@Autowired
	RecommendationsService recomendationsService;

	/**
	 * 
	 * @param category
	 *            category of the recommendations(Possible values are )
	 * @return
	 */
	@RequestMapping(value = "/showrecByCateg/{category}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showRecommendationsByCategory(@PathVariable Integer category) {

		logger.info("Category Id: " + category);
		ModelAndView modelAndView = new ModelAndView("xml/zrecommendations");

		List<Recommendation> recommendations = recomendationsService
				.getRecommendations(category);

				
        
		// Creating ziksana message
		ZiksanaMessage<Recommendation> message = new ZiksanaMessage<Recommendation>();

		message.setContent(recommendations);
		message.setHeader(getHeader(getClass().getSimpleName().toUpperCase()));
		
		modelAndView.addObject("recommendations", recommendations);
		logger.info("Exit Recommend By category");

		return modelAndView;
	}
	
	@RequestMapping(value = "/getallrecomendations", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getRecommendationsAllRecommendations() {

		logger.info("All recommem]ndations: ");
		ModelAndView modelAndView = new ModelAndView("xml/zrecommendations");

		List<Recommendation> recommendations = recomendationsService.getAllRecommendations();

			
		modelAndView.addObject("recommendations", recommendations);
		logger.info("Exit Recommend");

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/getmapperrecomendations", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getRecommendations() {

		logger.info("All recommem]ndations: ");
		ModelAndView modelAndView = new ModelAndView("xml/zrecommendations");

		List<Recommendation> recommendations = recomendationsService.getMapperRecommendation();

			
		modelAndView.addObject("recommendations", recommendations);
		logger.info("Exit Recommend");

		return modelAndView;
	}
	
	@RequestMapping(value = "/updaterecommendation", method = RequestMethod.POST)
	public String updateRecommendationCategory(
			@RequestParam(value = "recommendationId", required = true) Integer recommendationId,
			@RequestParam(value = "category", required = true) Integer category){
		
		recomendationsService.updateRecommendationsCategoryById(recommendationId, category);
		
		return "Recommendation Updated Successfully";
			
}
	
	
	/*Get popup Alert window
	 * */	
	@RequestMapping(value = "/zrecommendpopup", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
	
		ModelAndView modelAndView = new ModelAndView("common/zrecommendation");
		
		return modelAndView;
		
	}
	
	
	 

}