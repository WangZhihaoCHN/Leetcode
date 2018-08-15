# 数据研发岗面试问题整理
## Java相关
1. JAVA中List、Map、Set的区别与选用<br>
参考: [JAVA中List、Map、Set的区别与选用 - CSDN博客](https://blog.csdn.net/ABBuggy/article/details/7720666)
2. HashMap


## 数据库相关

## Hadoop相关
1. MapReduce执行过程<br>
参考: [Hadoop Map/Reduce执行流程详解 - Jamzy Wang](http://zheming.wang/blog/2015/05/19/3AFF5BE8-593C-4F76-A72A-6A40FB140D4D/)
![hadoop_map_reduce.PNG](http://7xjuf4.com1.z0.glb.clouddn.com/hadoop_map_reduce.PNG)
InputFormat -> InputSplit -> map() -> partition -> sort(框架自动进行) -> combine -> shuffle -> copy -> merge -> reduce