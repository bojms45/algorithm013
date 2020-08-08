/* addFirst */
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");

System.out.println(deque);
System.out.println(deque.getFirst());
System.out.println(deque);

while(deque.size() > 0)
	System.out.println(deque.removeFirst());

System.out.println(deque);

/* addLast */
deque.addLast("c");
deque.addLast("b");
deque.addLast("a");

System.out.println(deque);
System.out.println(deque.getFirst());
System.out.println(deque);

while(deque.size() > 0)
	System.out.println(deque.removeFirst());

System.out.println(deque);