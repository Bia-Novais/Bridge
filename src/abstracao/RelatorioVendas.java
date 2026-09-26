package abstracao;
import implementacao.FormatoExportacao;
import java.util.Arrays;
import java.util.List;

public class RelatorioVendas extends Relatorio {
    public RelatorioVendas(FormatoExportacao exportador) {
        super(exportador);
    }

    @Override
    public void gerarRelatorio() {
        List<String> dados = Arrays.asList("Vendas Q1: R$ 50.000", "Vendas Q2: R$ 75.000");
        exportador.desenharCabecalho("Relatório de Vendas - 2026");
        exportador.desenharCorpo(dados);
        exportador.finalizarArquivo();
    }
}