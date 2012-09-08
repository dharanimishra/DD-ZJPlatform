package com.springs.persistence;

import java.util.List;

import com.springs.domain.BookMark;
import com.springs.domain.FileInfoVO;
import com.springs.domain.FileVO;
import com.springs.domain.PlayList;

public interface FileService {
	public void saveFile(FileVO file);
	public List<FileInfoVO> getFilesInfo();
	public List<FileVO> getFileNotesList(String name);
	public void updateFileInfo(FileVO file);
	public void addPlayList(PlayList playlist);
	public List<PlayList> getPlayList();
	public List<PlayList> findPlayList(String fileName);
	public void addBookMark(BookMark bookMark);
	public List<BookMark> getBookMarkList(String videoName);
	public void deleteNotes(FileVO file);
	public void deleteBookmark(BookMark bookMark);
	public Integer getVideoIdByName(String name); 
}
