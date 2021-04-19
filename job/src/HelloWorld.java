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
        System.out.println(user1.id);
        System.out.println(userClone.id);

        user1.id = 3;
        userClone.baby.age = 505;
        System.out.println(userClone.baby.age);
        System.out.println(user1.baby.age + " это значение мы не меняли");
        System.out.println("-------------------------- конструктор");

        User user2 = new User();
        Baby baby2 = new Baby();

        user2.id = 5;
        user2.baby = baby2;

        User userCon = new User(user2);
        System.out.println(userCon.baby.age);
        System.out.println(user2.baby.age);

        userCon.baby.age = 505;
        System.out.println(userCon.baby.age);
        System.out.println(user2.baby.age + " это значение мы не меняли");
    }
}

class User implements Cloneable {
    int id;
    Baby baby;

    public User() {

    }

    public User(int id, Baby baby) {
        this.id = id;
        this.baby = baby;
    }
    public User(User user) {
        this(user.id,user.baby);
    }




    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone(); // для глубого клонирования нужно сюда прописывать ссылочныые типы, Baby
    }


}

class Baby {
    int age;
}



