package implementacao;
import java.util.List;

public interface FormatoExportacao {
    void desenharCabecalho(String titulo);
    void desenharCorpo(List<String> dados);
    void finalizarArquivo();
}