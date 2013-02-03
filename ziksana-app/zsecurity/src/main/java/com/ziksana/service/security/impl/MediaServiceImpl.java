package com.ziksana.service.security.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.service.security.MediaService;

@Service
public class MediaServiceImpl implements MediaService{
	
	@Value("#{myProperties['url']}")
	private String url;

	@Value("#{myProperties['uploadscript']}")
	private String uploadScript;

	@Value("#{myProperties['uploadcontent']}")
	private String uploadContent;

	@Override
	public MediaServerURL getMediaContents() {
		MediaServerURL media = new MediaServerURL();
			
		media.setUrl(url);
		media.setUploadScript(uploadScript);
		media.setUploadContent(uploadContent);
		
		return media;
	}

}
