package com.springs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springs.domain.BookMark;
import com.springs.domain.Enrichment;
import com.springs.domain.FileInfoVO;
import com.springs.domain.FileVO;
import com.springs.domain.JQueryTree;
import com.springs.domain.PlayList;
import com.springs.helper.JSTreeBuilder;
import com.springs.persistence.ComponentTypeMapper;
import com.springs.persistence.EnrichmentMapper;
import com.springs.persistence.FileService;
import com.springs.validators.CustomValidator;

@Controller
@RequestMapping(value = "/*")
public class RegistrationController {

	private FileService fileService = null;
	
	private EnrichmentMapper enrichmentMapper = null;
	
	private ComponentTypeMapper compTypeMapper = null;

	private Random randomGenerator = new Random();

	@Autowired
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	@Autowired
	public void setEnrichmentMapper(EnrichmentMapper enrichmentMapper) {
		this.enrichmentMapper = enrichmentMapper;
	} 

	@Autowired
	public void setCompTypeMapper(ComponentTypeMapper compTypeMapper) {
		this.compTypeMapper = compTypeMapper;
	}


	List<PlayList> playListList = null;
	@RequestMapping(value = "/video.htm", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		System.out.println("starting >>>>>>>>>>>>>>>>>>>>>>");
		List<FileInfoVO> fileObjectList = fileService.getFilesInfo();
		
		playListList = fileService.getPlayList();
		List<String> videoList = new ArrayList<String>();

		for (FileInfoVO file : fileObjectList) {
			videoList.add(file.getFilePath() + file.getFileName());
		}
		model.addAttribute("files", fileObjectList);
		model.addAttribute("playLists", playListList);
		model.addAttribute("videoList", videoList);
		FileVO file = new FileVO();
		
		PlayList playList = new PlayList();
		model.addAttribute("playListForm", playList);
		
		file.setVideoId(randomGenerator.nextInt());
		model.addAttribute("file", file);
		return "video";
	}

