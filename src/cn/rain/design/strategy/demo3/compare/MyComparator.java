package cn.rain.design.strategy.demo3.compare;

/**
 * description: 在demo2中，我们已经让实现了Comparable接口的具有了可比较性，
 * 但是这种方法扩展性还是不高，由于实现了Comparable接口的类要在内部写死比较大小的逻辑。
 * 就拿ComparableCat这个类来说，它内部的比较逻辑是根据height进行比较，如果现在需要
 * 通过weight来比较呢？难道我们要新建一个类然后其它地方都不变，只对compareTo方法进行重写吗？
 * 这样做显然是不对的。
 * 因此这里我们定义一个Comparator接口，让实现了Comparable接口的类通过传入不同的比较器来实现不同的比较逻辑。
 * @author 任伟
 * @date Mar 24, 2018
 */
public interface MyComparator {

	int compare(Object o1, Object o2);
}
