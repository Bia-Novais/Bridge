# Padrão Bridge: Aplicado ao caso de emissão de relatórios

Usamos o padrão Bridge, que faz parte do grupo de padrões estruturais, para solucionar o seguinte problema:

A equipe de engenharia de um sistema de inteligência de negócios TechFatec precisa expandir o módulo de relatórios. O sistema legado gera exclusivamente o "Relatório de Vendas" no formato "PDF". O novo requisito exige a inclusão do "Relatório de Desempenho de RH", estipulando que todos os relatórios (atuais e futuros) devem ser exportáveis para PDF, Excel (XLSX) e HTML. A diretriz arquitetural requer a aplicação do Padrão Bridge para prevenir a explosão de subclasses e aderir ao Princípio Aberto/Fechado do SOLID. 

Esse padrão se torna muito útil a partir do momento em que separamos o **"o que"** do **"como"**. 

A criação de relatórios é a nossa regra de negócio, a **parte abstrata**, onde podem surgir novas formatações de conteúdo. Já o formato em que o arquivo deve sair é a nossa **parte de implementação**. 

Com isso definido, elaboramos nosso diagrama de classes e de sequência para mapear visualmente a aplicação antes de codificar a solução.

## Diagrama de Classes

Este diagrama representa bem a separação entre a Abstração (nosso "o que") e a Implementação (nosso "como").

```mermaid
classDiagram
    %% Lado da Implementação (Implementor)
    class FormatoExportacao {
        <<interface>>
        +desenharCabecalho(titulo: String)
        +desenharCorpo(dados: List~String~)
        +finalizarArquivo()
    }

    class ExportadorPDF {
        +desenharCabecalho(titulo: String)
        +desenharCorpo(dados: List~String~)
        +finalizarArquivo()
    }

    class ExportadorExcel {
        +desenharCabecalho(titulo: String)
        +desenharCorpo(dados: List~String~)
        +finalizarArquivo()
    }

    class ExportadorHTML {
        +desenharCabecalho(titulo: String)
        +desenharCorpo(dados: List~String~)
        +finalizarArquivo()
    }

    FormatoExportacao <|.. ExportadorPDF
    FormatoExportacao <|.. ExportadorExcel
    FormatoExportacao <|.. ExportadorHTML

    %% Lado da Abstração (Abstraction)
    class Relatorio {
        <<abstract>>
        #exportador: FormatoExportacao
        +Relatorio(exportador: FormatoExportacao)
        +gerarRelatorio()*
    }

    class RelatorioVendas {
        +RelatorioVendas(exportador: FormatoExportacao)
        +gerarRelatorio()
    }

    class RelatorioRH {
        +RelatorioRH(exportador: FormatoExportacao)
        +gerarRelatorio()
    }

    Relatorio <|-- RelatorioVendas
    Relatorio <|-- RelatorioRH

    %% Relacionamento Bridge (Agregação)
    Relatorio o--> FormatoExportacao : usa
