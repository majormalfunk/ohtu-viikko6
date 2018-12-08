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

        printPlayers(m, stats);

        /*
        System.out.println("\n----------- ALL ------------\n");
        
        // ALL
        m = new All();

        printPlayers(m, stats);
        */

        System.out.println("\n----------- NOT ------------\n");
        
        // NOT
        m = new Not(new HasAtLeast(1, "goals")
        );

        printPlayers(m, stats);

        System.out.println("\n----------- OR -------------\n");
        
        // OR
        m = new Or(new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists"),
                new HasAtLeast(85, "points")
        );

        printPlayers(m, stats);

        System.out.println("\n------- HAS FEWER THAN -----\n");
        
        // HAS FEWER THAN
        m = new HasFewerThan(1, "goals");

        printPlayers(m, stats);

        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("------- QUERY BUILDER ------");
        System.out.println("----------------------------");

        /*
        System.out.println("\n-------- ALL PLAYERS -------\n");
        
        // ALL PLAYERS
        QueryBuilder query = new QueryBuilder();
        m = query.build();

        printPlayers(m, stats);
        */
        
        System.out.println("\n-------- PLAYS IN -------\n");
        
        // PLAYS IN
        
        QueryBuilder query = new QueryBuilder();
        m = query.playsIn("NYR").build();

        printPlayers(m, stats);

        System.out.println("\n-------- PLAYS IN, HAS AT LEAST, HAS FEWER THAN -------\n");
        
        // PLAYS IN, HAS AT LEAST, HAS FEWER THAN
        
        query = new QueryBuilder();
        m = query.playsIn("NYR").hasAtLeast(10, "goals").hasFewerThan(25, "goals").build();

        printPlayers(m, stats);

    }
    
    private static void printPlayers(Matcher m, Statistics stats) {
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
    
}
