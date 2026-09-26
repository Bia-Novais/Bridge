package implementacao;
import java.util.List;

public class ExportadorHTML implements FormatoExportacao {
    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("[HTML] <h1>" + titulo + "</h1>");
    }
    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[HTML] <ul>");
        dados.forEach(dado -> System.out.println("  <li>" + dado + "</li>"));
        System.out.println("[HTML] </ul>");
    }
    @Override
    public void finalizarArquivo() {
        System.out.println("[HTML] Arquivo gerado: index.html\n");
    }
}