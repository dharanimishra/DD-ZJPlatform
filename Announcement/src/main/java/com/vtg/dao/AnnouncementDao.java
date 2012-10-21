/**
 * 
 */
package com.vtg.dao;

import java.util.Collection;

import com.vtg.model.Announcement;

/**
 * @author
 * 
 */
public interface AnnouncementDao {

	public Collection<Announcement> selectAll();

	public Announcement selectById(int id);

	public void update(Announcement announcement) throws Exception;

	public void delete(int announcementId) throws Exception;

	public void insert(Announcement announcement);

}
