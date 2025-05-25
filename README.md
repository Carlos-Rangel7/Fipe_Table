# Consulta à Tabela FIPE - API Spring Boot

Aplicação Java Spring Boot que consome a API pública da Tabela FIPE para consultar valores de veículos (carros, motos e caminhões). Permite listar marcas, modelos e valores dos veículos por ano de fabricação.

---

## Funcionalidades

- Consulta de marcas de veículos (carros, motos, caminhões)
- Listagem de modelos por marca
- Consulta de valores por ano de fabricação

---

## Tecnologias Utilizadas

- Java 21  
- Spring Boot 3.5.0  
- Maven  
- IntelliJ IDEA  
- API pública da Tabela FIPE

---

## Exemplos de Consulta

### Lista de Marcas (exemplo)

```text
Dados[codigo=46, nome=Plymouth]
Dados[codigo=47, nome=Porsche]
Dados[codigo=48, nome=Renault]
...
Dados[codigo=59, nome=VW - VolksWagen]

Dados[codigo=8776, nome=X7 XDRIVE 50i M Sport 4.4 V8 Bi-TB Aut.]
Dados[codigo=246, nome=Z3 2.8 Aut.]
Dados[codigo=247, nome=Z3 2.8 Mec.]
...
Dados[codigo=253, nome=Z8 5.0 V8]

Veiculo[valor=R$ 78.183,00, marca=BMW, modelo=X1 SDRIVE 181 2.0 10V 4x2 Aut., ano=2014, combustível=Gasolina]
Veiculo[valor=R$ 68.964,00, marca=BMW, modelo=X1 SDRIVE 181 2.0 10V 4x2 Aut., ano=2013, combustível=Gasolina]
Veiculo[valor=R$ 64.173,00, marca=BMW, modelo=X1 SDRIVE 181 2.0 10V 4x2 Aut., ano=2012, combustível=Gasolina]


