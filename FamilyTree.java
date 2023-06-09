import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class FamilyTree implements Serializable {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<Human>();
    }


    public void add(Human human) {
        if (!familyTree.contains(human)) {
            this.familyTree.add(human);
            if (human.getFather() != null) human.getFather().addChildren(human);
            if (human.getMather() != null) human.getMather().addChildren(human);
        }
    }


    public List<Human> searchHuman(String lastName) {
        List<Human> searchTemp = new ArrayList<>();
        for (Human item : familyTree) {
            if (item.getLastname().equals(lastName)) searchTemp.add(item);
        }
        return searchTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyTree that = (FamilyTree) o;
        return Objects.equals(familyTree, that.familyTree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyTree);
    }

    @Override
    public String toString() {
        for (Human item : familyTree) {
            System.out.println(item);
        }
        return " ";
    }
}