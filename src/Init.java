import controllers.*;
import databases.*;
import databases.lists.ListUser;
import databases.sources.SourceUser;
import models.*;
import utils.Enums.Role;
import views.*;
import views.admin.*;

public class Init {
    // Controllers
    public ControllerAuth controllerAuth;
    public ControllerBarang controllerBarang;
    public ControllerTransaksi controllerTransaksi;
    public ControllerUser controllerUser;

    // Views
    public Auth auth;
    public ViewBarang viewBarang;
    public ViewTransaksi viewTransaksi;
    public ViewUser viewUser;

    // Datasources
    public SourceUser sourceUser;
    
    public Init(
        
    ) {
        // Views
        auth = new Auth();
        viewBarang = new ViewBarang();
        viewTransaksi = new ViewTransaksi();
        viewUser = new ViewUser();

        // Databases
        sourceUser = new SourceUser();
    }
    public void insertDatasource(){
        sourceUser.insertDataUser();
    }
}