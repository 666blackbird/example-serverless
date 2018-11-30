package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.*;

public class Function {

    
}

@Data
@AllArgsConstructor
class Estado {
    private Long id;
    private String nome;
}

@Data
@AllArgsConstructor
class Cidade {
    private Long id;
    private String nome;
    private Estado estado;
}

class CidadeDAO {
    @FunctionName (@HttpTrigger (name = "restcreatecidade", methods = {HttpMethod.POST}, route = "cidade") "createCidadeFunction")
    public Cidade create(Cidade cidade) {
        return cidade;
    }

    @FunctionName ("readCidadesFunction")
    public List<Cidade> read(@HttpTrigger (name = "restreadcidades", methods = {HttpMethod.GET}, route = "cidade") ) {
        return Stream.of(
            new Cidade(1L, "Assaí", new Estado(1L, "Paraná")),
            new Cidade(2L, "Londrina", new Estado(1L, "Paraná")),
            new Cidade(3L, "Santo André", new Estado(2L, "São Paulo")),
            new Cidade(4L, "Rio de Janeiro", new Estado(3L, "Rio de Janeiro"))
        ).collect(Collector.toList());
    }

    @FunctionName ("updateCidadeFunction")
    public Cidade update(@HttpTrigger (name = "restupdatecidade", methods = {HttpMethod.PUT}, route = "cidade") Cidade cidade) {
        return cidade;
    }

    @FunctionName ("deleteCidadeFunction")
    public int delete(@HttpTrigger (
        name = "restcreatecidade", 
        methods = {HttpMethod.POST}, 
        route = "cidade")
        @BindingName ("id") Long id) {
            return 200;
    }
}