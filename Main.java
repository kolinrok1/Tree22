import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FamilyTree testOne = new FamilyTree();
        Human humanOne = new Human("Олег", "Курицин", "1974-11-21", Gender.male);
        Human humanTwo = new Human("Алла", "Михеева", "1975-06-15", Gender.female);
        Human humanThree = new Human("Дима", "Курицин", "2000-03-08", Gender.male, humanTwo, humanOne);
        Human humanFour = new Human("Маша", "Воропанова", "2003-01-27", Gender.female);
        Human humanFive = new Human("Юля", "Петрова1", "2023-08-18", Gender.female, humanFour, humanThree);
        testOne.add(humanOne) ;
        testOne.add(humanTwo);
        testOne.add(humanThree);
        testOne.add(humanFour);
        testOne.add(humanFive);

        FamilyTree testTwo = new FamilyTree();

        //  Проверка сериализации
        String nameFile = "FamList";
        inOutSerialObject.saveFile(testOne,nameFile);
        testTwo = inOutSerialObject.loadFile(nameFile);
        System.out.println(testTwo);




    }
}