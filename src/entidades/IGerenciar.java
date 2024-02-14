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
public interface IGerenciar {

    // Registra um novo porto espacial na lista de portos.
    public boolean registarPortos(List<PortoEspacial> portoLista, PortoEspacial novoPorto);

    // Registra uma nova nave espacial na lista de naves.
    public <T> boolean registarNaves(List<NaveEspacial> listNave, T naveEspacial);

    // Registra um novo transporte na lista de transportes pendentes.
    public <T> boolean registarTransporte(List<T> transportesListaPendent, T novoTransporte);

    // Altera o estado de um transporte para o estado especificado.
    public Transporte alterarEstado(Transporte transporte, int estado);

    // Designa um transporte para uma nave espacial com base na data especificada.
    public boolean designarTransporte(List<NaveEspacial> listNave, List<Transporte> listTransporte,int index ,Date date);

    // Carrega dados a partir de arquivos ou outra fonte.
    public boolean carregarDados();

    // Apaga um elemento de uma lista com base em sua posição (índice).
    public <T> void apagarByPosition(List<T> list, int id);

    // Cancela um transporte específico.
    public boolean cancelar(List<NaveEspacial> listNave, List<Transporte> listTransport, int index);

    // Executa operações antes de encerrar o programa, como salvar dados.
//    public void sair();
}

