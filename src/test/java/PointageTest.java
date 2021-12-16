import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.PointageService;
import com.youcode.systemepointage.service.UtilisateurService;

public class PointageTest {
    public void testpointer(){
        Utilisateur hassan = UtilisateurService.getInstance().trouverUtilisateurParEmail(
                Utilisateur.builder().email("cbenhzaine@mail.com").build()
        );

        PointageService.getInstance().pointer(hassan);
    }
}
