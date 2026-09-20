# Bridge
Padrão de modelagem de projetos Bridge

@startuml
skinparam classAttributeIconSize 0

' Lado da Implementação (Implementor)
interface FormatoExportacao {
    + desenharCabecalho(titulo: String): void
    + desenharCorpo(dados: List<String>): void
    + finalizarArquivo(): void
}

class ExportadorPDF {
    + desenharCabecalho(titulo: String): void
    + desenharCorpo(dados: List<String>): void
    + finalizarArquivo(): void
}

class ExportadorExcel {
    + desenharCabecalho(titulo: String): void
    + desenharCorpo(dados: List<String>): void
    + finalizarArquivo(): void
}

class ExportadorHTML {
    + desenharCabecalho(titulo: String): void
    + desenharCorpo(dados: List<String>): void
    + finalizarArquivo(): void
}

FormatoExportacao <|.. ExportadorPDF
FormatoExportacao <|.. ExportadorExcel
FormatoExportacao <|.. ExportadorHTML

' Lado da Abstração (Abstraction)
abstract class Relatorio {
    # exportador: FormatoExportacao
    + Relatorio(exportador: FormatoExportacao)
    + {abstract} gerarRelatorio(): void
}

class RelatorioVendas {
    + RelatorioVendas(exportador: FormatoExportacao)
    + gerarRelatorio(): void
}

class RelatorioRH {
    + RelatorioRH(exportador: FormatoExportacao)
    + gerarRelatorio(): void
}

Relatorio <|-- RelatorioVendas
Relatorio <|-- RelatorioRH

' Relacionamento Bridge (Agregação/Associação)
Relatorio o--> FormatoExportacao : usa >

@enduml

Detalhes do Diagrama de Classes:

Diagrama de Sequência

@startuml
autonumber
actor Cliente as Main
participant "relatorioVendas:\nRelatorioVendas" as Rel
participant "exportadorPDF:\nExportadorPDF" as Exp

Main -> Rel : RelatorioVendas(exportadorPDF)
note right: Injeção de Dependência (Bridge)

Main -> Rel : gerarRelatorio()
activate Rel

Rel -> Exp : desenharCabecalho("Relatório de Vendas")
activate Exp
Exp --> Rel : ok
deactivate Exp

Rel -> Exp : desenharCorpo(dadosVendas)
activate Exp
Exp --> Rel : ok
deactivate Exp

Rel -> Exp : finalizarArquivo()
activate Exp
Exp --> Rel : ok
deactivate Exp

Rel --> Main : Arquivo gerado com sucesso
deactivate Rel

@enduml
