package databases.sources;

import databases.lists.ListLaporan;

public class SourceLaporan {
    private ListLaporan listLaporan = new ListLaporan();

    public void insertDataLaporan() {
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

    public ListLaporan getListLaporan() {
        return listLaporan;
    }
}
