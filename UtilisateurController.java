public class UtilisateurController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    // Get All Utilisateurs
@GetMapping("/utilisateur")
public List<Utilisateur> getUtilisateurs() {
    return (List<Utilisateur>) utilisateurRepository.findAll();
}
// Create a new Utilisateur
@PostMapping("/utilisateurs")
public Utilisateur createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
    return utilisateurRepository.save(utilisateur);
}

// Get a Single Utilisateur
@GetMapping("/utilisateurs/{id}")
public Utilisateur getUtilisateurById(@PathVariable(value = "id") Long utilisateurId) {
    return utilisateurRepository.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));
}
  
// Delete a Utilisateur
@DeleteMapping("/utilisateurs/{id}")
public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
    Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));

    utilisateurRepository.delete(utilisateur);

    return ResponseEntity.ok().build();
}
}
