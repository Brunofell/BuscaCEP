import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Cria aplicação para consultar a API ****FEITO
    //Menu para o usuário informar o CEP
    //Geração de arquivo .json com os dados do endereço


    // https://viacep.com.br/ws/82650020/json/

    public static void main(String[] args){
        ConsultaCEP cep = new ConsultaCEP();
        Scanner sc = new Scanner(System.in);

        System.out.println("••••••••CONSULTAR CEP•••••••");
        System.out.println("• PESQUISAR CEP    [1]     •");
        System.out.println("• SAIR             [0]     •");
        System.out.println("••••••••••••••••••••••••••••");
        while (true){
            System.out.print("• Digite uma opção: ");
            int opcao = sc.nextInt();

            if(opcao == 1){
                try {
                    System.out.print("• Digite o CEP: ");
                    String selectCep = sc.next();
                    System.out.println(" ");
                    Endereco meuCep = cep.buscaEndereco(selectCep);
                    System.out.println(meuCep);
                    GerarArquivo gerador = new GerarArquivo();
                    gerador.salvaArquivo(meuCep);
                    break;
                }catch (RuntimeException | IOException e){
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando a aplicação.");
                }
            }if(opcao == 0){
                System.out.println("Finalizando a aplicação.");
                break;
            }else{
                System.out.println("Digite uma opção válida!");
            }
        }
    }
}

