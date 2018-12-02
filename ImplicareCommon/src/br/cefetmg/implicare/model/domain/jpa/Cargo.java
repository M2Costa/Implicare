package br.cefetmg.implicare.model.domain.jpa;
// Generated 29/11/2018 03:11:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cargo generated by hbm2java
 */
@Entity
@Table(name="cargo"
    ,schema="public"
)
public class Cargo  implements java.io.Serializable {


     private int codCargo;
     private String nomCargo;
     private Set<Vaga> vagas = new HashSet<Vaga>(0);
     private Set<AreaEstudo> areaEstudos = new HashSet<AreaEstudo>(0);
     private Set<Candidato> candidatos = new HashSet<Candidato>(0);
     private Set<ExperienciaProfissional> experienciaProfissionals = new HashSet<ExperienciaProfissional>(0);

    public Cargo() {
    }

	
    public Cargo(int codCargo, String nomCargo) {
        this.codCargo = codCargo;
        this.nomCargo = nomCargo;
    }
    public Cargo(int codCargo, String nomCargo, Set<Vaga> vagas, Set<AreaEstudo> areaEstudos, Set<Candidato> candidatos, Set<ExperienciaProfissional> experienciaProfissionals) {
       this.codCargo = codCargo;
       this.nomCargo = nomCargo;
       this.vagas = vagas;
       this.areaEstudos = areaEstudos;
       this.candidatos = candidatos;
       this.experienciaProfissionals = experienciaProfissionals;
    }
   
     @Id 

    
    @Column(name="cod_cargo", unique=true, nullable=false)
    public int getCodCargo() {
        return this.codCargo;
    }
    
    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    
    @Column(name="nom_cargo", nullable=false)
    public String getNomCargo() {
        return this.nomCargo;
    }
    
    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cargo")
    public Set<Vaga> getVagas() {
        return this.vagas;
    }
    
    public void setVagas(Set<Vaga> vagas) {
        this.vagas = vagas;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="cargos")
    public Set<AreaEstudo> getAreaEstudos() {
        return this.areaEstudos;
    }
    
    public void setAreaEstudos(Set<AreaEstudo> areaEstudos) {
        this.areaEstudos = areaEstudos;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="cargos")
    public Set<Candidato> getCandidatos() {
        return this.candidatos;
    }
    
    public void setCandidatos(Set<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cargo")
    public Set<ExperienciaProfissional> getExperienciaProfissionals() {
        return this.experienciaProfissionals;
    }
    
    public void setExperienciaProfissionals(Set<ExperienciaProfissional> experienciaProfissionals) {
        this.experienciaProfissionals = experienciaProfissionals;
    }




}


