import com.example.back.model.Utilisateur;
import javax.persistence.Id;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author khalil
 */
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {
    
}
