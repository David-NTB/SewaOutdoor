package databases.sources;

import databases.lists.ListUser;
import models.ModelUser;
import utils.Enums.Role;

public class SourceUser {
    private ListUser listUser = new ListUser();

    public void insertDataUser() {
        listUser.insert(
                new ModelUser(
                        1,
                        "Admin",
                        "admin.com",
                        "admin123",
                        Role.ADMIN));
        listUser.insert(
                new ModelUser(
                        2,
                        "Bawean",
                        "user.com",
                        "user123",
                        Role.CUSTOMER));
    }

    public ListUser getListUser() {
        return listUser;
    }
}
