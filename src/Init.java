import controllers.*;
import databases.sources.SourceBarang;
import databases.sources.SourceLaporan;
import databases.sources.SourceTransaksi;
import databases.sources.SourceUser;
import views.admin.*;

public class Init {
    // Controllers
    public ControllerUser controllerUser;
    public ControllerBarang controllerBarang;
    public ControllerTransaksi controllerTransaksi;
    public ControllerLaporan controllerLaporan;

    // Views
    public ViewUser viewUser;
    public ViewBarang viewBarang;
    public ViewTransaksi viewTransaksi;
    public ViewLaporan viewLapaoran;

    // Datasources
    public SourceUser sourceUser;
    public SourceBarang sourceBarang;
    public SourceTransaksi sourceTransaksi;
    public SourceLaporan sourceLaporan;
    
    public Init() {
        // Buat database
        sourceUser = new SourceUser();
        sourceBarang = new SourceBarang();
        sourceTransaksi = new SourceTransaksi();
        sourceLaporan = new SourceLaporan();

        // Buat controller
        controllerUser = new ControllerUser(sourceUser);
        controllerBarang = new ControllerBarang(sourceBarang);
        controllerTransaksi = new ControllerTransaksi(sourceTransaksi);
        controllerLaporan = new ControllerLaporan(sourceLaporan);
    }

    // Isi database
    public void insertDatasource(){
        sourceUser.insertDataUser();
        sourceBarang.insertDataBarang();
        sourceTransaksi.insertDataTransaksi();
        sourceLaporan.insertDataLaporan();
    }
}