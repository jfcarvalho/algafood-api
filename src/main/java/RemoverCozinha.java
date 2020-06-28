
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.modelo.Cozinha;
import com.algaworks.algafood.repository.CozinhaRepository;

public class RemoverCozinha {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		Cozinha cozinha = cadastroCozinha.buscar(1L);
		cozinha.setId(3L);
		
		cadastroCozinha.remove(cozinha);
	}
	

}
