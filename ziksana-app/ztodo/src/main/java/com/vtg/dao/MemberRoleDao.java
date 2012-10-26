/**
 * 
 */
package com.vtg.dao;

import java.util.Collection;

import com.vtg.model.MemberRole;

/**
 * @author
 * 
 */
public interface MemberRoleDao {

	public Collection<MemberRole> selectAll();

	public MemberRole selectById(int id);

	public void update(MemberRole memberrole) throws Exception;

	public void delete(int id) throws Exception;

	public void insert(MemberRole memberrole);

}
