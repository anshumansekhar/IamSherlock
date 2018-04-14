package com.technovation.iamsherlock;

import java.util.HashMap;

/**
 * Created by Anshuman-HP on 15-03-2018.
 */

public class dialogues {
    HashMap<String,String> dailogue=new HashMap<>();

    public dialogues() {

        String g="1-good,2-shocked,3-angry,4-attitude";

        dailogue.put("first","Sherlock\tIt has been a while since i have had some fun\t1\tSherlock\tI wish for more crimes to solve \t1" +
                "\tsimple\tPhone rings..\t0\tSherlock\tYes who is it\t1\tCriminal\tHellooo,Sherlock\t0\tCriminal\tHow are you\t0\tSherlock\tI am good,but " +
                "who are you?\t0\tCriminal\tAlright Let me get you straight,I was bored today and decided to kill someone\t0\tSherlock\t \t2" +
                "\tCriminal\tStill after killing i wasn't satisfied\t0\tCriminal\tHence i decided to call you ,to test your wit\t0\t" +
                "Criminal\tI will be giving you 6 clues which after solving i will reveal my face\t0\t" +
                "Criminal\tCatch me if you can\t0\tsimple\tFirst Clue\t0\tsimple\tThe start is the end and the end is the start,Ask the " +
                "almighty god to know the next clue\t1\tCriminal\tAlright so you got the first one now go to the second one\t0\t" +
                "Sherlock\t \t4\tCriminal\tTime for your next one\t0\tsimple\tThe young cane poses the next clue find it out\t1\t" +
                "Criminal\tYou are impressive.Good job\t0\tSherlock\tDont waste my time,Give me the next clues\t4\t" +
                "Criminal\tAlright heres your next one\t0\tsimple\tThe birth place of the papers that never sees the dust bin\t1\t" +
                "Criminal\tWow\t0\tSherlock\t \t2\tsimple\tgo to the place where food goes for justice\t1\t" +
                "Criminal\tNot bad,you are clever\t0\tSherlock\t \t2\tsimple\tSearch for the next clue on the wall of the palace in the sky\t1\t" +
                "Criminal\tVery Good,The Last one is coming up,get ready\t0\tSherlock\t \t2\tsimple\tThe ocean of Knowledge held my name,solve the riddle and i will reaveal my face,Come get me\t1\t");
    }
}
