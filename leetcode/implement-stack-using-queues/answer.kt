class MyStack(
    val queue: Queue<Int> = LinkedList(),
) {

    fun push(x: Int) {
        queue.add(x)
        for(i in 1..<queue.size) {
            queue.add(queue.poll())
        }
    }

    fun pop(): Int {
        return queue.poll()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */