import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Example {

    public static void main(String[] args) {

        System.out.println("Hello world");

    }

    /**
     * The day of the month.
     */
    private int dayOfMonth;

    /**
     * Returns the day of the month.
     *
     * @return the day of the month.
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * The name.
     */
    private String name;
    /**
     * The version.
     */
    private String version;
    /**
     * The licenceName.
     */
    private String licenceName;
    /**
     * The version.
     */
    private String info;


    private class Owner {
    }

    public interface OwnerRepository {
        List<Owner> getAllOwners();
    }

    private class Cell {
        public boolean isFlagged() {
            return true;
        }
    }

    private class GameBoard {
        private List<Cell> cells;

        public List<Cell> getCells() {
            return cells;
        }
    }

    private GameBoard gameBoard = new GameBoard();

    public List<Cell> getFlaggedCells() {
        List<Cell> flaggedCells = new ArrayList();
        for (Cell cell : gameBoard.getCells())
            if (cell.isFlagged())
                flaggedCells.add(cell);
        return flaggedCells;
    }

    public List<Cell> getFlaggedCells2() {
       return gameBoard.getCells().stream().filter(Cell::isFlagged).collect(toList());
    }


}