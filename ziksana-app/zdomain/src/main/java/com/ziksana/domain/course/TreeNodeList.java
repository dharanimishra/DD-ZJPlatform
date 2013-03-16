package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TreeNodeList {

	private final static Logger LOGGER = LoggerFactory.getLogger(TreeNodeList.class);

	private List<NestTreeNode> allTreeNodes = null;
	private List<NestContentNode> allContentNodes = null;

	public TreeNodeList(List<NestTreeNode> nodeList,
			List<NestContentNode> contentList) {
		setRawList(nodeList, contentList);
	}

	public void setRawList(List<NestTreeNode> nList, List<NestContentNode> cList) {
		allTreeNodes    = nList;
		allContentNodes = cList;
	}

	public List<NestTreeNode> getFirstLevelNodes() throws Exception {
		// search all the tree nodes in allTreeNodes that have parent set as 0.
		// Returns "null" when there are no first level nodes found, basically
		// the tree is empty.

		int parentNodeId = 0;
		return getChildNodes(parentNodeId);
	}

	public List<NestTreeNode> getChildNodes(int parentNodeId) {
		// search all the tree nodes in allTreeNodes that have parent set as
		// parentNodeId. The method returns "null" when there are no children
		// found for a parent.
		LOGGER.debug("Entering getChildNodes(parentNodeId) : [" + parentNodeId + "]");

		if (allTreeNodes == null) {
			throw new IllegalStateException("Raw List of Nodes is not set");
		}

		List<NestTreeNode> children = null;
		for (NestTreeNode node : allTreeNodes) {
			LOGGER.debug("searching for parent [" + parentNodeId + 
					"] parent Node ID [" + node.getParentLearningComponentId() +
					"] Nest Node ID [" + node.getNestLearningComponentId() + "]");

			if ( parentNodeId == node.getParentLearningComponentId() ) {
				LOGGER.debug("Match found, Parent ID :" + parentNodeId 
					+ " Child ID : "+ node.getNestLearningComponentId());

				if (children == null) {
					children = new ArrayList<NestTreeNode>();
				}

				children.add(node);
			}
		}

		if (children == null) {
			LOGGER.debug("No children found. Debug info : " + this.debugTrace());
		}

		LOGGER.debug("Exiting getChildNodes(parentNodeId)");

		return children;
	}

	public List<NestContentNode> getChildContent(int nodeId) {
		// search all the tree nodes in allContentNodes that have parent set as
		// nodeId. The method returns "null" when there are no contents
		// found for a node.
		LOGGER.debug("Entering getChildContent(nodeId) : " + nodeId);

		if (allContentNodes == null) {
			return null;
		}

		List<NestContentNode> contents = null;
		for (NestContentNode content : allContentNodes) {
			if (nodeId == content.getParentLearningComponentId()) {
				LOGGER.debug(" Class :"
						+ getClass()
						+ ".getChildContent(int nodeId) : Parent ID :"
						+ nodeId + " Child ID: "
						+ content.getContentId());

				if (contents == null) {
					contents = new ArrayList<NestContentNode>();
				}

				contents.add(content);
			}
		}

		LOGGER.debug("Exiting getChildContent(nodeId)");

		return contents;
	}

	public List<NestTreeNode> getTree() throws Exception {
		// Returns a List container containing the whole learning component
		// hierarchy along with contents for a course.
		LOGGER.debug("Entering getTree()");

		List<NestTreeNode> topLevel = null;

		if ((topLevel = getFirstLevelNodes()) == null) {
			throw new Exception("First Level Nodes not found in raw data ["
					+ allTreeNodes + "]");
		}

		try {
			buildRelationship(topLevel);
			LOGGER.debug(" Class :" + getClass()
						+ " Method Name :getTree()"
						+ NestTreeNode.debugTrace(topLevel));

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			LOGGER.error(" Class :" + getClass()
					+ " Method Name :getTree() : Exception2" + e2);
			throw e2;
		}

		LOGGER.debug("Exiting getTree()");

		return topLevel;
	}

	public void buildRelationship(List<NestTreeNode> parents) throws Exception {

		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :buildRelationship(List<NestTreeNode> parents) : "
				+ NestTreeNode.debugTrace(parents));

		if (parents == null) {
			throw new IllegalStateException(
					"buildRelationship() can't be done with null parents");
		}

		for (NestTreeNode aParent : parents) {
			LOGGER.debug("parent id : " + aParent.getNestLearningComponentId());

			List<NestTreeNode> children = getChildNodes(aParent
					.getNestLearningComponentId());

			aParent.setContent(getChildContent(aParent
					.getNestLearningComponentId()));

			if (children == null) {
				// No children, continue to next child.
				LOGGER.debug("No Child found for : " +
						aParent.getNestLearningComponentId());
				continue;
			}

			aParent.setChildren(children);

			buildRelationship(children);
		}

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ ".buildRelationship(List<NestTreeNode> parents)");
	}

	public void getTreeNode(List<NestTreeNode> list) {
		for (NestTreeNode node : list) {
			LOGGER.info("Node :" + node);
			getTreeNode(node.getChildren());

		}
	}

	public String debugTrace() {
		StringBuffer sb = new StringBuffer("%%");

		sb.append("RAWTREE [");
		if (allTreeNodes != null) {
			for (NestTreeNode node : allTreeNodes) {
				sb.append(node.debugTrace());
			}
		} else {
			sb.append("null");
		}

		sb.append("] %% RAWCNT [");
		if (allContentNodes != null) {
			for (NestContentNode node : allContentNodes) {
				sb.append(node.debugTrace());
			}
		} else {
			sb.append("null");
		}

		sb.append("] %% ");
	
		return sb.toString();
	}
}
