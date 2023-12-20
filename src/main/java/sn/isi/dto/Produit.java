package sn.isi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    private int id;
    @NotNull(message = "Product Name mustn't be nulled")
    private String nom;
    @NotNull
    private double qtStock;

}
