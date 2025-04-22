/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.thearraylistchallenge;

/**
 *
 * @author laispaivaportela 
 */
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList; //importando a classe de ArrayList

//TheArrayListChallenge
public class TheArrayListChallenge {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<String> groceryList = new ArrayList<>(); //criando a grocery list (empty) e deixando disponível para todos os métodos (static)

    public static void main(String[] args) {
        String comoFunciona = """
                app your grocery list
                dicas:
                -> no menu digite o número que representa a ação que você deseja utilizar
                -> adicione/remova itens escrevendo o nome deles (se for mais de um item por vez por favor separe os itens com vírgulas.
                """;
        System.out.println(comoFunciona);
        boolean rodando = true;
        while (rodando) {
            menuApp(); //mostra o menu
            int escolha = input.nextInt();
            input.nextLine();
            switch (escolha) { //entrapara o que o usuário escolher a partir do menu
                case 1:
                    adicionaItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    imprimeLista();
                    break;
                case 4:
                    System.out.println("tem certeza que quer limpar a lista?\ntodos os itens adicionados até agora vão ser removidos.\n0 -> limpar lista\n1 -> cancelar operação");
                    int respostaLimpar = input.nextInt();
                    input.nextLine();
                    if (respostaLimpar == 0) {
                        limpaLista();
                    } else {
                        System.out.println("sem problemas!\ncancelando operação...");
                    }
                    break;
                case 0:
                    System.out.println("tem certeza que quer sair do programa?\n0 -> sair do programa\n1 -> cancelar operação");
                    int respostaBye = input.nextInt();
                    input.nextLine();
                    if (respostaBye == 0) {
                        System.out.println("certo!\nobrigado por usar nosso app.\nsaindo...");
                        rodando = false; //encerra o programa
                    } else {
                        System.out.println("sem problemas!\ncancelando operação...");
                    }
                    break;
            }
        }
    }

    public static void menuApp() { //imprime o menu sempre que chamado
        String menu = """
                menu
                0 -> fechar app
                1 -> adicionar item(s) 
                2 -> remover item(s)
                3 -> ver lista atual
                4 -> limpar a lista
                """;
        System.out.println(menu);
    }

    public static void adicionaItem() { //adiciona itens à lista a partir de arrays comuns e verifica se eles estão duplicados
        String entrada = input.nextLine();
        String[] itensAdiciona = entrada.split(","); // array comum temporário com as entradas (e já tira as vírgulas)

        for (int i = 0; i < itensAdiciona.length; i++) { // vai rodar o array comum todo
            String item = itensAdiciona[i].trim();

            //verifica se o item tá duplicado antes de adicionar
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            } else {
                System.out.println("item '" + item + "' já está na lista.");
            }
        }
    }

    public static void removeItem() { //remove itens à lista a partir de arrays normais
        String entrada = input.nextLine();
        String[] itensRemove = entrada.split(",");
        for (int i = 0; i < itensRemove.length; i++) {
            groceryList.remove(itensRemove[i].trim()); // remover e tirar espaços extras
        }
    }

    public static void imprimeLista() {
        groceryList.sort(Comparator.naturalOrder()); //deixa os itens em ordem alfabéticas
        if (groceryList.isEmpty()) { //verifica se a lista está vaziaa
            System.out.println("a lista está vazia.");
        } else {
            System.out.println("itens na lista:");
            System.out.println(String.join(", ", groceryList)); //vai printar a lista delimitada por vírgulas
        }
    }

    public static void limpaLista() { //limpa a lista
        groceryList.clear();
        System.out.println("lista limpa!");
    }
}
