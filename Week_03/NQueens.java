import java.util.*;

/**
 * 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> dia1 = new HashSet<>();
        Set<Integer> dia2 = new HashSet<>();
        backtrack(solutions, queues, n, 0, columns, dia1, dia2);
        return solutions;
    }

    private void backtrack(List<List<String>> solutions, int[] queues, int n, int row
            , Set<Integer> columns, Set<Integer> dia1, Set<Integer> dia2) {
        if (row == n) {
            List<String> board = generateBoard(queues, n);
            solutions.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int left = row - i;
            if (dia1.contains(left)) {
                continue;
            }
            int right = row + i;
            if (dia2.contains(right)) {
                continue;
            }
            queues[row] = i;
            columns.add(i);
            dia1.add(left);
            dia2.add(right);
            backtrack(solutions, queues, n, row + 1, columns, dia1, dia2);
            queues[row] = -1;
            columns.remove(i);
            dia1.remove(left);
            dia2.remove(right);
        }
    }

    private List<String> generateBoard(int[] queues, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
