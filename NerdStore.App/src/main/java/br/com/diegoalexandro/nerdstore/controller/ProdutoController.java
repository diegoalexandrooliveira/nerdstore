package br.com.diegoalexandro.nerdstore.controller;

import br.com.diegoalexandro.nerdstore.IProdutoRepository;
import br.com.diegoalexandro.nerdstore.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final IProdutoRepository produtoRepository;


    @GetMapping
    public ResponseEntity<List<Produto>> buscaTodos() {
        return ResponseEntity.ok(produtoRepository.recuperaTodos());
    }

}
