package databases.sources;

import databases.lists.ListBarang;
import models.ModelBarang;
import utils.Enums.StatusBarang;

public class SourceBarang {
    private ListBarang listBarang = new ListBarang();

    public void insertDataBarang() {
        listBarang.insert(
                new ModelBarang(
                        1,
                        "Tenda kap 3",
                        40000,
                        StatusBarang.AVAILABLE));
        listBarang.insert(
                new ModelBarang(
                        2,
                        "Sepatu u42",
                        15000,
                        StatusBarang.AVAILABLE));
    }

    public ListBarang getListBarang() {
        return listBarang;
    }
}
