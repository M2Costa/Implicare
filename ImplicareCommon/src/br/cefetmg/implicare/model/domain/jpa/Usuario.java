package br.cefetmg.implicare.model.domain.jpa;
// Generated 29/11/2018 03:11:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,schema="public"
)
public class Usuario  implements java.io.Serializable {


     private long cpfCnpj;
     private String email;
     private String senha;
     private byte[] foto;
     private Long codCep;
     private String endereco;
     private String descUsuario;
     private Set<Telefone> telefones = new HashSet<Telefone>(0);
     private Empresa empresa;
     private Candidato candidato;

    public Usuario() {
    }

	
    public Usuario(long cpfCnpj, String email, String senha, String endereco) {
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
    public Usuario(long cpfCnpj, String email, String senha, byte[] foto, Long codCep, String endereco, String descUsuario, Set<Telefone> telefones, Empresa empresa, Candidato candidato) {
       this.cpfCnpj = cpfCnpj;
       this.email = email;
       this.senha = senha;
       this.foto = foto;
       this.codCep = codCep;
       this.endereco = endereco;
       this.descUsuario = descUsuario;
       this.telefones = telefones;
       this.empresa = empresa;
       this.candidato = candidato;
    }
   
     @Id 

    
    @Column(name="cpf_cnpj", unique=true, nullable=false)
    public long getCpfCnpj() {
        return this.cpfCnpj;
    }
    
    public void setCpfCnpj(long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    
    @Column(name="email", nullable=false)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="senha", nullable=false, length=44)
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Column(name="foto")
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    
    @Column(name="cod_cep")
    public Long getCodCep() {
        return this.codCep;
    }
    
    public void setCodCep(Long codCep) {
        this.codCep = codCep;
    }

    
    @Column(name="endereco", nullable=false)
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    @Column(name="desc_usuario")
    public String getDescUsuario() {
        return this.descUsuario;
    }
    
    public void setDescUsuario(String descUsuario) {
        this.descUsuario = descUsuario;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set<Telefone> getTelefones() {
        return this.telefones;
    }
    
    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="usuario")
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="usuario")
    public Candidato getCandidato() {
        return this.candidato;
    }
    
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }




}

