package com.springs.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.springs.domain.JQueryTree;
import com.springs.domain.Enrichment;

public class JSTreeBuilder {

	/*
	 * This method returns JQueryTree object.It builds the tree object based on
	 * the data set.
	 */
	public static JQueryTree getJSTree(List<Enrichment> enrichments) {
		// TODO
		ListIterator<Enrichment> listIterator = enrichments.listIterator();
		Enrichment rootNode = listIterator.next();
		
		
		JQueryTree jstree = new JQueryTree();
		List<JQueryTree> children = new ArrayList<JQueryTree>();
		jstree.setState(JQueryTree.State.OPEN.toString());
		jstree.setChildren(children);
        jstree.setData(jstree.new Data(rootNode.getTitle()));
        populateTree(rootNode, jstree, enrichments);
		return jstree;

	}

	/**
	 * this method builds the object graph from the root node.
	 */
	private static void populateTree(Enrichment enrichment, JQueryTree jstree,List<Enrichment> enrichments ) {

		// TODO
		//List<JQueryTree> children = new ArrayList<JQueryTree>();
		
		
		for (Enrichment enr : enrichments) {
			
			 if (enr != null)
			 {
				 if (enr.getNestparentid().equals(enrichment.getComponentnestid()))
				 {
					 
					 JQueryTree child = new JQueryTree();
					 child.setData(child.new Data(enr.getTitle()));
					 List<JQueryTree> children = new ArrayList<JQueryTree>();
					 child.setChildren(children);
					 //children.add(child);
					 jstree.getChildren().add(child);
					 populateTree(enr,child,enrichments);
					 
					 
				 }
				 
				 
			 }
			
		}
		
		
        //child.setData(child.new Data("Child"));
		//children.add(child);
		
		//jstree.setChildren(children);

	}

}