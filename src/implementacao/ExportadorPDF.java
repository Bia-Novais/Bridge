package implementacao;
import java.util.List;

public class ExportadorPDF implements FormatoExportacao {
    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("[PDF] Renderizando Cabeçalho: " + titulo);
    }
    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[PDF] Renderizando Corpo com quebra de página:");
        dados.forEach(dado -> System.out.println("  - " + dado));
    }
    @Override
    public void finalizarArquivo() {
        System.out.println("[PDF] Arquivo gerado: relatorio.pdf\n");
    }
}