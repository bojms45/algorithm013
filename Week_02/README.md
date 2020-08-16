# 总结: 

第二周的任务，把所有的实战和习题都做了一遍，并且在第二天做第二遍，有的甚至做了三遍。 

同样的套路: 

1. 思考5-10分钟

2. 如果有思路，试着去解决，否则看答案

3. 如果在解决过程中，花费太长时间，直接跳过，看答案

4. 看过答案，重新做一遍，如果做不出来，在看答案，之后在重新做一遍，直到可以不用
看答案做出即可，统称第一遍

5. 看过答案的题，第二天会专门复习一遍

6. 分析时间复杂度，空间复杂度，各个方法的优劣处

7. 有一些题用到了DP解法，所以略过

## Hastable
通过Hash Function找出元素的对应值，然后存放在对应的slot中。如果发生哈希碰撞，在对应的slop中形成链表。 最坏的时间复杂度为O(N)， 说明所有元素都存放在同一个slot中，即发生了N-1次哈希碰撞

## HashMap

put: O(1)

get: O(1)

很强大的数据结构，时间速度快，方便操作

## Set

put: O(1)

get: O(1)

建立于哈希表之上，只有一个值 <V>，并非<Key, Value> 结构

## Binary Tree

非线性数据结构

`BST`: left < root < right

搜索方式: `DFS` & `BFS`

`DFS`: 调用Stack， 可以recursion， 可以iteration

三种DFS方式: Preorder, Inorder, Postorder, 查找方式分别为: 根左右，左根右，左右根

需要牢记三种`DFS`的recursion & Iteration的模版， 在做题中，直接套用

`BFS`: 调用Queue， 一般使用Iteration， 层层遍历

## Heap & Binary Tree

Complete Binary Tree: 根大于子 或 根小于子， 可用于实现heap

Heap:  当前节点的子： 2*i+1 & 2*i+2

	   当前节点的父： (i-1)/2

FindMax: O(1)

Insert: O(lgN) or O(1) create

Delete: O(lgN)

## 图： 还在学习中!

