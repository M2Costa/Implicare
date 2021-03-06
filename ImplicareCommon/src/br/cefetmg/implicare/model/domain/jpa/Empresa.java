package br.cefetmg.implicare.model.domain.jpa;
// Generated 29/11/2018 03:11:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Empresa generated by hbm2java
 */
@Entity
@Table(name="empresa"
    ,schema="public"
)
public class Empresa  implements java.io.Serializable {


     private long cnpj;
     private Usuario usuario;
     private String nomRazaoSocial;
     private String nomeFantasia;
     private Set<Vaga> vagas = new HashSet<>(0);

    public Empresa() {
    }

	
    public Empresa(Usuario usuario, String nomRazaoSocial, String nomeFantasia) {
        this.usuario = usuario;
        this.nomRazaoSocial = nomRazaoSocial;
        this.nomeFantasia = nomeFantasia;
    }
    public Empresa(Usuario usuario, String nomRazaoSocial, String nomeFantasia, Set<Vaga> vagas) {
       this.usuario = usuario;
       this.nomRazaoSocial = nomRazaoSocial;
       this.nomeFantasia = nomeFantasia;
       this.vagas = vagas;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="usuario"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="cnpj", unique=true, nullable=false)
    public long getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="nom_razao_social", nullable=false)
    public String getNomRazaoSocial() {
        return this.nomRazaoSocial;
    }
    
    public void setNomRazaoSocial(String nomRazaoSocial) {
        this.nomRazaoSocial = nomRazaoSocial;
    }

    
    @Column(name="nome_fantasia", nullable=false)
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
    
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empresa")
    public Set<Vaga> getVagas() {
        return this.vagas;
    }
    
    public void setVagas(Set<Vaga> vagas) {
        this.vagas = vagas;
    }




}


