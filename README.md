# WordSearchOptimizer
Optimized Java solution for word puzzles using hash tables to reduce time complexity from O(R×C×W) to O(R×C+W).

**Note:** This project was created for educational purposes and personal learning.

This project implements an efficient word puzzle solver in Java.  
It uses hash-based data structures (HashSet) to reduce the time complexity of searching for words in a grid.  

The algorithm scans all possible directions from each cell in the grid and checks accumulated strings against the word list in constant average time, providing a fast and scalable solution.