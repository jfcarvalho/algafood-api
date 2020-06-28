import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.modelo.Cozinha;
import com.algaworks.algafood.persistence.CadastroCozinha;

public class ConsultaCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		cozinhas.forEach(cozinha -> System.out.println(cozinha.getNome()));
		
	}
	

}
