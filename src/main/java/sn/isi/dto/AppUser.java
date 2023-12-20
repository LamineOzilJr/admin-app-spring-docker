package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private int id;
    @NotNull(message = "Last Name mustn't be nulled")
    private String nom;
    @NotNull(message = "First Name mustn't be nulled")
    private String prenom;
    @NotNull(message = "Email mustn't be nulled")
    private String email;
    @NotNull(message = "Paasword mustn't be nulled")
    private String password;
    @NotNull
    private int etat;

}
