package com.projeto.UPX2.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "materiais")
public class Materiais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String objeto;
    private String material; //
    private boolean ehreciclavel;
    private String formaReciclagem;

    public Materiais(String objeto, String material, boolean ehreciclavel, String formaReciclagem) {
        this.objeto = objeto;
        this.material = material;
        this.ehreciclavel = ehreciclavel;
        this.formaReciclagem = formaReciclagem;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isEhreciclavel() {
        return ehreciclavel;
    }

    public void setEhreciclavel(boolean ehreciclavel) {
        this.ehreciclavel = ehreciclavel;
    }

    public String getFormaReciclagem() {
        return formaReciclagem;
    }

    public void setFormaReciclagem(String formaReciclagem) {
        this.formaReciclagem = formaReciclagem;
    }
}
