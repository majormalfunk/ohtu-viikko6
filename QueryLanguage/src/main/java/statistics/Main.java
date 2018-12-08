package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        
        System.out.println("\n----------- AND ------------\n");
        
        // AND
        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\n----------- ALL ------------\n");
        
        // ALL
        m = new All();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\n----------- NOT ------------\n");
        
        // NOT
        m = new Not(new HasAtLeast(1, "goals")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\n----------- OR -------------\n");
        
        // OR
        m = new Or(new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists"),
                new HasAtLeast(85, "points")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\n------- HAS FEWER THAN------\n");
        
        // HAS FEWER THAN
        m = new HasFewerThan(1, "goals");

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }


    }
}
