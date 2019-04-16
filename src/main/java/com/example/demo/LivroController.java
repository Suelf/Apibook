package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;


@RestController
@RequestMapping("/Livro")
public class LivroController {
    public static ArrayList<String> Budega = new ArrayList<>();

    //Adicionar Livro
    @PostMapping( path = "/add")
    public ResponseEntity<LivroController> insert(@Valid @RequestBody Livro nLivro) {
        Livro livro = new Livro();
        livro.setNome(nLivro.getNome());
        livro.setAutor(nLivro.getAutor());
        livro.setEdicao(nLivro.edicao);
        Budega.add(livro.getNome());
        return new ResponseEntity(livro, HttpStatus.OK);
    }

    @GetMapping( path = "Buscar/{nome}")
    //buscar livro
    public ResponseEntity<LivroController> BuscarrLivro(@PathParam("nome") String nome) {
        for (int i = 0; i < Budega.size(); i++) {
            if (Budega.get(i).equals(nome)) {
                Budega.get(i);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    //Deletar Livro
    @GetMapping(path = "Delete/{nome}")
    public ResponseEntity<LivroController> DeletarLivro(@PathParam("nome") String nome) {
        for (int i = 0; i < Budega.size(); i++) {
            if (Budega.get(i).equals(nome)) {
                Budega.remove(i);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    //Editar
    @PutMapping(path = "Editar")
    public ResponseEntity<LivroController> edit(String livroN){

        String array[] = livroN.split(";");
        String nomeAntigo = array[0];
        String nomeNovo = array[1];

        for (int i = 0; i < Budega.size(); i++) {
            if (Budega.get(i).equals(nomeAntigo)) {
                Budega.set(i, nomeNovo);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping(path = "/Listar")
    public ResponseEntity<LivroController> list(){
        for (int i = 0; i < Budega.size(); i++){
            Budega.get(i);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
