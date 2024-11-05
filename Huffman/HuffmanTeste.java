package Huffman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class HuffmanTeste {
    public static void main(String[] args) {
        HuffmanTrie huffman;
        Scanner input = new Scanner(System.in);
        String documentos, texto, comprimida, descomprimida, opc, textoInserido;
        StringBuilder conteudoArquivo = new StringBuilder();


        // leitura dos documentos para serem comprimidos
        // o usuario informa o caminho onde se encontra os arquivos
        System.out.println("Inserir documentos: ");
        documentos = input.nextLine();
        if(documentos != null){
            System.out.println("Documentos inseridos com sucesso!");
        }

        // realizando a leitura dos arquivos .txt
        // C:/Users/jhona/OneDrive/Faculdade/Trabalho_ED/conveterArquivos/result_arquivo2.txt
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(documentos),
                "UTF-8"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudoArquivo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(conteudoArquivo != null){

        }
        // armazenando o conteudo lido em uma string
        texto = conteudoArquivo.toString();

        // realizando a compressao dos arquivos
        huffman = new HuffmanTrie(texto);
        comprimida = huffman.comprime(texto);
        descomprimida = huffman.descomprime(comprimida);

        System.out.println("Mensagem Comprimida: " + comprimida);
        System.out.println("Mensagem Descomprimida: " + descomprimida);
        System.out.println(huffman.getHuffmanTable());

        // usuario escolhe qual funcao de hash ele deseja usar
        System.out.println("Qual função de hashing (divisao/djb2): ");
        opc = input.nextLine();

        if(opc.equals("divisao")){

            // realizar a indexaçao dos arquivos com a hash
            
            System.out.println("Documentos indexados com sucesso!\n");

            System.out.println("Buscar palavra: ");
            textoInserido = input.nextLine();
            System.out.println("funcao de hash divisao");

            // fazer algo agora
        }
        else if(opc.equals("djb2")){
            
            // realizar a indexaçao dos arquivos com a hash
            
            System.out.println("Documentos indexados com sucesso!\n");

            System.out.println("Buscar palavra: ");
            textoInserido = input.nextLine();
            System.out.println("funsao de hash djb2");

            // fazer algo agora

        }else{
            System.out.println("opcao invalida!");
        }



        input.close();
    }
    // ---------------- FIM DA MAIN -------------------------------




      // primeira funcao hash
      public int hashDivisao(String texto, int M) {
        int soma = 0;
        for (char c : texto.toCharArray()) {
            soma += (int) c;
        }
    return soma % M;
    }



    // segunda funcao hash
    public int hashDJB2(String texto) {
        long hash = 5381;
        for (char c : texto.toCharArray()) {
            hash = ((hash << 5) + hash) + c; // hash * 33 + c
        }
        return (int) (hash % Integer.MAX_VALUE);
    }

}
