package databases.sources;

import databases.lists.ListTransaksi;

public class SourceTransaksi {
    private ListTransaksi listTransaksi = new ListTransaksi();

    public void insertDataTransaksi() {
        // listTransaksi.insert(
        //         new ModelTransaksi(
        //                 1,
        //                 "asd",
        //                 100,
        //                 StatusTransaksi.AVAILABLE));
        // listTransaksi.insert(
        //         new ModelTransaksi(
        //                 2,
        //                 "qwe",
        //                 0,
        //                 StatusTransaksi.AVAILABLE));
    }

    public ListTransaksi getListTransaksi() {
        return listTransaksi;
    }
}
