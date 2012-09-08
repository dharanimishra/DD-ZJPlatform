/**
 * 
 */
package com.springs.domain;

/**
 * @author prabu
 *
 */
import java.util.List;
import java.util.Map;

public class JQueryTree {

	/**
	 * set attributes to data object, such as `href` of anchor.
	 */
	private Data data;

	/**
	 * omit `attr` if not needed; the `attr` object gets passed to the jQuery
	 * `attr` function
	 */
	private Map<String, String> attr;

	/**
	 * "closed", or "open", defaults to "closed"
	 */
	private String state;

	/**
	 * `state` and `children` are only used for NON-leaf nodes
	 */
	private List<JQueryTree> children;

	/**
	 * the `metadata` property will be saved using the jQuery `data` function on
	 * the `li` node
	 */
	private String metadata;

	/**
	 * If this option is set to true if an AJAX returns an empty result, the
	 * node that was about to be opened will be converted to a leaf node (the
	 * open icon will no longer be displayed).
	 */
	private boolean correct_state = true;

	/**
	 * If this option is set to true only the visible (open nodes) parts of the
	 * returned JSON are converted to DOM nodes, any hidden parts are saved away
	 * and parsed ondemand (when a node becomes visible). This is useful when
	 * you have a large nested tree which would result in a heavy DOM.
	 */
	private boolean progressive_render = true;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	/**
	 * @param title
	 *            
	 * @param attr
	 *           
	 * @param icon
	 *           
	 */
	public void setData(String title, Map<String, String> attr, String icon) {
		this.data = this.new Data(title, attr, icon);
	}

	public void setData(String title, Map<String, String> attr) {
		this.data = this.new Data(title, attr);
	}

	public void setData(String title) {
		this.data = this.new Data(title);
	}

	public Map<String, String> getAttr() {
		return attr;
	}

	public void setAttr(Map<String, String> attr) {
		this.attr = attr;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<JQueryTree> getChildren() {
		return children;
	}

	public void setChildren(List<JQueryTree> children) {
		this.children = children;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public void setProgressiveRender(boolean progressiveRender) {
		this.progressive_render = progressiveRender;
	}

	public boolean isProgressiveRender() {
		return progressive_render;
	}

	public void setCorrectState(boolean correctState) {
		this.correct_state = correctState;
	}

	public boolean isCorrectState() {
		return correct_state;
	}

	public static enum State {

		OPEN("open"), CLOSED("closed");

		private final String status;

		State(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return status;
		}
	}

	public class Data {
		private String title;

		/**
		 * omit when not needed
		 */
		private Map<String, String> attr;

		/**
		 * if `icon` contains a slash <code>/</code> it is treated as a file,
		 * used for background otherwise - it is added as a class to the <ins>
		 * node
		 */
		private String icon;

		public Data(String title) {
			this.title = title;
		}

		public Data(String title, Map<String, String> attr) {
			this.title = title;
			this.attr = attr;
		}

		public Data(String title, Map<String, String> attr, String icon) {
			this.title = title;
			this.attr = attr;
			this.icon = icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getIcon() {
			return icon;
		}

		public void setAttr(Map<String, String> attr) {
			this.attr = attr;
		}

		public Map<String, String> getAttr() {
			return attr;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}
	}

}