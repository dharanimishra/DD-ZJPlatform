package com.ziksana.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.service.security.MediaService;

@Controller
public class MediaController {
	
	@Autowired
	MediaService mediaService;

	@RequestMapping(value = "/getmediacontents", method = RequestMethod.GET)
	public @ResponseBody MediaServerURL  getMediaServerContents(){
		
		return  mediaService.getMediaContents();
	}
}
