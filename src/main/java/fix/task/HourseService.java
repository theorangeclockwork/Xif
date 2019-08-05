package fix.task;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class HourseService {

    public int findAndCount(List<Position> passedSteps, Position end, int count, int width, int height, int currentStepsCount) {
        int nextStepsCount = 0;

        List<Position> currentPosList = new ArrayList<>(passedSteps.subList(passedSteps.size() - currentStepsCount, passedSteps.size()));

        for (Position currentPos: currentPosList) {

            int ver = currentPos.getVertical();
            int gor = currentPos.getHorizontal();

            if ( ((ver + 1) <= width) && ((gor + 2) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 1, gor + 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver + 2) <= width) && ((gor + 1) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 2, gor + 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 1) >= 1) && ((gor + 2) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 1, gor + 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 2) >= 1) && ((gor + 1) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 2, gor + 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 2) >= 1) && ((gor - 1) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 2, gor - 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 1) >= 1) && ((gor - 2) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 1, gor - 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver + 2) <= width) && ((gor - 1) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 2, gor - 1, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver + 1) <= width) && ((gor - 2) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 1, gor - 2, end, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

        }

        count++;

        if (nextStepsCount == 0) return -1;
        return findAndCount(passedSteps, end, count, width, height, nextStepsCount);

    }


    public static Pair<Boolean, Integer> doPositionCheck(int ver, int gor, Position end, List<Position> passedSteps, int nextStepsCount) {
        Position posTemp = new Position(ver, gor);
        if ( posTemp.equals(end) ) return new Pair<>(true, nextStepsCount);
        else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
            passedSteps.add(posTemp);
            nextStepsCount++;
            return new Pair<>(false, nextStepsCount);
        }
        else return new Pair<>(false, nextStepsCount);
    }


    public int findAndCount(Position start, Position end, int count, int width, int height, int currentStepsCount) {
        return findAndCount(new ArrayList<>(Collections.singletonList(start)), end, count, width, height, currentStepsCount);
    }



}
