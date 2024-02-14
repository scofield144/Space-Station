/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import entidades.Ficheiros;
import entidades.Gerenciar;
import entidades.*;
import enums.Combustivel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author fvict
 */
    public class MainApp {
        
    private static final  Gerenciar gerenciar = new Gerenciar();
    private static final  Ficheiros ficheios = new Ficheiros();    
    private static final  List<PortoEspacial> portoLista = new ArrayList<>();
    private static final  List<Transporte> transportesLista = new ArrayList<>();
    private static final  List<NaveEspacial> naveEspacialsLista = new ArrayList<>();
    
    private static Scanner in = new Scanner(System.in);
        
    public static void main(String[] args) {
            try {
               System.out.println("BEM VINDO A SPACE X");
               carregarFicheiros();
               menuInicial();
           } catch (Exception e) {
               System.out.println("Erro: " + e.getMessage());
               e.printStackTrace();
           }        
    }
// Exibe o menu inicial para o usuário escolher entre operações relacionadas a portos, naves e transporte.

    public static void menuInicial()
    {
         int option = 0;
         System.out.println("MENU PRINCIPAL");
            System.out.println("""
                               1 - PORTO
                               2 - NAVE
                               3 - TRANSPORTE
                               4 - SAIR""");
            System.out.print("Digite: ");

        try {                       
            option = in.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.nextLine(); // limpa o buffer
        menuInicial();
        return;
    }   
        switch (option) {
            case 1 -> menuPortoEspacial();
            case 2 -> menuNaveEspacial();
            case 3 -> menuTransporte();
            case 4 -> {
                sair();
                return;
            }
        }        
    }

//    ---------------------PORTO ESPACIAL-----------------------------
    // Métodos relacionados ao menu de operações para Portos Espaciais.

     public static void menuPortoEspacial()
     {   
        int option;
        System.out.println("Bem Vindo ao porto da Space X");
        System.out.println("""
                           1 - Criar
                           2 - Consultar
                           3 - Apagar
                           4 - Mostrar
                           5 - Voltar""");
        System.out.print("Digite: ");        
        try {
        option = in.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.nextLine(); // limpa o buffer
        menuPortoEspacial();
        return;
    }            
            switch (option) {
            case 1 -> criarPorto();
            case 2 -> consultarPorto();
            case 3 -> apagarPorto();
            case 4 -> mostrarPortos();
            case 5 -> menuInicial();            
        }        
     }
     // Exibe informações sobre os Portos Espaciais existentes.     
    public static void mostrarPorto()
    {
        for (PortoEspacial portoEspacial : portoLista) {
            System.out.println("|----------------------------------------------|");
                System.out.println(portoEspacial.toString());                
        }
//        return null;
    }  
    
    public static <T> int escolher(List<T> pesquisar, int index)
    {
//        int index;
       try {
        if (index > -1 && index <= pesquisar.size()) {
            return index;
        }
    } catch (Exception e) {
        System.out.println("Erro ao escolher item: " + e.getMessage());
    }
    return -1;
    }   
//    Criar coordenadas
    public static Coordenadas coordenadas()
    {
            try {
             System.out.println("INSERINDO COORDENADAS");
             int x,y,z;
             System.out.print("X: ");
             x= in.nextInt();
             System.out.print("Y: ");
             y= in.nextInt();
             System.out.print("Z: ");
             z= in.nextInt();                
             return new Coordenadas(x, y, z);
         } catch (InputMismatchException e) {
             System.out.println("Por favor, insira um número válido para as coordenadas.");
             in.nextLine(); // limpa o buffer
         } catch (Exception e) {
             System.out.println("Erro ao criar coordenadas: " + e.getMessage());
         }
         return null;
    }
//    // Cria um novo Porto Espacial com base na entrada do usuário.

    public static void criarPorto() {
    try {
        System.out.println("CRIAR PORTO");
        int qtd = 0;
        int id = 0;
        System.out.print("Digite quantidade de porto a criar: ");
        qtd = in.nextInt();
        PortoEspacial porto;

        while(qtd-- > 0){
            id = portoLista.size();
            String nome;
            Coordenadas coordenadas = coordenadas();
            if(coordenadas.getX()==0 && coordenadas.getY() == 0 && coordenadas.getZ() == 0){
                nome = "Terra";
            }else{
                in.nextLine();
                System.out.println("Digite nome: ");            
                nome = in.nextLine();
            }        
            porto = new PortoEspacial(id+1, nome, coordenadas);
            boolean result = gerenciar.registarPortos(portoLista,porto);
            if (result) {
                System.out.println("Porto criado");
            }else{
                System.out.println("Porto Nao criado");
            }        
        }
        menuPortoEspacial();
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.next(); // limpa o buffer
    } catch (NullPointerException e) {
        System.out.println("Erro: um valor nulo foi encontrado onde não era esperado.");
    } catch (Exception e) {
        System.out.println("Erro ao criar porto: " + e.getMessage());
    }
}
//     Mostrar todos os portos
     public static void mostrarPortos()
     {
         if (portoLista.isEmpty()) {
             System.out.println("Nenhum porto criado");
             menuPortoEspacial();
         }
         for (PortoEspacial portoEspacial : portoLista) {
            System.out.println("|----------------------------------------------|");
                System.out.println(portoEspacial.toString());                
        }      
         menuPortoEspacial();
     }
//     Mostrar somente o id e nome do porto
     private static void mostrarPortoID()
     {
         for (PortoEspacial portoEspacial : portoLista) {
            System.out.println("|----------------------------------------------|");
                System.out.println(portoEspacial.getNumero()+" - "+portoEspacial.getNome());                
        }
     }
     // Consulta um Porto Espacial específico com base no ID fornecido pelo usuário.
     public static PortoEspacial consultarPorto() {
    try {
        if (portoLista.isEmpty()) {
            
            System.out.println("Nenhum porto criado");
            menuPortoEspacial();
        }
        System.out.println("CONSULTAR PORTO");
        System.out.println("ID - NOME");
        int id = 0;
        for (PortoEspacial porto : portoLista) {            
            System.out.println(porto.getNumero() + " - "+ porto.getNome());
        }
        System.out.print("Digite ID: ");
        id = in.nextInt();
        if(id > 0 && id <= portoLista.size()){
            System.out.println(portoLista.get(id-1).toString());
            return portoLista.get(id-1);
        }else{
            System.out.println("Valor invalido");
        }
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido para o ID.");
        in.next(); // limpa o buffer
    } catch (Exception e) {
        System.out.println("Erro ao consultar porto: " + e.getMessage());
    }
    menuPortoEspacial();
    return null;
}

   // Apaga um Porto Espacial específico com base no ID fornecido pelo usuário.

     public static void apagarPorto() {
    try {
        if (portoLista.isEmpty()) {
            System.out.println("Nehum Porto foi criada");            
            menuNaveEspacial();
            return;
        }
        PortoEspacial portoConsultada = consultarPorto();
        if (portoConsultada == null) {
            System.out.println("Nave nao encontrada");
        } else {
            int id = portoLista.indexOf(portoConsultada);
            if (id >= 0) {
                gerenciar.apagarByPosition(portoLista, id);
                System.out.println("Porto Apagado");
            } else {
                System.out.println("Erro: Porto não encontrado na lista.");
            }
        }
    } catch (Exception e) {
        System.out.println("Erro ao apagar porto: " + e.getMessage());
    } finally {
        menuPortoEspacial();
    }
}   
    
    
//----------------------------------- NAVE ESPACIAL----------------------------------------------
     // Métodos relacionados ao menu de operações para Naves Espaciais.

    public static void menuNaveEspacial() {
    try {
        int option = 0;
        System.out.println("Bem Vindo a Naves Espacial Space X");
        System.out.println("""
                           1 - Criar
                           2 - Consultar
                           3 - Apagar
                           4 - Mostrar
                           5 - Historico
                           6 - Voltar """);
        System.out.print("Digite: ");
        if (in.hasNextInt()) {
            option = in.nextInt();
        } else {
            System.out.println("Por favor, insira um número válido.");
            in.next(); // limpa o buffer
            menuNaveEspacial();
            return;
        }
        switch (option) {
            case 1 -> criarNave();
            case 2 -> consultarNave();
            case 3 -> apagarNave();
            case 4 -> mostrarNave();
            case 5 -> mostrarHistorico();
            case 6 -> menuInicial();
            default -> {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                menuNaveEspacial();
            }
        }
    } catch (Exception e) {
        System.out.println("Erro no menu de Naves Espaciais: " + e.getMessage());
    } finally {
        menuInicial();
    }
}

    // Cria uma nova Nave Espacial com base na entrada do usuário.

    private static void criarNave() {
    try {
        int qtd = 0;

        if(portoLista.isEmpty()){
            System.out.println("Nenhum porto criado");
            criarPorto();
        }

        System.out.print("Digite quantidade de nave a criar: ");
        qtd = in.nextInt();
        int id = 0;
        mostrarPortoID();
        while (qtd-- >0) {

            System.out.print("Digite id: ");
            id = in.nextInt();
            id--;
            if(id > -1 && id <= portoLista.size()){
                System.out.print("Tipo de Nave: ");
                System.out.print("1 - FTL   2 - SUBLUZ:  ");
                int tipo = in.nextInt();

                in.nextLine();
                System.out.print("Nome: ");
                String nome = in.nextLine();

                if(tipo == 1) {
                    addFTL(nome,portoLista.get(id));
                } else {
                    addSUBLUZ(nome,portoLista.get(id));
                }

                // Exibindo os dados inseridos
                System.out.println("\nDados da Nave Espacial:");
            } else {
                System.out.println("ID errado");
            }
        }
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.next(); // limpa o buffer
    } catch (Exception e) {
        System.out.println("Erro ao criar nave: " + e.getMessage());
    }
}

    // Consulta uma Nave Espacial específica com base no ID fornecido pelo usuário.

private static NaveEspacial consultarNave() {
    try {
        if (naveEspacialsLista.isEmpty()) {
            System.out.println("Nenhuma nave foi criada");
            return null;
        }
        System.out.println("CONSULTAR NAVE");
        System.out.println("ID - NOME");
        int id = 0;
        for (NaveEspacial nave : naveEspacialsLista) {            
            System.out.println(++id + " - "+ nave.getNome());
        }
        System.out.print("Digite ID: ");
        if (in.hasNextInt()) {
            id = in.nextInt();
            id--;
            if(id >= 0 && id < naveEspacialsLista.size()){
                System.out.println(naveEspacialsLista.get(id).toString());
                return naveEspacialsLista.get(id);
            } else {
                System.out.println("Valor inválido");
            }
        } else {
            System.out.println("Por favor, insira um número válido para o ID.");
            in.next(); // limpa o buffer
        }
    } catch (Exception e) {
        System.out.println("Erro ao consultar nave: " + e.getMessage());
    }
    return null;
}

// Apaga uma Nave Espacial específica com base no ID fornecido pelo usuário.

    private static void apagarNave()
    {
        if (naveEspacialsLista.isEmpty()) {
            System.out.println("Nehuma nave foi criada");   
            return;
        }
        NaveEspacial naveConsultada = consultarNave();
        if (naveConsultada == null) {
            System.out.println("Nave nao encontrada");
        }else{
            int id = naveEspacialsLista.indexOf(naveConsultada);
            gerenciar.apagarByPosition(naveEspacialsLista, id);
            System.out.println("Nave Apagada");            
        }
        menuNaveEspacial();
                
    }
    // Exibe informações sobre as Naves Espaciais existentes.

    private static void mostrarNave()
    {
        if (naveEspacialsLista.isEmpty()) {
            System.out.println("Nenhuma Nave criada");
            menuNaveEspacial();
        }
        System.out.println("Monstrando Nave");
        for (NaveEspacial nave: naveEspacialsLista) {
            System.out.println("**************************************************************");
            System.out.println(nave.toString());
        }        
    }
    // Adiciona uma Nave Espacial do tipo FTL com base na entrada do usuário.

    public static void addFTL(String nome, PortoEspacial porto) {
    try {
        System.out.println("ADICIONAR NAVE FTL");
        System.out.println("Insere o limite de transporte: ");
        int limite = in.nextInt();
        System.out.print("Velocidade Máxima (Trek): ");
        double velocidadeMaxima = in.nextDouble();
        NaveEspacial ftl = new FTL(velocidadeMaxima,limite, nome,porto);
        boolean criar = gerenciar.registarNaves(naveEspacialsLista, ftl);
        if (criar) {
            System.out.println("Criado com sucesso");
        }else{
            
            System.out.println("Nao criado");
        }
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.next(); // limpa o buffer
    } catch (Exception e) {
        System.out.println("Erro ao adicionar nave FTL: " + e.getMessage());
    }
}
       // Adiciona uma Nave Espacial do tipo Subluz com base na entrada do usuário.

  public static void addSUBLUZ(String nome, PortoEspacial porto) {      
    try {
              
        System.out.println("ADICIONAR NAVE SUBLUZ");
        System.out.println("Escolhe tipo de combustivel");
        System.out.println("1 - Nuclear   2 - ION");
        int option = in.nextInt();
        System.out.print("Velocidade de Impulso menor que 0.3: ");
        double velocidade = in.nextDouble();
        if(velocidade < 0.3){
            System.out.println("Velocidade invalida");
            return;
        }
        Subluz subluz = new Subluz();
        
        if (option == 1) {
        
            subluz = new Subluz(velocidade, Combustivel.NUCLEAR, nome,porto);
        } else {
        
            subluz = new Subluz(velocidade, Combustivel.ION, nome,porto);           
        }       
        
        boolean registar = gerenciar.registarNaves(naveEspacialsLista, subluz);
            if (registar) {

                System.out.println("Criado com sucesso");
            }else{
                System.out.println("Nao criado");
            }
        
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.next(); // limpa o buffer
    } catch (Exception e) {
        System.out.println("Erro ao adicionar nave SUBLUZ: " + e.getMessage());
    }
}
   // Exibe o histórico de transporte de uma Nave Espacial específica.
   private static void mostrarHistorico()
   {
       if(naveEspacialsLista.isEmpty()){
           return;
       }
       
       NaveEspacial nave = consultarNave();
       
       if(nave != null){
           System.out.println("Mostrando o historico de transporte da Nave");
           nave.mostrarHistorico();
       }
       
       
   }    
    
//----------------------------------- TRANPORTE ----------------------------------------------
   // Métodos relacionados ao menu de operações para Transportes.

      public static void menuTransporte() {
    try {
        int option = 0;
        System.out.println("Bem Vindo aos Transportes");
        System.out.println("""
                           1 - Criar
                           2 - Consultar
                           3 - Apagar
                           4 - Designar
                           5 - Mostrar
                           6 - Mostrar Todos
                           7 - Cancelar
                           8 - Voltar   """);
        System.out.print("Digite: ");
        if (in.hasNextInt()) {
            option = in.nextInt();
        } else {
            System.out.println("Por favor, insira um número válido.");
            in.next(); // limpa o buffer
            menuTransporte();
            return;
        }
        switch (option) {
            case 1 -> criarTransporte();
            case 2 -> consultarTransporte();
            case 3 -> apagarTransporte();
            case 4 -> designarTransporte();
            case 5 -> mostrarTransporte();
            case 6 -> mostrarTodosTransportes();
            case 7 -> cancelarTransporte();
            case 8 -> menuInicial();
            default -> {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                menuTransporte();
            }
        }
    } catch (Exception e) {
        System.out.println("Erro no menu de Transportes: " + e.getMessage());
    } finally {
        menuTransporte();
    }
}

// Cria um novo transporte (de pessoa ou material) com base na entrada do usuário.

    public static void criarTransporte() {
    try {
        // Verifica se a lista de portos está vazia
        if(portoLista.isEmpty()){
            System.out.println("Nao existe porto");
            criarPorto();
        }
        
        int i=0;
        int option = 0;
        int verificar = 0;
        List<PortoEspacial> listPorto = new ArrayList<>();
        mostrarPortoID();
        // Loop para obter o porto de origem e destino
        while(i<2){
            if(i==0){
                System.out.print("Digite porto de origem: ");
            }else{
                System.out.print("Digite porto de destino: ");
            }
            option = in.nextInt();
            // Verifica se a opção é válida
            if (option > 0 && option <= portoLista.size() && option != verificar ) {
                int resultadoEscolha = escolher(portoLista, option);
                if (resultadoEscolha != -1) {
                    // Adiciona o porto à lista
                    listPorto.add(portoLista.get(option-1));
                    i++;
                }
            }
            verificar = option;            
        }
        
        // Se nenhum porto foi adicionado, retorna
        if(i==0) {
            System.out.println("erro ao criar");
            return;
        }
        System.out.println("Tipo de Transporte: 1 -> Pessoa, 2-> Material ");
        option = in.nextInt();
        // Cria o transporte com base na opção
        if(option == 1) {
            addPessoa(listPorto);
        } else {
            addMaterial(listPorto);
        }        
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.next(); // limpa o buffer
    } catch (Exception e) {
        System.out.println("Erro ao criar transporte: " + e.getMessage());
    }
}


    private static void mostrarTransporteID()
    {
        System.out.println("Identificador");
        for (Transporte transporte : transportesLista) {
            System.out.println(transporte.getIdentificador());
        }
    }
        // Consulta um transporte específico com base no ID fornecido pelo usuário.

   public static Transporte consultarTransporte() {
    try {
        int id = 0;
        if (transportesLista.isEmpty()) {
            System.out.println("Nenhum transporte criado");
            return null;
        }
        mostrarTransporteID();
        System.out.println("Digite o ID: ");
        if (in.hasNextInt()) {
            id = in.nextInt();
            if(id > 0 && id <= transportesLista.size()){
                // decrementar o id para que esteja mais conforme a logica da estrutura List que o index inicia pelo 0
                id--;
                System.out.println("Transporte encontrado");
                System.out.println(transportesLista.get(id).toString());
                return transportesLista.get(id);
            } else {
                System.out.println("Nao encontrado transporte");
            }
        } else {
            System.out.println("Por favor, insira um número válido para o ID.");
            in.next(); // limpa o buffer
        }
    } catch (Exception e) {
        System.out.println("Erro ao consultar transporte: " + e.getMessage());
    }
    return null;
}

    // Apaga um transporte específico com base no ID fornecido pelo usuário.

  private static void apagarTransporte() {
    try {
        if (transportesLista.isEmpty()) {
            System.out.println("Nenhum transporte criado");
            return;
        }
        Transporte transporte = consultarTransporte();
        if (transporte != null) {
            int index = transportesLista.indexOf(transporte);
            if (index >= 0) {
                gerenciar.apagarByPosition(transportesLista, index);
                System.out.println("Apagado");
            } else {
                System.out.println("Erro: Transporte não encontrado na lista.");
            }
        }
    } catch (Exception e) {
        System.out.println("Erro ao apagar transporte: " + e.getMessage());
    }
}

    // Adiciona um transporte de pessoa com base na entrada do usuário.

  public static void addPessoa(List<PortoEspacial> listPorto) {
    try {
        System.out.println("ADICIONANDO PESSOA");
        int qtd, id;
        System.out.println("Quantidade de carga: ");
        if (in.hasNextInt()) {
            qtd = in.nextInt();
        } else {
            System.out.println("Por favor, insira um número válido para a quantidade de carga.");
            in.next(); // limpa o buffer
            return;
        }
        id = transportesLista.size();
        Transporte pessoaTransporte = new Pessoas(qtd, id+1, listPorto.get(0), listPorto.get(1));
        boolean result = gerenciar.registarTransporte(transportesLista, pessoaTransporte);
        if(result) {
            System.out.println("Adicionado com sucesso");
        } else {
            System.out.println("Erro ao adicionar");
        }
    } catch (Exception e) {
        System.out.println("Erro ao adicionar pessoa: " + e.getMessage());
    } finally {
        menuTransporte();
    }
}

   // Adiciona um transporte de material com base na entrada do usuário.

  public static void addMaterial(List<PortoEspacial> listPorto) {
    try {
        // Exibe mensagem de adição de material
        System.out.println("ADICIONANDO MATERIAL");
        String descricao;
        int qtd, id;

        // Limpa o buffer de entrada
        in.nextLine();

        // Solicita a descrição do material
        System.out.println("Inseri descricao do material:");
        descricao = in.nextLine();

        // Solicita a quantidade de carga
        System.out.println("Quantidade de carga: ");
        qtd = in.nextInt();

        // Define o ID com base no tamanho da lista de transportes
        id = transportesLista.size();

        // Cria um novo transporte de material
        Transporte materialTransporte = new Material(descricao, qtd, id+1, listPorto.get(0), listPorto.get(1));

        // Registra o transporte na lista de transportes
        boolean result = gerenciar.registarTransporte(transportesLista, materialTransporte);

        // Exibe mensagem de sucesso ou erro
        if(result) {
            System.out.println("Adicionado com sucesso");
        } else {
            System.out.println("Erro ao adicionar");
        }
    } catch (InputMismatchException e) {
        System.out.println("Por favor, insira um número válido.");
        in.next(); // limpa o buffer
    } catch (Exception e) {
        System.out.println("Erro ao adicionar material: " + e.getMessage());
    } finally {
        // Retorna ao menu de transporte
        menuTransporte();
    }
}

   // Exibe informações sobre todos os transportes existentes e tambem realizar a viagem.

   private static void mostrarTodosTransportes()
   {
       Gerenciar.mostrarTodosTransportes(transportesLista,naveEspacialsLista);
   }
   // Designa um transporte para uma nave específica com base na entrada do usuário.

    public static void designarTransporte() {
    try {
        
        if (transportesLista.isEmpty()) {
            System.out.println("Nenhum transporte criado");
            menuTransporte();
        }
        
        System.out.println("DESIGNAR TRANSPORTE");
        Transporte transporte = consultarTransporte();
        int id = -1;
        //Transporte nao encontrado volta para o menu do transporte
        if (transporte == null) {
            menuTransporte();
        }
        id = transportesLista.indexOf(transporte);
        // Tenta designar o transporte
        boolean designar = gerenciar.designarTransporte(naveEspacialsLista, transportesLista,id, data());

        // Verifica se a designação foi bem-sucedida
        if (designar) {
            System.out.println("Designacao feita");
        } else {
            System.out.println("Designacao nao feita");
        }
    } catch (Exception e) {
        // Imprime a mensagem de erro se ocorrer uma exceção
        System.out.println("Erro ao designar transporte: " + e.getMessage());
    }
}

    // Exibe informações sobre os transportes existentes com base no estado escolhido.
public static void mostrarTransporte() {
    try {
        // Verifica se a lista de transportes está vazia
        if (transportesLista.isEmpty()) {
            System.out.println("Nenhum Transporte criado");
            menuTransporte();
            return;
        }
        System.out.println("MOSTRAR TRANSPORTE");
        int option;
        System.out.println("1 - A transportar\n2 - Pendentes\n3 - Finalizado\n4 - Cancelado\n5 - Sair");
        if (in.hasNextInt()) {
            option = in.nextInt();
        } else {
            System.out.println("Por favor, insira um número válido.");
            in.next(); // limpa o buffer
            menuTransporte();
            return;
      }
        
        // Exibe os transportes com base na opção selecionada
        System.out.println("Monstrando Transporte");
        switch (option) {
            case 1 -> {
                for (Transporte transporte : transportesLista) {
                    if (transporte.getEstado().toString().equalsIgnoreCase("A Transportar")) {
                        System.out.println(transporte.toString());
                        System.out.println("**************************************************");
                    }
                }
            }
            case 2 -> {
                for (Transporte transporte : transportesLista) {
                    if (transporte.getEstado().toString().equalsIgnoreCase("Pendente")) {
                        System.out.println(transporte.toString());
                        System.out.println("**************************************************");
                    }
                }
            }
            case 3 -> {
                for (Transporte transporte : transportesLista) {
                    if (transporte.getEstado().toString().equalsIgnoreCase("Finalizado")) {
                        System.out.println(transporte.toString());
                        System.out.println("**************************************************");
                    }
                }
            }
            case 4 -> {
                for (Transporte transporte : transportesLista) {
                    if (transporte.getEstado().toString().equalsIgnoreCase("Cancelado")) {
                        System.out.println(transporte.toString());
                        System.out.println("**************************************************");
                    }
                }
            }
            case 5 -> {
                menuTransporte();
            }
            default -> {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                menuTransporte();
            }
        }
    } catch (Exception e) {
        System.out.println("Erro ao mostrar transporte: " + e.getMessage());
    }
}
    // Cancela um transporte específico com base na entrada do usuário.

 private static void cancelarTransporte() {
    try {
        // Exibe mensagem de cancelamento de transporte
        System.out.println("CANCELAR TRANSPORTE");

        // Consulta o transporte
        Transporte transporte = consultarTransporte();

        // Verifica se o transporte foi encontrado
        if (transporte == null) {
            System.out.println("Nao encontrado");
            return;
        }
        // Verifica se o estado do transporte permite cancelamento
        if (transporte.getEstado().equals("Finalizado") || transporte.getEstado().equals("Cancelado")) {
            System.out.println("Nao posso cancelar esse transporte");
            return;
        }
        // Obtém o índice do transporte na lista
        int index = transportesLista.indexOf(transporte);

        // Tenta cancelar o transporte
        boolean cancelar = gerenciar.cancelar(naveEspacialsLista, transportesLista, index);

        // Verifica se o cancelamento foi bem-sucedido
        if (cancelar) {
            System.out.println("Transporte cancelado");
        } else {
            System.out.println("Transporte nao cancelado");
        }
    } catch (Exception e) {
        // Imprime a mensagem de erro se ocorrer uma exceção
        System.out.println("Erro ao cancelar transporte: " + e.getMessage());
    }
}
    // Retorna uma nova instância de Date com base na entrada do usuário.

    public static Date data()
{
    System.out.println("ADICIONANDO DATA");
    int dia, mes, ano;
    Date novaData = null;
    while (novaData == null) {
        try {
            System.out.print("Dia: ");
            dia = in.nextInt();
            System.out.print("Mes: ");
            mes = in.nextInt();
            System.out.print("Ano: ");
            ano = in.nextInt();
            novaData = new Date(dia, mes, ano);
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número válido.");
            in.nextLine(); // limpa o buffer
        } catch (IllegalArgumentException e) {
            System.out.println("Por favor, insira uma data válida.");
            in.nextLine(); // limpa o buffer
        }
    }
    return novaData;
}

//     TRABALHAR COM FICHEIROS
      // Carrega os dados dos arquivos.

      private static void carregarFicheiros(){
          ficheios.carregar(portoLista, transportesLista, naveEspacialsLista);          
      }
      // Salva os dados nos arquivos.
      private static void salvarFicheiros(){          
          boolean ficheiro = ficheios.salvar(portoLista, transportesLista, naveEspacialsLista);
          if (ficheiro) {
              System.out.println("Salvo");
          }else {
              System.out.println("Nao Salvado");
          }
      }
      // Realiza operações antes de encerrar o programa, como salvar dados, se necessário.
      private static void sair()
      {
          int escolha = 0;
          System.out.println("Terminar Programa");          
          System.out.println("""
                             1 - Salvar
                             2 - Nao salvar""");
          System.out.print("Digite: ");
          escolha = in.nextInt();
          
          if (escolha == 1) {
              salvarFicheiros();
          }else{
              
          }                  
      }
}
