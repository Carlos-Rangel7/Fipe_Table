package com.rangeldev.FipeTable.principal;

import com.rangeldev.FipeTable.model.Dados;
import com.rangeldev.FipeTable.model.Modelos;
import com.rangeldev.FipeTable.model.Veiculo;
import com.rangeldev.FipeTable.service.ConsumoAPI;
import com.rangeldev.FipeTable.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    private ConverteDados converso = new ConverteDados();

    ConsumoAPI consumo = new ConsumoAPI();

    public void exibirMenu() {
        var menu = """
                *** Opções ***
                Carro
                Moto
                Caminhão
                
                Digite uma Opção para consulta
                """;
        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if(opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if(opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var marcas = converso.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o codigo da marca para consulta: ");
        var codigoMarca = leitura.nextInt();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json  = consumo.obterDados(endereco);
        var modeloLista = converso.obterDados(json, Modelos.class);

        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro");
        var nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrado = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        modelosFiltrado.forEach(System.out::println);

        System.out.println("Digite o codigo do modelo para buscar os valores das avaliações");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);

        List<Dados> anos = converso.obterLista(json, Dados.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for(int i =0; i < anos.size(); i++) {
            var enderecosAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecosAnos);
            Veiculo veiculo = converso.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);


    }

}
