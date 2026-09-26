package abstracao;
import implementacao.FormatoExportacao;
import java.util.Arrays;
import java.util.List;

public class RelatorioRH extends Relatorio {
    public RelatorioRH(FormatoExportacao exportador) {
        super(exportador);
    }

    @Override
    public void gerarRelatorio() {
        List<String> dados = Arrays.asList("Turnover: 3.2%", "Novas Vagas: 12");
        exportador.desenharCabecalho("Relatório de Desempenho de RH");
        exportador.desenharCorpo(dados);
        exportador.finalizarArquivo();
    }
}