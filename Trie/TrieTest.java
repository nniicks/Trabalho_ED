package Trie;

import java.io.File;
import java.util.Scanner;

public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();  // Criando a instância da Trie

        String documentos, texto;
        StringBuilder conteudoArquivos = new StringBuilder();
        File pasta;

        // Caminho onde os arquivos estão localizados
        System.out.println("Inserir documentos: ");
        // O caminho é hardcoded aqui, mas você pode pegar isso via Scanner se preferir
        documentos = "C:/Users/jhona/OneDrive/Faculdade/Trabalho_ED/conveterArquivos";
        pasta = new File(documentos);

        if (pasta.exists() && pasta.isDirectory()) {
            System.out.println("Pasta encontrada. Lendo arquivos .txt");

            // Lendo apenas os arquivos .txt
            File[] arquivosTxt = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

            if (arquivosTxt != null) {
                for (File arquivo : arquivosTxt) {
                    // Limpando o conteúdo antes de ler o novo arquivo
                    conteudoArquivos.setLength(0);

                    // Lendo cada arquivo .txt palavra por palavra
                    try (Scanner scanner = new Scanner(arquivo, "UTF-8")) {
                        while (scanner.hasNext()) {
                            // Lê a próxima palavra
                            String palavra = scanner.next();
                            System.out.println("Palavra lida: " + palavra);
                            conteudoArquivos.append(palavra).append(" "); // Adiciona a palavra no conteúdo
                            
                            // Inserindo a palavra na Trie
                            trie.insert(palavra);
                            System.out.println("AAAAAAAAAAAAARVOREEEEEEEEEEEEEEEEEEEEEEEE");
                            trie.printTrie();
                        }

                        System.out.println("Testando a Trie após leitura dos arquivos:");
                        System.out.println("Buscar palavra 'palavra': " + trie.search(conteudoArquivos.toString())); // true se inserido
                        System.out.println("Buscar palavras começando com 'pal': " + trie.startsWith("ola")); // true
                        System.out.println("Buscar palavra 'pala': " + trie.search("pala"));    // false se não inserido

                        conteudoArquivos.append("\n"); // Separador entre arquivos
                    } catch (Exception e) {
                        System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Não foram encontrados arquivos .txt na pasta.");
            }

            // Testes com a Trie
       
        } else {
            System.out.println("Erro ao inserir o caminho para leitura dos arquivos.");
        }
    }
}