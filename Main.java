import Huffman.HuffmanTrie; // importando os codigos que realizam a compactação huffman
import Hash.*; // importando os codigos serão a base para a criaçao da tabela hash
import Trie.*;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        HuffmanTrie[] huffman = new HuffmanTrie[30];
        HashTable tabelaHash = new HashTable<>(30);

        Trie[] trie = new Trie[30];

        // Inicializar todas as posições do vetor
        for (int i = 0; i < trie.length; i++) {
            trie[i] = new Trie();
        }

        Scanner input = new Scanner(System.in);
        String documentos, texto, comprimida, descomprimida, opc, textoInserido;

        StringBuilder conteudoArquivos = new StringBuilder();

        File pasta;

        // leitura dos documentos para serem comprimidos
        // o usuario informa o caminho onde se encontra os arquivos
        System.out.println("Inserir documentos: ");
        // documentos = input.nextLine();
        documentos = "/home/202319040118/Documentos/Trabalho_ED-main/conveterArquivos";
        pasta = new File(documentos);

        if (pasta.exists() && pasta.isDirectory()) {
            System.out.println("Pasta encontrada. Lendo arquivos .txt");

            // lendo apenas os arquivos .txt
            File[] arquivosTxt = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

            if (arquivosTxt != null) {
                int i = 0;
                for (File arquivo : arquivosTxt) {
                    // limpando o conteudo antes de ler o novo arquivo
                    conteudoArquivos.setLength(0);

                    // lendo cada arquivo .txt
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(new FileInputStream(arquivo), "UTF-8"))) {
                        String linha;

                        while ((linha = br.readLine()) != null) {
                            conteudoArquivos.append(linha).append("\n");
                        }

                        conteudoArquivos.append("\n"); // separador entre arquivos

                        // armazenando o conteudo lido em uma string
                        texto = conteudoArquivos.toString();

                        // realizando a compressao do arquivo atual
                        huffman[i] = new HuffmanTrie(conteudoArquivos.toString());
                        comprimida = huffman[i].comprime(conteudoArquivos.toString());
                        descomprimida = huffman[i].descomprime(comprimida);

                        System.out.println("Conteudo lido do arquivo em questao: ");
                        System.out.println(conteudoArquivos.toString());

                        

                        // criado a Trie o arquivo atual
                        trie[i].insert(conteudoArquivos.toString());
                        System.out.println("Trie do arquivo em questao: ");
                        trie[i].printTrie();

                        System.out.println(trie[i].startsWith(texto));

                        // System.out.println(trie.search("boa"));
                        // System.out.println("Mensagem Comprimida: " + comprimida);
                        // System.out.println("Mensagem Descomprimida: " + descomprimida);
                        // System.out.println(huffman.getHuffmanTable());

                        System.out.println("posicao gerada pela funcao hash djb2: " + tabelaHash.hashDJB2("1"));
                        System.out.println("posicao gerada pela funcao hash divisao: " + tabelaHash.hashDivisao(comprimida, 31));

                        // OBS: COMO SERAO 30 ARQUIVOS, E SE EH PARA SER CRIADO UMA ARVORE DE HUFFMAN
                        // PARA CADA UM, DEVE
                        // SER CRIADO UM VETOR DO TIPO HuffmanTrie de tamanho 30, onde cada posicao sera
                        // para um arquivo

                        i++;

                        
                        System.out.println("Arquivo " + arquivo.getName() + " lido com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Nao foram encontrados arquivos .txt na pasta.");
            }
        } else {
            System.out.println("Erro ao inserir o caminho para leitura dos arquivos.");
        }

        if (documentos != null) {
            System.out.println("Documentos inseridos com sucesso!");
        }

        // armazenando o conteudo lido em uma string. Se for armazenar TODOS os arquivos
        // lidos em uma unica string:
        // texto = conteudoArquivos.toString();

        // usuario escolhe qual funcao de hash ele deseja usar
        System.out.println("Qual função de hashing (divisao/djb2): ");
        opc = input.nextLine();

        if (opc.equals("divisao")) {

            // realizar a indexaçao dos arquivos com a hash

            System.out.println("Documentos indexados com sucesso!\n");

            System.out.println("Buscar palavra: ");
            textoInserido = input.nextLine();
            System.out.println("funcao de hash divisao");

            // fazer algo agora
        } else if (opc.equals("djb2")) {

            // realizar a indexaçao dos arquivos com a hash

            System.out.println("Documentos indexados com sucesso!\n");

            System.out.println("Buscar palavra: ");
            textoInserido = input.nextLine();
            System.out.println("funsao de hash djb2");

            // fazer algo agora

        } else {
            System.out.println("opcao invalida!");
        }

        input.close();
    }
    // ---------------- FIM DA MAIN -------------------------------

}