import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.service.RoleService;
import com.youcode.systemepointage.service.UtilisateurService;

public class UtilisateurTest {
    public static void test(){
        RoleService role = new RoleService();
        Role adminRole = role.trouverRole("ADMIN");

        Adresse hassanaddress = Adresse.builder()
                .adresse1("avenue de la liberté")
                .adresse2("20").codePostal(12030)
                .ville("Maroc")
                .pays("Rabat-sale-kenitra")
                .build();

        UtilisateurService utilisateurService = new UtilisateurService();
        utilisateurService.seEnregistrer("hassan",
                "benhzaine",
                "cbenhzaine@gmail.com",
                "123456789",
                "0607873886",
                hassanaddress,
                adminRole
        );

    }
}
