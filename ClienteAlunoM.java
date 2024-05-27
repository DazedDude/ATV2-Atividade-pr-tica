import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteAlunoM {

    public static void main(String[] args) {
        String mensagemDoProfessor = "MjAwOA=="; 

        try { 
           
            Socket meuSocket = new Socket("10.130.129.103", 12345); 

            PrintWriter escritor = new PrintWriter(meuSocket.getOutputStream(), true);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(meuSocket.getInputStream()));

            escritor.println(mensagemDoProfessor);

            String respostaDoServidor = leitor.readLine();
            System.out.println("O professor respondeu: " + respostaDoServidor);

            leitor.close();
            escritor.close();
            meuSocket.close();

        } catch (Exception e) {
           
            System.out.println("Ops, deu erro! " + e.getMessage());
        }
    }
}