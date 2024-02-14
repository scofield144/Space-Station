/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package entidades;

import java.util.List;

/**
 *
 * @author fvict
 */
public interface IFicherio {
    public abstract boolean carregar(List<PortoEspacial> portoLista,
            List<Transporte> transportesLista,
            List<NaveEspacial> naveEspacialsLista);
    public abstract boolean salvar(List<PortoEspacial> portoLista, List<Transporte> transportesLista,List<NaveEspacial> naveEspacialsLista);
}
