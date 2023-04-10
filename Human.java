import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Human implements Serializable {
    private static int count = 1;
    private final int id;
    protected final String firstName;
    protected final String lastname;
    private final String dateOfBirth;
    private final String dateOfDeath;
    private final String gender;
    private Human mather;
    private Human father;
    private final List<Human> childrens;

    public Human(String firstName, String lastname, String dateOfBirth, Gender gender, Human mather, Human father) {
        this.id = count++;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.gender = String.valueOf(gender);
        this.mather = mather;
        this.father = father;
        this.childrens = new ArrayList<>();
    }

    public Human(String firstName, String lastname, String dateOfBirth, Gender gender) {
        this.id = count++;
        this.firstName = firstName;
        this.lastname = lastname;
        this.gender = String.valueOf(gender);
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.mather = null;
        this.father = null;
        this.childrens = new ArrayList<>();
    }


    public String getLastname() {
        return lastname;
    }


    public Human getMather() {
        return mather;
    }

    public Human getFather() {
        return father;
    }


    public void addChildren(Human human) {

        if(!childrens.contains(human)) {
            childrens.add(human);
        }
    }

    public StringBuilder getHumanInfoTXT(){
        StringBuilder sbH = new StringBuilder();
        sbH.append(this.id);
        sbH.append(",");
        sbH.append(this.firstName);
        sbH.append(",");
        sbH.append(this.lastname);
        sbH.append(",");
        sbH.append(this.dateOfBirth);
        sbH.append(",");
        if(this.dateOfDeath != null) sbH.append(this.dateOfDeath);
        else sbH.append("null");
        sbH.append(",");
        sbH.append(this.gender);
        return sbH;
    }

    @Override
    public String toString() {
        if (dateOfDeath != null) {
            return " %s %s(id %d) \n  Дата рождения - %s' Дата сметри - %s'\n".formatted(firstName, lastname, id, dateOfBirth, dateOfDeath);
        }
        return " %s %s (id %d) \n  Дата рождения - %s \n".formatted(firstName, lastname, id, dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id && Objects.equals(firstName, human.firstName) && Objects.equals(lastname, human.lastname) && Objects.equals(dateOfBirth, human.dateOfBirth) && Objects.equals(dateOfDeath, human.dateOfDeath) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, dateOfBirth, dateOfDeath, gender);
    }
}