package br.cefetmg.implicare.model.domain.jpa;
// Generated 29/11/2018 03:11:02 by Hibernate Tools 4.3.1


import br.cefetmg.implicare.model.domain.jpa.relacionamentos.ExperienciaProfissionalId;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExperienciaProfissional generated by hbm2java
 */
@Entity
@Table(name="experiencia_profissional"
    ,schema="public"
)
public class ExperienciaProfissional  implements java.io.Serializable {


     private ExperienciaProfissionalId id;
     private Candidato candidato;
     private Cargo cargo;
     private String nomEmpresa;
     private Date dataInicio;
     private Date dataTermino;
     private String descExperienciaProfissional;

    public ExperienciaProfissional() {
    }

	
    public ExperienciaProfissional(ExperienciaProfissionalId id, Candidato candidato, Cargo cargo, String nomEmpresa, Date dataInicio) {
        this.id = id;
        this.candidato = candidato;
        this.cargo = cargo;
        this.nomEmpresa = nomEmpresa;
        this.dataInicio = dataInicio;
    }
    public ExperienciaProfissional(ExperienciaProfissionalId id, Candidato candidato, Cargo cargo, String nomEmpresa, Date dataInicio, Date dataTermino, String descExperienciaProfissional) {
       this.id = id;
       this.candidato = candidato;
       this.cargo = cargo;
       this.nomEmpresa = nomEmpresa;
       this.dataInicio = dataInicio;
       this.dataTermino = dataTermino;
       this.descExperienciaProfissional = descExperienciaProfissional;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="cpf", column=@Column(name="cpf", nullable=false) ), 
        @AttributeOverride(name="seqExperienciaProfissional", column=@Column(name="seq_experiencia_profissional", nullable=false) ), 
        @AttributeOverride(name="codCargo", column=@Column(name="cod_cargo", nullable=false) ) } )
    public ExperienciaProfissionalId getId() {
        return this.id;
    }
    
    public void setId(ExperienciaProfissionalId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cpf", nullable=false, insertable=false, updatable=false)
    public Candidato getCandidato() {
        return this.candidato;
    }
    
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_cargo", nullable=false, insertable=false, updatable=false)
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    
    @Column(name="nom_empresa", nullable=false)
    public String getNomEmpresa() {
        return this.nomEmpresa;
    }
    
    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_inicio", nullable=false, length=13)
    public Date getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_termino", length=13)
    public Date getDataTermino() {
        return this.dataTermino;
    }
    
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    
    @Column(name="desc_experiencia_profissional")
    public String getDescExperienciaProfissional() {
        return this.descExperienciaProfissional;
    }
    
    public void setDescExperienciaProfissional(String descExperienciaProfissional) {
        this.descExperienciaProfissional = descExperienciaProfissional;
    }




}


