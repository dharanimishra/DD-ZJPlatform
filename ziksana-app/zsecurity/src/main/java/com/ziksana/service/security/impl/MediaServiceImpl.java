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
	
	@Value("#{myProperties['flashrecordingscript']}")
	private String flashRecordingScript;
	
	@Value("#{myProperties['CONTENT_SERVER']}")
	private String CONTENT_SERVER;
	
	@Value("#{myProperties['CONTENT_SERVER_PORT']}")
	private String CONTENT_SERVER_PORT;
	
	@Value("#{myProperties['CONTENT_SERVER_PROTOCOL']}")
	private String CONTENT_SERVER_PROTOCOL;

	@Value("#{myProperties['staticFileServer']}")
	private String staticFileServer;

	@Value("#{myProperties['treeImagePath']}")
	private String treeImagePath;
	
	@Value("#{myProperties['staticResources']}")
	private String staticResources;

	public MediaServerURL getMediaContents() {
		MediaServerURL media = new MediaServerURL();
			
		media.setUrl(url);
		media.setUploadScript(uploadScript);
		media.setUploadContent(uploadContent);
		media.setFlashRecordingScript(flashRecordingScript);
		//media.setFlashRecordingFolder(flashRecordingFolder);
		media.setStaticFileServer(staticFileServer);
		media.setTreeImagePath(treeImagePath);
		media.setStaticResources(staticResources);
		return media;
	}

}
