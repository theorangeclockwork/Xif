package fix.task;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HourseService {


    public static int findAndCount(List<Position> passedSteps, Position end, int count, int width, int height, int currentStepsCount) {
        int nextStepsCount = 0;

        List<Position> currentPosList = new ArrayList<>(passedSteps.subList(passedSteps.size() - currentStepsCount, passedSteps.size()));

        for (Position currentPos: currentPosList) {

            int ver = currentPos.getVertical();
            int gor = currentPos.getHorizontal();

            if ( ((ver + 1) <= width) && ((gor + 2) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 1, gor + 2, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver + 2) <= width) && ((gor + 1) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 2, gor + 1, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 1) >= 1) && ((gor + 2) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 1, gor + 2, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 2) >= 1) && ((gor + 1) <= height) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 2, gor + 1, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 2) >= 1) && ((gor - 1) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 2, gor - 1, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver - 1) >= 1) && ((gor - 2) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver - 1, gor - 2, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver + 2) <= width) && ((gor - 1) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 2, gor - 1, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

            if ( ((ver + 1) <= width) && ((gor - 2) >= 1) ) {
                Pair<Boolean, Integer> temp = doPositionCheck(ver + 1, gor - 2, end, count, passedSteps, nextStepsCount);
                if (temp.getKey()) return count;
                else nextStepsCount = temp.getValue();
            }

        }

        count++;

        if (nextStepsCount == 0) return -1;
        return findAndCount(passedSteps, end, count, width, height, nextStepsCount);

    }


    public static Pair<Boolean, Integer> doPositionCheck(int ver, int gor, Position end, int count, List<Position> passedSteps, int nextStepsCount) {
        Position posTemp = new Position(ver, gor);
        if ( posTemp.equals(end) ) return new Pair<>(true, nextStepsCount);
        else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
            passedSteps.add(posTemp);
            nextStepsCount++;
            return new Pair<>(false, nextStepsCount);
        }
        else return new Pair<>(false, nextStepsCount);
    }

}


//    public int findAndCount(List<Position> passedSteps, Position end, int count, int width, int height, int currentStepsCount) {
//        int nextStepsCount = 0;
//
//        List<Position> currentPosList = new ArrayList<>(passedSteps.subList(passedSteps.size() - currentStepsCount, passedSteps.size()));
//
//        for (Position currentPos: currentPosList) {
//            int ver = currentPos.getVertical();
//            int gor = currentPos.getHorizontal();
//
//            // Максимальное количество вариантов ходов из одной точки, доступных коню - восемь
//            // Ниже следует обработка каждого из возможных ходов для каждой из "текущих позиций"
//            if ( ((ver + 1) <= width) && ((gor + 2) <= height) ) {
//                Position posTemp = new Position(ver + 1, gor + 2);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//            if ( ((ver + 2) <= width) && ((gor + 1) <= height) ) {
//                Position posTemp = new Position( ver + 2, gor + 1);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//            if ( ((ver - 1) >= 1) && ((gor + 2) <= height) ) {
//                Position posTemp = new Position(ver - 1, gor + 2);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//            if ( ((ver - 2) >= 1) && ((gor + 1) <= height) ) {
//                Position posTemp = new Position(ver - 2, gor + 1);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//            if ( ((ver - 2) >= 1) && ((gor - 1) >= 1) ) {
//                Position posTemp = new Position(ver - 2, gor - 1);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//            if ( ((ver - 1) >= 1) && ((gor - 2) >= 1) ) {
//                Position posTemp = new Position(ver - 1, gor - 2);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//            if ( ((ver + 2) <= width) && ((gor - 1) >= 1) ) {
//                Position posTemp = new Position(ver + 2, gor - 1);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//            if ( ((ver + 1) <= width) && ((gor - 2) >= 1) ) {
//                Position posTemp = new Position(ver + 1, gor - 2);
//                if ( posTemp.equals(end) ) return count;
//                else if (passedSteps.stream().noneMatch(p -> p.equals(posTemp))) {
//                    passedSteps.add(posTemp);
//                    nextStepsCount++;
//                }
//            }
//
//        }
//
//        count++;
//        if(nextStepsCount == 0) return -1;
//        return findAndCount(passedSteps, end, count, width, height, nextStepsCount);
//
//    }
