package implementacao;
import java.util.List;

public class ExportadorExcel implements FormatoExportacao {
    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("[EXCEL] Planilha - Linha 1 (Negrito): " + titulo);
    }
    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[EXCEL] Preenchendo células:");
        dados.forEach(dado -> System.out.println("  | " + dado + " |"));
    }
    @Override
    public void finalizarArquivo() {
        System.out.println("[EXCEL] Arquivo gerado: relatorio.xlsx\n");
    }
}