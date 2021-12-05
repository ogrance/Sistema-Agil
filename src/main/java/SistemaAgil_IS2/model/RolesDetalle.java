package SistemaAgil_IS2_war.model;

import java.util.List;

public class RolesDetalle {
    private List<Roles> lista;
    private Usuario user;
    private Roles roles;

    public RolesDetalle() {
    }

    public RolesDetalle(List<Roles> lista, Usuario user, Roles roles) {
        this.lista = lista;
        this.user = user;
        this.roles = roles;
    }

    public List<Roles> getLista() {
        return lista;
    }

    public void setLista(List<Roles> lista) {
        this.lista = lista;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "RolesDetalle{" +
                "lista=" + lista +
                ", user=" + user +
                ", roles=" + roles +
                '}';
    }
}
