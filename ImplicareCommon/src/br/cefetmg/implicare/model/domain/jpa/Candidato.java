package br.cefetmg.implicare.model.domain.jpa;
// Generated 29/11/2018 03:11:02 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Candidato generated by hbm2java
 */
@Entity
@Table(name="candidato"
    ,schema="public"
)
public class Candidato  implements java.io.Serializable {

     private long cpf;
     private Usuario usuario;
     private String nome;
     private Date dataNascimento;
     private Set<Cargo> cargos = new HashSet<Cargo>(0);
     private Set<ExperienciaProfissional> experienciaProfissionals = new HashSet<ExperienciaProfissional>(0);
     private Set<CandidatoVaga> candidatoVagas = new HashSet<CandidatoVaga>(0);
     private Set<FormacaoAcademica> formacaoAcademicas = new HashSet<FormacaoAcademica>(0);

    public Candidato() {
    }

	
    public Candidato(Usuario usuario, String nome, Date dataNascimento) {
        this.usuario = usuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public Candidato(Usuario usuario, String nome, Date dataNascimento, Set<Cargo> cargos, Set<ExperienciaProfissional> experienciaProfissionals, Set<CandidatoVaga> candidatoVagas, Set<FormacaoAcademica> formacaoAcademicas) {
       this.usuario = usuario;
       this.nome = nome;
       this.dataNascimento = dataNascimento;
       this.cargos = cargos;
       this.experienciaProfissionals = experienciaProfissionals;
       this.candidatoVagas = candidatoVagas;
       this.formacaoAcademicas = formacaoAcademicas;
    }
   
    @Id
    @GeneratedValue(generator="generator")
    @Column(name="cpf", unique=true, nullable=false)
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="usuario"))    public long getCpf() {
        return this.cpf;
    }
    
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @OneToOne(fetch=FetchType.LAZY)
@PrimaryKeyJoinColumn
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="nome", nullable=false)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_nascimento", nullable=false, length=13)
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="cargo_interesse", schema="public", joinColumns = {
        @JoinColumn(name="cpf", nullable=false, updatable=false) }, inverseJoinColumns = {
            @JoinColumn(name="cod_cargo", nullable=false, updatable=false) })
    public Set<Cargo> getCargos() {
        return this.cargos;
    }
    
    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="candidato")
    public Set<ExperienciaProfissional> getExperienciaProfissionals() {
        return this.experienciaProfissionals;
    }
    
    public void setExperienciaProfissionals(Set<ExperienciaProfissional> experienciaProfissionals) {
        this.experienciaProfissionals = experienciaProfissionals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="candidato")
    public Set<CandidatoVaga> getCandidatoVagas() {
        return this.candidatoVagas;
    }
    
    public void setCandidatoVagas(Set<CandidatoVaga> candidatoVagas) {
        this.candidatoVagas = candidatoVagas;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="candidato")
    public Set<FormacaoAcademica> getFormacaoAcademicas() {
        return this.formacaoAcademicas;
    }
    
    public void setFormacaoAcademicas(Set<FormacaoAcademica> formacaoAcademicas) {
        this.formacaoAcademicas = formacaoAcademicas;
    }




}


