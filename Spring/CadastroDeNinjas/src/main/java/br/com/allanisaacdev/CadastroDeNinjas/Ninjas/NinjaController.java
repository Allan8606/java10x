package br.com.allanisaacdev.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem-vindo ao Cadastro de Ninjas!";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso!";
    }

    //Procurar todos os Ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosOSNinjas() {
        return "Todos os ninjas foram encontrados!";
    }

    //Mostrar Nnja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOSNinjasPorId() {
        return "Ninja encontrado pelo ID!";
    }

    //Alterar Dados do Ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Ninja alterado com sucesso!";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado com sucesso!";
    }



}
