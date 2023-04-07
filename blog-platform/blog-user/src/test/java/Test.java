import com.heyufei.user.entity.User;

import java.util.ArrayList;

/**
 * @author HeYuFei
 * @since 2023-04-07  11:24
 */
public class Test {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUsername("1");
        User user2 = new User();
        user2.setUsername("2");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        for (User user: users){
            user.setId(3333L);
        }
        hhh(users);

        System.out.println(users);

    }

    public static void hhh(ArrayList<User> users){
        for (User user: users){
            user.setId(44444L);
        }
    }
}
