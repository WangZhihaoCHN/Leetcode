# 数据研发岗面试问题整理
## Java相关
1. JAVA中List、Map、Set的区别与选用<br>
参考: [JAVA中List、Map、Set的区别与选用 - CSDN博客](https://blog.csdn.net/ABBuggy/article/details/7720666)

2. HashMap<br>
参考: [Java HashMap工作原理及实现 | Yikun](https://yikun.github.io/2015/04/01/Java-HashMap工作原理及实现/)
HashMap和HashTable实现原理类似(拉链法)，链表过长会转换为红黑树。

3. HashMap与HashTable的区别<br>
参考: [【Java】HashMap 和 HashTable 的区别到底是什么？ - CSDN博客](https://blog.csdn.net/u010983881/article/details/49762595)

4. ConcurrentHashMap<br>
参考: [ConcurrentHashMap演进从Java7到Java8 | 技术世界 | java,concurrenthashmap,java 8,CAS,多线程,并发,技术世界,郭俊 Jason,大数据架构](http://www.jasongj.com/java/concurrenthashmap/)

5. 各种锁<br>
参考: 
[Java中的锁分类 - byhieg - 博客园](https://www.cnblogs.com/qifengshi/p/6831055.html)
[java 中的锁 -- 偏向锁、轻量级锁、自旋锁、重量级锁 - 简书](https://www.jianshu.com/p/78cf35f01b2f)

## 操作系统相关
1. 进程间的通信方式<br>

2. 进程与线程的区别<br>
参考: [进程间的几种通信方式的比较和线程间的几种通信方式 - CSDN博客](https://blog.csdn.net/yang_teng_/article/details/53325280)

## 数据库相关

## Hadoop相关
1. MapReduce执行过程<br>
参考: [Hadoop Map/Reduce执行流程详解 - Jamzy Wang]
执行步骤: InputFormat -> InputSplit -> map() -> partition -> sort(框架默认行为) -> combine -> shuffle -> copy -> merge -> reduce
(http://zheming.wang/blog/2015/05/19/3AFF5BE8-593C-4F76-A72A-6A40FB140D4D/)
![hadoop_map_reduce.PNG](http://7xjuf4.com1.z0.glb.clouddn.com/hadoop_map_reduce.PNG)