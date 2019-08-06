package fix.task;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HourseService {

    public int findAndCount(List<Position> passedSteps, Position end, int count, int width, int height, int currentStepsCount) {
        int nextStepsCount = 0;

        List<Position> currentPosList = new ArrayList<>(passedSteps.subList(passedSteps.size() - currentStepsCount, passedSteps.size()));

        for (Position currentPos: currentPosList) {

            int vertical = currentPos.getVertical();
            int horizontal = currentPos.getHorizontal();

            if ( ((vertical + 1) <= width) && ((horizontal + 2) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical + 1, horizontal + 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((vertical + 2) <= width) && ((horizontal + 1) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical + 2, horizontal + 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((vertical - 1) >= 1) && ((horizontal + 2) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical - 1, horizontal + 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((vertical - 2) >= 1) && ((horizontal + 1) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical - 2, horizontal + 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((vertical - 2) >= 1) && ((horizontal - 1) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical - 2, horizontal - 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((vertical - 1) >= 1) && ((horizontal - 2) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical - 1, horizontal - 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((vertical + 2) <= width) && ((horizontal - 1) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical + 2, horizontal - 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((vertical + 1) <= width) && ((horizontal - 2) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(vertical + 1, horizontal - 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

        }

        count++;

        if (nextStepsCount == 0) return -1;
        return findAndCount(passedSteps, end, count, width, height, nextStepsCount);

    }


    public static Pair<Boolean, Integer> doPositionCheck(int vertical, int horizontal, Position end, List<Position> passedSteps, int nextStepsCount) {
        Position posTemp = new Position(vertical, horizontal);
        if ( posTemp.equals(end) ) return new Pair<>(true, nextStepsCount);
        else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
            passedSteps.add(posTemp);
            nextStepsCount++;
            return new Pair<>(false, nextStepsCount);
        }
        else return new Pair<>(false, nextStepsCount);
    }


    public int findAndCount(Position start, Position end, int count, int width, int height, int currentStepsCount) {
        if (end.equals(start)) {
            return 0;
        }
        else
            return findAndCount(new ArrayList<>(Collections.singletonList(start)), end, count, width, height, currentStepsCount);
    }

}
