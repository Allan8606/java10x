package br.com.allanisaacdev.CadastroDeNinjas.Missoes;


import br.com.allanisaacdev.CadastroDeNinjas.Ninjas.NinjaRepository;
import br.com.allanisaacdev.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Mostrar Missar por ID
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    //Criar Missão
    public MissoesDTO criarMissao(MissoesDTO missao){
        MissoesModel missaoModel = missoesMapper.map(missao);
        missaoModel = missoesRepository.save(missaoModel);
        MissoesDTO missaDTORetorno = missoesMapper.map(missaoModel);
        return missaDTORetorno;
    }

    //Deletar Missão
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    //Atualizar Missao por ID
    public MissoesModel atualizaMissao(Long id, MissoesModel missaoAtualizada){
        if (missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return  missoesRepository.save(missaoAtualizada);
        }
        return null;
    }









}
