package cn.rain.design.iterator.demo1.model;

/**
 * description: LinkedList中的节点
 * @author 任伟
 * @date Mar 24, 2018
 */
public class Node {
	
	private Object obj;
	private Node node;
	
	public Node(Object obj, Node node) {
		super();
		this.obj = obj;
		this.node = node;
	}
	
	public Object getObj() {
		return obj;
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public Node getNode() {
		return node;
	}
	
	public void setNode(Node node) {
		this.node = node;
	}
	
	@Override
	public String toString() {
		return "Node [obj=" + obj + ", node=" + node + "]";
	}
}
