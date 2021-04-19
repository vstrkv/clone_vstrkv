import java.sql.SQLOutput;
import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        User user1 = new User();
        Baby baby = new Baby();
        user1.id = 1;
        user1.baby = baby;
        User userClone = user1.clone();
        System.out.println("-------------------------- поверхностное");

        System.out.println("id " + (user1.id == userClone.id));
        System.out.println("Baby.age " + (user1.baby.age == userClone.baby.age));
        System.out.println("____изменение пораметров");
        user1.id = 3;
        userClone.baby.age = 505;
        System.out.println("id " + (user1.id == userClone.id));
        System.out.println("Baby.age " + (user1.baby.age == userClone.baby.age));
        System.out.println("-------------------------- глубокое");

        User user2 = new User();
        Baby baby2 = new Baby();
        user2.id = 5;
        user2.baby = baby2;
        User userCloneDeep = user2.cloneDeep();
        System.out.println("id " + (user2.id == userCloneDeep.id));
        System.out.println("Baby.age " + (user2.baby.age == userCloneDeep.baby.age));
        System.out.println("____изменение пораметров");
        user2.id = 3;
        userCloneDeep.baby.age = 505;
        System.out.println("id " + (user2.id == userCloneDeep.id));
        System.out.println("Baby.age " + (user2.baby.age == userCloneDeep.baby.age));

    }
}

class User implements Cloneable {
    int id;
    Baby baby;

    @Override
    protected User clone() throws CloneNotSupportedException { // поверхностное
        return (User) super.clone();
    }
    
    protected User cloneDeep() throws CloneNotSupportedException { //глубокое клонирование
        User user = (User) super.clone();
        user.baby = baby.clone();
        return user;
    }
}

class Baby implements Cloneable{
    int age;

    @Override
    protected Baby clone() throws CloneNotSupportedException {
        return (Baby) super.clone();
    }
}



