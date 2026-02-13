package src.com.java.code;

public class ShortCurcuitingProgram {
    public static int getIterationDifference(String[][] grid) {
        int totalElements = 4;
        int minIterations = 0;
        long finalProduct = 1;
        int currentIteration = 0;


        khatam://dono loop ko break karegae
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                currentIteration++;
                int currentNum = Integer.parseInt(grid[i][j]);
                finalProduct = finalProduct * currentNum;

                if (grid[i][j].equals("0")) {
                    minIterations = currentIteration;
                    break khatam;
                }
            }
        }
        System.out.println("minIterations: " +minIterations); // Output: 3
        if (minIterations == 0) {
            minIterations = totalElements;
        }

        return Math.abs(totalElements - minIterations);
    }
    public static void main(String[] args) {
        String[][] grid1 = {{"1", "2"}, {"0", "4"}};
        System.out.println("Difference: " + getIterationDifference(grid1)); // Output: 3
    }
}

