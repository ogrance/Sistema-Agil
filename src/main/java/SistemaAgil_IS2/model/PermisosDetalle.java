package SistemaAgil_IS2.model;

import java.util.List;

public class PermisosDetalle {
    private List<Roles> lista;
    private Permisos permiso;
    private Roles roles;

    public PermisosDetalle(List<Roles> lista, Permisos permiso, Roles roles) {
        this.lista = lista;
        this.permiso = permiso;
        this.roles = roles;
    }

    public PermisosDetalle() {
    }

    public List<Roles> getLista() {
        return lista;
    }

    public void setLista(List<Roles> lista) {
        this.lista = lista;
    }

    public Permisos getPermiso() {
        return permiso;
    }

    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "PermisosDetalle{" +
                "lista=" + lista +
                ", permiso=" + permiso +
                ", roles=" + roles +
                '}';
    }
}
