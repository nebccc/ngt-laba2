import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Result {
        int totalDrinks;
        int iterations;
        List<String> steps;

        public Result(int totalDrinks, int iterations, List<String> steps) {
            this.totalDrinks = totalDrinks;
            this.iterations = iterations;
            this.steps = steps;
        }
    }

    static Result calculateDrinks(int n, int m) {
        int totalDrinks = n;       
        int iterations = 0;        
        int emptyBottles = n;      

        
        List<String> steps = new ArrayList<>();

        while (emptyBottles > 1) {
            
            int newFull = emptyBottles / m;
            if (newFull == 0) {
                break;
            }
            
            totalDrinks += newFull;
            
            iterations++;
            
            emptyBottles = emptyBottles % m + newFull;
            
            steps.add("Step " + iterations + " - Drank " + newFull +
                    " of cans left " + emptyBottles + " empty cans");
        }

        return new Result(totalDrinks, iterations, steps);
    }

    public static void main(String[] args) {
        int n = 15;
        int m = 4;

        Result result = calculateDrinks(n, m);
        int totalDrinks = result.totalDrinks;
        int iterations = result.iterations;
        List<String> steps = result.steps;

        System.out.println("Maximum number of cans drunk: " + totalDrinks);
        System.out.println("Number of iterations: " + iterations);
        for (String step : steps) {
            System.out.println(step);
        }
    }
}
