import com.youcode.systemepointage.dao.RoleDAOImp;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.service.RoleService;

public class UtilisateurTest {
    public static void test(){
        Role adminRole = new RoleService(new RoleDAOImp())
                .trouverParNom("ADMIN");

        Adresse hassanaddress = Adresse.builder()
                .adresse1("avenue de la liberté")
                .adresse2("20")
                .codePostal(12030)
                .region("Ile de france")
                .ville("Maroc")
                .pays("Rabat-sale-kenitra")
                .build();


//        new UtilisateurService(
//                new UtilisateurDAOImp(),
//                new RoleService(new RoleDAOImp()),
//                new AdresseService(new AdresseDAOImp())
//        ).seEnregistrer(
//                Utilisateur.builder()
//                        .nom("hassan")
//                        .prenom("benhzaine")
//                        .email("cbenhzaine@gmail.com")
//                        .motDePasse("123456")
//                        .telephone("0612345678")
//                        .statut(true)
//                        .build(),
//                hassanaddress,
//                adminRole
//        );

    }
}
