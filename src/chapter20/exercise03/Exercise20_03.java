package chapter20.exercise03;

import util.Pair;

import java.util.*;

public class Exercise20_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        List<Pair<String, String>> states = new ArrayList<>();

        states.add(new Pair<>("Alabama", "Montgomery"));
        states.add(new Pair<>("Alaska", "Juneau"));
        states.add(new Pair<>("Arizona", "Phoenix"));
        states.add(new Pair<>("Arkansas", "Little Rock"));
        states.add(new Pair<>("California", "Sacramento"));
        states.add(new Pair<>("Colorado", "Denver"));
        states.add(new Pair<>("Connecticut", "Hartford"));
        states.add(new Pair<>("Delaware", "Dover"));
        states.add(new Pair<>("Florida", "Tallahassee"));
        states.add(new Pair<>("Georgia", "Atlanta"));
        states.add(new Pair<>("Hawaii", "Honolulu"));
        states.add(new Pair<>("Idaho", "Boise"));
        states.add(new Pair<>("Illinois", "Springfield"));
        states.add(new Pair<>("Indiana", "Indianapolis"));
        states.add(new Pair<>("Iowa", "Des Moines"));
        states.add(new Pair<>("Kansas", "Topeka"));
        states.add(new Pair<>("Kentucky", "Frankfort"));
        states.add(new Pair<>("Louisiana", "Baton Rouge"));
        states.add(new Pair<>("Maine", "Augusta"));
        states.add(new Pair<>("Maryland", "Annapolis"));
        states.add(new Pair<>("Massachusetts", "Boston"));
        states.add(new Pair<>("Michigan", "Lansing"));
        states.add(new Pair<>("Minnesota", "St. Paul"));
        states.add(new Pair<>("Mississippi", "Jackson"));
        states.add(new Pair<>("Missouri", "Jefferson City"));
        states.add(new Pair<>("Montana", "Helena"));
        states.add(new Pair<>("Nebraska", "Lincoln"));
        states.add(new Pair<>("Nevada", "Carson City"));
        states.add(new Pair<>("New Hampshire", "Concord"));
        states.add(new Pair<>("New Jersey", "Trenton"));
        states.add(new Pair<>("New Mexico", "Santa Fe"));
        states.add(new Pair<>("New York", "Albany"));
        states.add(new Pair<>("North Carolina", "Raleigh"));
        states.add(new Pair<>("North Dakota", "Bismarck"));
        states.add(new Pair<>("Ohio", "Columbus"));
        states.add(new Pair<>("Oklahoma", "Oklahoma City"));
        states.add(new Pair<>("Oregon", "Salem"));
        states.add(new Pair<>("Pennsylvania", "Harrisburg"));
        states.add(new Pair<>("Rhode Island", "Providence"));
        states.add(new Pair<>("South Carolina", "Columbia"));
        states.add(new Pair<>("South Dakota", "Pierre"));
        states.add(new Pair<>("Tennessee", "Nashville"));
        states.add(new Pair<>("Texas", "Austin"));
        states.add(new Pair<>("Utah", "Salt Lake City"));
        states.add(new Pair<>("Vermont", "Montpelier"));
        states.add(new Pair<>("Virginia", "Richmond"));
        states.add(new Pair<>("Washington", "Olympia"));
        states.add(new Pair<>("West Virginia", "Charleston"));
        states.add(new Pair<>("Wisconsin", "Madison"));
        states.add(new Pair<>("Wyoming", "Cheyenne"));

        while (!states.isEmpty()) {
            Pair<String, String> state = states.get(random.nextInt(states.size()));
            System.out.print("What is the capital of " + state.getKey() + "? ");
            if (state.getValue().equalsIgnoreCase(in.nextLine()))
                System.out.println("Your answer is correct.");
            else
                System.out.println("The correct answer is " + state.getValue());
            states.remove(state);
            Collections.shuffle(states);
        }

    }
}
