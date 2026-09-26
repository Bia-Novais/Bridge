package abstracao;
import implementacao.FormatoExportacao;

public abstract class Relatorio {
    protected FormatoExportacao exportador;

    // Injeção de dependência obrigatória via construtor
    public Relatorio(FormatoExportacao exportador) {
        this.exportador = exportador;
    }

    // Método para permitir alteração dinâmica em tempo de execução
    public void setExportador(FormatoExportacao exportador) {
        this.exportador = exportador;
        System.out.println(">>> Formato de exportação alterado dinamicamente <<<");
    }

    public abstract void gerarRelatorio();
}