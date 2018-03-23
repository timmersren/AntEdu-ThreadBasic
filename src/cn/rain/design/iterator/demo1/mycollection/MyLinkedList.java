package cn.rain.design.iterator.demo1.mycollection;

import cn.rain.design.iterator.demo1.model.Node;

/**
 * description: 简单模拟LinkedList的实现
 * @author 任伟
 * @date Mar 24, 2018
 */
public class MyLinkedList implements MyCollection{
	Node headNode = null;
	Node tailNode = null;
	private int size = 0;
	
	@Override
	public void add(Object object) {
		// 每次添加一个元素都新建一个Node节点
		Node node = new Node(object, null);
		if (headNode == null) { //如果head为null，说明object是加进来的第一个元素
			headNode = node;
			tailNode = node; //此时头节点和尾节点应该是同一个节点（即node）
		}
		// 所有加进来的object都保存在一个个node里了
		tailNode.setNode(node); 
		// 并且tailNode永远指向最新加进来的那个node
		tailNode = node;
		size ++;
	}
	
	@Override
	public int size() {
		return size;
	}
	
}
