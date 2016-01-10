package br.com.k19.managedbeans;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.entidades.Grupo;
import br.com.k19.entidades.Usuario;
import br.com.k19.sessionbeans.GrupoRepositorio;
import br.com.k19.sessionbeans.UsuarioRepositorio;

@ManagedBean
public class UsuarioMB {

    @EJB
    private UsuarioRepositorio usuarioRepositorio;

    @EJB
    private GrupoRepositorio   grupoRepositorio;

    private Usuario            usuario = new Usuario();

    private List<String>       nomesDosGrupos;

    private List<Usuario>      usuarios;

    private List<Grupo>        grupos;

    public void adiciona() throws NoSuchAlgorithmException {
        for (String nomeDoGrupo : getNomesDosGrupos()) {
            Grupo g = new Grupo();
            g.setNome(nomeDoGrupo);
            getUsuario().getGrupos()
                        .add(g);
        }

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(getUsuario().getSenha()
                              .getBytes());
        BigInteger hash = new BigInteger(1, md.digest());
        String senhaCriptografada = hash.toString(16);

        while (senhaCriptografada.length() < 32) {
            senhaCriptografada = "0" + senhaCriptografada;
        }

        usuario.setSenha(senhaCriptografada);

        usuarioRepositorio.adiciona(getUsuario());
        setUsuario(new Usuario());
        usuarios = null;
    }

    public List<Grupo> getGrupos() {
        if (grupos == null) {
            grupos = grupoRepositorio.buscaTodos();
        }
        return grupos;
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = usuarioRepositorio.buscaTodos();
        }
        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<String> getNomesDosGrupos() {
        return nomesDosGrupos;
    }

    public void setNomesDosGrupos(List<String> nomesDosGrupos) {
        this.nomesDosGrupos = nomesDosGrupos;
    }
}
