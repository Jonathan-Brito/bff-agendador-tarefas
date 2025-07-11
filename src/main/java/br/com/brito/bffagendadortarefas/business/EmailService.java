package br.com.brito.bffagendadortarefas.business;

import br.com.brito.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import br.com.brito.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }
}