	@RequestMapping(value = "/video.htm", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value = "file") FileVO file,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("video");
		if (!result.hasErrors()) {
			fileService.saveFile(file);
			mv.addObject("file", file);
		}
		return mv;
	}

	@RequestMapping(value = "/video.htm", method = RequestMethod.GET, params = "name")
	public @ResponseBody
	List<FileVO> getFileData(@RequestParam String name) {
		List<FileVO> fileObjectList = fileService.getFileNotesList(name);
		return fileObjectList;
	}

	@RequestMapping(value = "/video.htm", method = RequestMethod.POST, params = "update")
	public ModelAndView update(@ModelAttribute(value = "file") FileVO file,
			@RequestParam String videoId) {
		ModelAndView mv = new ModelAndView("video");
		System.out.println("video id in updatefile info : "+videoId);
		file.setVideoId(Integer.parseInt(videoId));
		fileService.updateFileInfo(file);
		mv.addObject("file", file);
		return mv;
	}

	@RequestMapping(value = "/video.htm", method = RequestMethod.POST, params = "playlist")
	public ModelAndView insertPlayList(
			@ModelAttribute(value = "playList") PlayList playList) {
		ModelAndView mv = new ModelAndView("video");
		List<PlayList> listItem = fileService.findPlayList(playList
				.getFileName());
		//List<PlayList>  playLists = null;
		if (listItem.size() == 0) {
			fileService.addPlayList(playList);
			
			  //playLists = fileService.getPlayList();
			
			mv.addObject("playList", playList);
			//mv.addObject("playLists", playLists);
		}
		return mv;

	}

	@RequestMapping(value = "/video.htm", method = RequestMethod.GET, params = "displayList")
	public @ResponseBody
	List<PlayList> getPlayList(@RequestParam String displayList) {
		List<PlayList> filePlayList = fileService.getPlayList();
		return filePlayList;
	} 

	@RequestMapping(value = "/video.htm", method = RequestMethod.POST, params = "bookmark")
	public ModelAndView addBookMark(
			@ModelAttribute(value = "bookmark") BookMark bookMark) {
		ModelAndView mv = new ModelAndView("video");
		fileService.addBookMark(bookMark);
		mv.addObject("bookmark", bookMark);
		mv.addObject("file", new FileVO());
		return mv;
	}
	
	@RequestMapping(value = "/video.htm", method = RequestMethod.GET, params = {"bookamrklist", "videoName"})
	public @ResponseBody List<BookMark> getBookMark(@RequestParam String bookamrklist, @RequestParam String videoName) {
			List<BookMark> bookMarkList = fileService.getBookMarkList(videoName);
			return bookMarkList;
	}
	
	
	@RequestMapping(value = "/video.htm", method = RequestMethod.POST, params = "deleteNote")
	public ModelAndView deleteNotes(@ModelAttribute(value = "file") FileVO file,
			@RequestParam String videoId) {
		ModelAndView mv = new ModelAndView("video");
		
		System.out.println("inside deleteNotes controller method  :");
		System.out.println("videoId :"+videoId+" :time : "+file.getTime());

		file.setVideoId(Integer.parseInt(videoId));
		fileService.deleteNotes(file);
		System.out.println("deleted note successfully");
		mv.addObject("file", file);
		return mv;
	}
	
	@RequestMapping(value = "/video.htm", method = RequestMethod.POST, params = "deleteBookmark")
	public ModelAndView deleteBookmark(@ModelAttribute(value = "bookmark") BookMark bookMark,
			@RequestParam String videoId) {
		ModelAndView mv = new ModelAndView("video");
		
		System.out.println("inside deleteBookmark controller method  :");
		
		Integer videoIdval = fileService.getVideoIdByName(bookMark.getVideoName());
		
		System.out.println("Got the video id from name : "+videoIdval);
		
		System.out.println("videoId :"+videoIdval+" :VideoName : "+bookMark.getVideoName());

		bookMark.setVideoId(videoIdval);
		
		fileService.deleteBookmark(bookMark);
		
		System.out.println("deleted bookmark successfully");
		
		mv.addObject("bookmark", bookMark);
		
		return mv;
	}


	@RequestMapping(value = "/video.htm", method = RequestMethod.GET, params = {"enrichList","videoName"})
	public @ResponseBody
	List<Enrichment> getEnrichmentList(@RequestParam String enrichList, @RequestParam String videoName) {
		
		List<Enrichment> enrichmentList = new ArrayList<Enrichment>();
		System.out.println("inside getEnrichmentList method in controller");
		
		Integer videoId = fileService.getVideoIdByName(videoName);
		
		System.out.println("Got the video id from name : "+videoId);
		List<Enrichment> enrichments = enrichmentMapper.getEnrichmentList(videoId);
		
		System.out.println("list size : "+enrichments.size());

		for (Enrichment enrichment : enrichments) {
			
			Integer compTypeId = enrichment.getComponenttypeid();
			
			String compTypeName = getCompTypeById(compTypeId);
	
			System.out.println("Start Time : "+enrichment.getStarttime()+" End Time : "+enrichment.getEndtime());
			
			System.out.println("comptype name from id("+compTypeId+") : "+compTypeName);
			
			enrichment.setComponetType(compTypeName);

			enrichmentList.add(enrichment);
		}
		
		System.out.println("listenrichmentList size : "+enrichmentList.size());
		
		return enrichmentList;
	}
	
	
	@RequestMapping(value = "/video.htm", method = RequestMethod.GET, params = {"enrichItem","videoid","starttime"})
	public @ResponseBody List<Enrichment> getEnrichment(@RequestParam String enrichItem, @RequestParam String videoid, @RequestParam String starttime) {
		
		System.out.println("*****inside getEnrichment method in controller (videoid :"+videoid+");   (start time : "+starttime+")");

		List<Enrichment> enrichmentList = new ArrayList<Enrichment>();
		
		enrichmentList = enrichmentMapper.getEnrichment(Integer.parseInt(videoid),starttime);
		
		if(enrichmentList!=null && enrichmentList.size()>0){
			
			for (Enrichment enrichment : enrichmentList) {
				
				System.out.println("not null");
				
				Integer compTypeId = enrichment.getComponenttypeid();
				
				String compTypeName = getCompTypeById(compTypeId);
			
				System.out.println("**** enrich comp type name from id("+compTypeId+") : "+compTypeName);
					
				enrichment.setComponetType(compTypeName);

			}

		}else{
			System.out.println("null");
		}
		
		return enrichmentList;
	}
	
	@RequestMapping(value = "/video.htm", method = RequestMethod.POST, params = "postEnrich")
	public ModelAndView addEnrichNote(
			@ModelAttribute(value = "enrichment") Enrichment enrichment) {
		System.out.println("inside controller addEnrichNote method");
		
		Integer compTypeId;
		
		ModelAndView mv = new ModelAndView("video");
		
		System.out.println("description as a video name :"+enrichment.getDescription());
		
		Integer videoId = fileService.getVideoIdByName(enrichment.getVideoName());
		
		if(videoId!=null){
			System.out.println("videoId : "+videoId);
			enrichment.setVideoid(videoId);
		}
		System.out.println("enrichment.getComponetType() : "+enrichment.getComponetType());
		compTypeId = compTypeMapper.getCompTypeByName(enrichment.getComponetType());
		
		System.out.println("comp type id{"+enrichment.getComponetType()+"} from name : "+compTypeId);
		
		if(!compTypeId.equals(0) || compTypeId!=0){
			
			enrichment.setComponenttypeid(compTypeId);
			
			enrichmentMapper.insert(enrichment);

		}else{
			//validator.validate(enrichment,compTypeId);
			System.out.println("wrong comp type name");
		}
		
		
		mv.addObject("enrichment", enrichment);
		
		return mv;
	}



	private String getCompTypeById(Integer compTypeId){
		String compTypeName = null;
		
		compTypeName =  compTypeMapper.getCompTypeById(compTypeId);
		
		return compTypeName;
	}

	
	@RequestMapping(value = "/video.htm", method = RequestMethod.GET, params = "displayTree")
	public @ResponseBody
	JQueryTree getTree(@RequestParam String displayTree) {
		List<Enrichment> enrichmentList = new ArrayList<Enrichment>();
		System.out.println("inside getTree method in controller");
		System.out.println("display tree value is "+displayTree);
		//System.out.println("Got the video id from name : "+videoId);
		
		List<Enrichment> enrichments = enrichmentMapper.getTree();
		
		System.out.println(" SIZE OF THE ENRICHMENT LIST IS "+enrichments.size());
		
		for (Enrichment enrichment : enrichments) {
			
			Integer compTypeId = enrichment.getComponenttypeid();
			
			String compTypeName = getCompTypeById(compTypeId);
	
			System.out.println("Start Time : "+enrichment.getStarttime()+" End Time : "+enrichment.getEndtime());
			
			System.out.println("comptype name from id("+compTypeId+") : "+compTypeName);
			
			enrichment.setComponetType(compTypeName);
			
			enrichmentList.add(enrichment);
		}
		
		
		
		return JSTreeBuilder.getJSTree(enrichmentList);
		
	}
	
	
}