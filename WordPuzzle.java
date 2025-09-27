import java.util.*;

//O(R × C + W) istället för O(R × C × W)
public class WordPuzzle {
    private static final int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    private static final int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    /*
     * Söker efter alla ord genom att kolla varje startpunkt
     * (rad, kolumn) och undersöka alla 8 riktningar för möjliga ord.
     * 
     * 
     * @param grid 2D-array av tecken som representerar rutnätet
     * @param wordSet Set av ord som vi söker efter 
     */
    public static void searchWords(char[][] grid, Set<String> wordSet) {
        int rows = grid.length;
        int cols = grid[0].length;

        /*Den här raden hämtar antalet kolumner i grid-arrayen. grid[0] refererar till den första raden i rutnätet, och grid[0].
        length ger antalet element i den raden, vilket motsvarar antalet kolumner. */

        Map<String, List<String>> foundWords = new HashMap<>();

        //O(r*c)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int d = 0; d < 8; d++) {
                    findWord(grid, wordSet, r, c, dx[d], dy[d], foundWords);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : foundWords.entrySet()) {
            String word = entry.getKey();
            for (String position : entry.getValue()) {
                System.out.printf("Hittade ord \"%s\": \nordet börjar från %s%n", word, position);
            }
        }
    }

    /**
     * Söker efter ett ord från en given startposition i en specifik riktning.
     * 
     * @param grid 2D-array av tecken som representerar rutnätet
     * @param wordSet Set av ord som vi söker efter
     * @param row Startpositionens rad
     * @param col Startpositionens kolumn
     * @param dx Riktningens förändring i x-led
     * @param dy Riktningens förändring i y-led
     * @param foundWords En HashMap för att lagra de funna orden och deras positioner
     */
    private static void findWord(char[][] grid, Set<String> wordSet, int row, int col, int dx, int dy, Map<String, List<String>> foundWords) {
        StringBuilder word = new StringBuilder();
        int rows = grid.length, cols = grid[0].length;
        int x = row, y = col;
//O(w)
        while (x >= 0 && y >= 0 && x < rows && y < cols) {
            word.append(grid[x][y]);

            if (wordSet.contains(word.toString())) {
                String wordFound = word.toString();
                String position = String.format("från (%d, %d) till (%d, %d)", row, col, x, y);

                foundWords.putIfAbsent(wordFound, new ArrayList<>());
                foundWords.get(wordFound).add(position);
            }
            x += dx;
            y += dy;
        }
    }


    public static void main(String[] args) {
        char[][] grid = {
            {'t', 'h', 'i', 's'},
            {'w', 'a', 't', 's'},
            {'o', 'a', 'h', 'g'},
            {'f', 'g', 'd', 't'}
        };

 // eftersom uppslagningar i en hash tabell tar i genomsnitt en konstat tidkomplexitet-.
        Set<String> wordSet = new HashSet<>(Arrays.asList("this", "two", "fat", "that"));  //inga dubletter
        searchWords(grid, wordSet);
    }
     

}
