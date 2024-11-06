package Hash;
import java.util.LinkedList;

public class HashTable<K, V> {
    private  LinkedList<HashEntry<K, V>> [] tabelaHash; // tabela hash
    private int tamanho;   // tamanho da tabela hash

    public HashTable(int tamanho){
        tabelaHash = new LinkedList[tamanho];
        this.tamanho = tamanho;
    }

    // funcao que calcula a posicao onde vc vai inserir o valor na tabela
    // funcao hash???
    public int getPosition(int valor){
        return valor % tamanho;
    }

    // PRIMEIRA FUNCAO DE HASH
    public int hashDivisao(String texto, int M) {
        int soma = 0;
        for (char c : texto.toCharArray()) {
            soma += (int) c;
        }
        return soma % M;
    }

    // SEGUNDA FUNCAO DE HASH
    public int hashDJB2(String texto) {
        long hash = 5381;
        for (char c : texto.toCharArray()) {
            hash = ((hash << 5) + hash) + c; // hash * 33 + c
        }
        return (int) (hash % Integer.MAX_VALUE);
    }

    // retorta o valor associado a chave na tabela hash
    public LinkedList<V> get(K chave){
        int posicao;
        LinkedList<V> valoresPosicao = new LinkedList<V>();

        if(chave == null){
            return null;
        }

        posicao = getPosition(Math.abs(chave.hashCode()));

        // se a posicao for nulla, entao nenhuma elemento com aquela chave foi inserido ainda na tabela
        if(tabelaHash[posicao] == null){
            return null;
        }else{

            LinkedList<HashEntry<K, V>> lista = tabelaHash[posicao];

            for(int i = 0; i < lista.size(); i++){

                HashEntry<K, V> lista_atual = lista.get(i);

                if(chave.equals(lista_atual.chave)){
                    valoresPosicao.add(lista_atual.valor);
                }
            }

            return valoresPosicao;

        }


    }

    public boolean insercao(K chave, V valor){
        int posicao;

        if(chave == null){
            return false;
        }

        // antes de inserir, precisamos checar se ja nao existe na colecao um chave com valor indentico ao que estamos tentando
        // inerir. Caso exista, nao devemos inserir
        LinkedList<V> currentValueKey = get(chave);
        if(currentValueKey != null && currentValueKey.contains(valor)){
            return false;
        }

    
        posicao = getPosition(Math.abs(chave.hashCode()));

        // pegando a lista da posicao em que precismaos inserir
        LinkedList<HashEntry<K, V>> lista = tabelaHash[posicao];

        // testando se essa posicao eh nulla ou se ja possui algum valor
        if(lista == null){
            lista = new LinkedList<HashEntry<K, V>>();  // criando a lista
            
        }

        lista.add(new HashEntry<K, V>(chave, valor));  // inserindo o valor na lista
        tabelaHash[posicao] = lista;   // guardando a lista na posicao

        return true;
    }

    public void print(){
        for(int i = 0; i < tabelaHash.length; i++){
            
            System.out.println("--------------------");
            System.out.println("Posicao " + i + ":");
            if(tabelaHash[i] == null){
                System.out.println("posicao vazia na tabela");
            }else{
                LinkedList<HashEntry<K, V>> lista_aux = tabelaHash[i];
                for(int j = 0; j < lista_aux.size(); j++){
                    System.out.println(lista_aux.get(j).toString() + " - ");
                }
            }
        }
    }
}

