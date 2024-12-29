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
                        "asd",
                        "asd",
                        "asd",
                        Role.ADMIN));
        listUser.insert(
                new ModelUser(
                        2,
                        "qwe",
                        "qwe",
                        "qwe",
                        Role.CUSTOMER));
    }

    public ListUser getListUser() {
        return listUser;
    }
}