public class Bank {
    private User[] users;
    private int size;

    public Bank() {
        this.users = new User[10];
        this.size = 0;
    }

    public void addUser(User user) {
        if (size == users.length) {

            User[] temp = new User[users.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = users[i];
            }
            users = temp;
        }
        users[size++] = user;
    }

    public void updateUserById(int id, User user) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                users[i] = user;
                break;
            }
        }
    }

    public void removeUserById(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {

                for (int j = i; j < size - 1; j++) {
                    users[j] = users[j + 1];
                }
                users[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public User[] getAllUser() {
        return users;
    }

    public User getUserById(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }
}