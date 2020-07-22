# well-known-problems
My solutions to some well-known programming problems
---

### Best Conceivable Runtime (BCR)
1. This is the lower bound of any algorithmic problem
2. For a problem, no algorithm can do better than BCR.

### Common optimizing techniques -
1. BUD
    - Remove Bottlenecks
    - Remove Unnecessary work
    - Remove Duplicated work

2. DIY
    - Use intuition and real-world examples to solve the problem intuitively.

3. Simplification & Generalization
    - Simplify the problem into a small problem

4. Base case & build
    - Start from a small example, say with n = 1 & then go all the way up until a pattern is observed
    - Example should not be a special case, be too small or be too big to dry run

5. Data Structure Brainstorm
    - Apply common data structures to the problem - Array, LL, BTree, Heap, etc.
    
### Common Problem-solving techniques
1. Use "Greedy" when -
    1. There is a solution `S` to a problem `P`, such that `S` is derived by making an optimal choice using some parameter.
        1. Example, to maximize profit, we pick best-quality apples with high selling price first
        2. This usually involves using Sorting, Priority Queues, etc. Basically any DS/Algorithm that can "order" the problem in hand.
    2. Solution `S` can be applied repeatedly to problem `P` until it is completely solved.
        1. Example, keep on picking best-quality apples with high selling price, until you run out stock. Only then, start picking apples of medium quality.

2. Divide & Conquer
    