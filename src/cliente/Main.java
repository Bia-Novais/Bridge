package cliente;
import abstracao.*;
import implementacao.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA DE RELATÓRIOS TECHFATEC ---\n");

        System.out.println("1. GERANDO RELATÓRIO DE VENDAS EM PDF...");
        FormatoExportacao pdf = new ExportadorPDF();
        Relatorio relatorioVendas = new RelatorioVendas(pdf); // Injeção via construtor
        relatorioVendas.gerarRelatorio();

        System.out.println("2. ALTERANDO FORMATO DO MESMO RELATÓRIO PARA EXCEL...");
        FormatoExportacao excel = new ExportadorExcel();
        relatorioVendas.setExportador(excel); // Alteração dinâmica
        relatorioVendas.gerarRelatorio();

        System.out.println("3. GERANDO RELATÓRIO DE RH EM HTML...");
        FormatoExportacao html = new ExportadorHTML();
        Relatorio relatorioRH = new RelatorioRH(html); // Injeção via construtor
        relatorioRH.gerarRelatorio();
    }
}