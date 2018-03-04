package flysall.typeinfo;

import java.util.*;

public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }
    public void add(String... titles) {
        for(String title : titles)
            add(new Position(title));
    }
    public Staff(String... titles) {
        add(titles);
    }

    /**
     * 判断职位是否为空
     * @param title 职位
     * @return true or false
     */
    public boolean positionAvailable(String title) {
        for(Position position : this)
            if(position.getTitle().equals(title) &&
                    position.getPerson() == Person.NULL)
                return true;
        return false;
    }

    /**
     * 若职位为空,则雇佣求职者,不为空则抛出RuntimeException!
     * @param title 职位
     * @param hire 求职者
     * @throws RuntimeException
     */
    public void fillPosition(String title, Person hire) {
        for(Position position : this) {
            if(position.getTitle().equals(title) &&
                    position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " +
            title + "not available");
    }
    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO",
                "Marketing Manager", "Product Manager",
                "Project Lead", "Software Engineer",
                "Software Engineer", "Software Engineer",
                "Software Engineer", "Test Engineer",
                "Technical Writer");
        staff.fillPosition("President", new Person("Me", "Last", "The top , Lonely At"));
        staff.fillPosition("Project Lead",
                new Person("Janet", "Planner", "The Burbs"));
        if(staff.positionAvailable("Software Engineer"))
            staff.fillPosition("Software Engineer",
                    new Person("Bob", "Coder", "Bright Light City"));
        System.out.println(staff);
    }
}
