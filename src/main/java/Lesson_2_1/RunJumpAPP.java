package Lesson_2_1;

public class RunJumpAPP {
    public static void main(String[] args) {
        Participant[] participants = new Participant[3];
        Barrier[] barriers = new Barrier[2];

        participants[0] = new Human();
        participants[1] = new Cat();
        participants[2] = new Robot();

        barriers[0] = new RunningTrack(1);
        barriers[1] = new Wall(1);

        for (Participant participant : participants){
            for (Barrier barrier : barriers ){
                if(barrier instanceof RunningTrack) {
                    if(participant.run(((RunningTrack) barrier).getLength()) == false) {
                        break;
                    }
                } // end test RunningTrack

                if(barrier instanceof Wall) {
                    if(participant.jump(((Wall) barrier).getHeight()) == false) {
                        break;
                    }
                } // end test Barrier
            } // end cycle barrier
        }// end cycle participant
    }// END main
}
