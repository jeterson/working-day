package com.dio.bootcamp.workingday;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import com.dio.bootcamp.workingday.model.Calendario;
import com.dio.bootcamp.workingday.model.CategoriaUsuario;
import com.dio.bootcamp.workingday.model.Empresa;
import com.dio.bootcamp.workingday.model.JornadaTrabalho;
import com.dio.bootcamp.workingday.model.Localidade;
import com.dio.bootcamp.workingday.model.Movimentacao;
import com.dio.bootcamp.workingday.model.MovimentacaoPk;
import com.dio.bootcamp.workingday.model.NivelAcesso;
import com.dio.bootcamp.workingday.model.Ocorrencia;
import com.dio.bootcamp.workingday.model.TipoData;
import com.dio.bootcamp.workingday.model.Usuario;
import com.dio.bootcamp.workingday.repositories.NivelAcessoRepository;
import com.dio.bootcamp.workingday.repositories.TipoDataRepository;
import com.dio.bootcamp.workingday.services.CalendarioService;
import com.dio.bootcamp.workingday.services.CategoriaUsuarioService;
import com.dio.bootcamp.workingday.services.EmpresaService;
import com.dio.bootcamp.workingday.services.JornadaTrabalhoService;
import com.dio.bootcamp.workingday.services.LocalidadeService;
import com.dio.bootcamp.workingday.services.MovimentacaoService;
import com.dio.bootcamp.workingday.services.OcorrenciaService;
import com.dio.bootcamp.workingday.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WorkingDayApplication implements CommandLineRunner {

	@Autowired
	private TipoDataRepository tipoDataRepository;

	@Autowired
	private CalendarioService calendarioService;

	@Autowired
	private OcorrenciaService ocorrenciaService;

	@Autowired
	private NivelAcessoRepository acessoRepository;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private LocalidadeService localidadeService;

	@Autowired
	private CategoriaUsuarioService categoriaUsuarioService;

	@Autowired
	private JornadaTrabalhoService jornadaTrabalhoService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MovimentacaoService movimentacaoService;

	public static void main(String[] args) {
		SpringApplication.run(WorkingDayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TipoData tipoDataEstadual = new TipoData();
		TipoData tipoDataNacional = new TipoData();

		tipoDataEstadual.setDescricao("ESTADUAL");
		tipoDataNacional.setDescricao("NACIONAL");
		tipoDataRepository.saveAll(Arrays.asList(tipoDataEstadual, tipoDataNacional));

		Ocorrencia oc = new Ocorrencia(null, "Efe de Xis", "f(x) = x * 0.1");
		ocorrenciaService.save(oc);

		NivelAcesso acesso = new NivelAcesso(null, "ADMIN");
		acessoRepository.save(acesso);

		Empresa empresa = new Empresa(null, "Agiotas Banking", "123456789", "DIO", "DIO", "Cacoal", "RO", "852356");
		empresaService.save(empresa);

		Localidade localidade = new Localidade(null, acesso);
		localidadeService.save(localidade);

		CategoriaUsuario categoria = new CategoriaUsuario(null, "Parceiro");
		categoriaUsuarioService.save(categoria);

		JornadaTrabalho jornadaTrabalho = new JornadaTrabalho(null, "Periodo Integral");
		jornadaTrabalhoService.save(jornadaTrabalho);

		Usuario usuario = new Usuario(null, "Jeterson", categoria, empresa, acesso, jornadaTrabalho, BigDecimal.valueOf(5), LocalDateTime.now(), LocalDateTime.now());
		usuarioService.save(usuario);

		calendarioService.importarFeriadosNacionais();

		MovimentacaoPk id = new MovimentacaoPk(Long.parseLong("1"), usuario.getId());
		Movimentacao mov = new Movimentacao(id, "Normal", LocalDateTime.now(), null, BigDecimal.valueOf(1), oc, new Calendario(Long.parseLong("1"), null, null, null));
		movimentacaoService.save(mov);
	
		

	}

}
