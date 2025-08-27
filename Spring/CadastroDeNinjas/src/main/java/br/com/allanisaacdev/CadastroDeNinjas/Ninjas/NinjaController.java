package br.com.allanisaacdev.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem-vindo ao Cadastro de Ninjas!";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaModel) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninjaModel);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso! Nome: " + ninjaDTO.getNome());
    }

    //Procurar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOSNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar Nnja por ID (READ)
    @GetMapping("/listar/{id}") //O @PathVariable é usado para extrair o valor do ID da URL
    public NinjaDTO listarNinjasPorId(@PathVariable Long id) {
     return ninjaService.listarNinjasPorId(id);
    }

    //Alterar Dados do Ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso! O ninja foi");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja não encontrado, impossível deletar!");



    }



}
