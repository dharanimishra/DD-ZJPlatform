/**
 * 
 */
package com.ziksana.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.Header;
import com.ziksana.domain.common.ZiksanaMessage;
import com.ziksana.domain.recommendations.Recommendation;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.recommendations.RecommendationsService;

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
		ModelAndView modelAndView = new ModelAndView("xml/zrecommendationsnew");

		List<Recommendation> recommendations = recomendationsService
				.getRecommendations(category);

		

		
		// Creating ziksana message header
		Header header = new Header();

		String token = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID().toString();

		logger.info("Current Token" + token);

		// Setting the controller and token
		header.setControllerName(getClass().getSimpleName().toUpperCase());
		header.setToken(token);
        
		// Creating ziksana message
		ZiksanaMessage<Recommendation> message = new ZiksanaMessage<Recommendation>();

		message.setContent(recommendations);
		message.setHeader(header);
		modelAndView.addObject("recommendations", message);
		logger.info("Exit Recommend By category");

		return modelAndView;
	}

}