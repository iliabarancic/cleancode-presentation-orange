import java.util.ArrayList;
import java.util.List;

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

    private class Person {

        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }


    private List<Person> createCDS() {
        List<Person> cds = new ArrayList<>();

        Person yunus = new Person();
        yunus.setFirstName("Yunus");
        yunus.setLastName("Durmus");
        cds.add(yunus);

        Person timo = new Person();
        timo.setFirstName("Timo");
        timo.setLastName("Krauss");
        cds.add(timo);

        return cds;
    }

    public List<ResultDto> buildResult(Set<ResultEntity> resultSet) {
        List<ResultDto> result = new ArrayList<>();
        for (ResultEntity entity : resultSet) {
            result.add(toDto(entity));
        }
        return result;
    }

    private ResultDto toDto(ResultEntity entity) {
        ResultDto dto = new ResultDto();
        dto.setShoeSize(entity.getShoeSize());
        dto.setNumberOfEarthWorms(entity.getNumberOfEarthWorms());
        dto.setAge(computeAge(entity.getBirthday()));
        return dto;
    }

    MyDataDao dataDao = new MyDataDao();

    public void process(MyData data) {
        if (validate(data)) {
            dataDao.save(data);
        } else {
            throw new RuntimeException("Error");
        }
    }

    private class MyDataDao {
        void save(MyData data) {

        }
    }

    private void save(MyData data) {

    }

    private boolean validate(MyData data) {
        return false;
    }


}