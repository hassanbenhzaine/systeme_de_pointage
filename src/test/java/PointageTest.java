import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.PointageService;
import com.youcode.systemepointage.service.UtilisateurService;

public class PointageTest {
    public void testpointer(){
        UtilisateurService utilisateurService = new UtilisateurService();
        Utilisateur hassan = utilisateurService.trouverUtilisateur("cbenhzaine@gmail.com");

        PointageService pointer = new PointageService();
        pointer.pointer(hassan);
    }
}
