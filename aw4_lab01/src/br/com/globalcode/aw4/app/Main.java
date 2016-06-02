package br.com.globalcode.aw4.app;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;

import br.com.globalcode.aw4.db.DataManager;
import br.com.globalcode.aw4.model.RegistroAtendimento;
import br.com.globalcode.aw4.util.Teclado;

public class Main {
    private static SessionFactory sf;

    public static void main(String[] args) {
	System.out.println("obtendo SessionFactory...");
	sf = DataManager.getSessionFactory();
	System.out.println("...SessionFactory obtida.");
	try {
	    while (true) {
		System.out.println(linha);
		System.out.println("1 - Registrar duvida");
		System.out.println("2 - Listar atendimentos pendentes");
		System.out.println("3 - Responder duvida");
		System.out.println("0 - Terminar");
		System.out.println(linha);
		System.out.println("digite uma opcao: ");
		String strOpcao = Teclado.le();
		char opcao = strOpcao.length() > 0 ? strOpcao.charAt(0) : 'x';
		switch (opcao) {
		case '1':
		    registrarDuvida();
		    break;
		case '2':
		    listarDuvidasPendentes();
		    break;
		case '3':
		    responderDuvida();
		    break;
		case '0':
		    System.out.println("encerrando aplicacao...");
		    return;
		default:
		    System.out.println("opcao invalida");
		    break;
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    System.out.println("fechando SessionFactory...");
	    if (sf != null && !sf.isClosed()) {
		sf.close();
		System.out.println("SessionFactory fechada.");
	    } else {
		System.out
			.println("Atencao: SessionFactory nula ou fechada anteriormente.");
	    }
	}
    }

    private static void responderDuvida() {
	System.out.println("Respondendo a duvida ...");
	DataManager gerenciadorPersitencia = new DataManager(sf);
	System.out.println("Digite o id do atendimento: ");
	Integer id = null;
	try {
	    id = new Integer(Teclado.le());
	} catch (NumberFormatException numberFormatException) {
	    System.out.println("id invalido");
	    return;
	}
	RegistroAtendimento regAtendimento = gerenciadorPersitencia
		.getAtendimentoById(id);
	if (regAtendimento == null) {
	    System.out
		    .println("o id informado nao corresponde a um atendimento pendente");
	    return;
	}
	System.out.println(regAtendimento);
	System.out.println("Resposta: ");
	String resposta = Teclado.le();
	regAtendimento.setTextoResposta(resposta);
	regAtendimento.setDataResposta(new Date());
	gerenciadorPersitencia.update(regAtendimento);
	System.out.println("... duvida respondida");
    }

    private static void listarDuvidasPendentes() {
	System.out.println("recuperando atendimentos pendentes...");
	DataManager gerenciadorPersitencia = new DataManager(sf);
	List<RegistroAtendimento> lista = gerenciadorPersitencia
		.getAtendimentosPendentes();
	System.out.println(linha + linha + linha + linha);
	for (Iterator<RegistroAtendimento> iter = lista.iterator(); iter
		.hasNext();) {
	    System.out.println(iter.next());
	}
	System.out.println(linha + linha + linha + linha);
	System.out.println();
    }

    private static void registrarDuvida() {
	System.out.println(linha);
	System.out.println("Registrando duvida");
	System.out.println("email: ");
	String email = Teclado.le();
	System.out.println("duvida: ");
	String textoDuvida = Teclado.le();
	Date agora = new Date();
	System.out.println("Data atual: " + agora);
	RegistroAtendimento regAtendimento = new RegistroAtendimento();
	regAtendimento.setEmailVisitante(email);
	regAtendimento.setTextoDuvida(textoDuvida);
	regAtendimento.setDataRegistro(agora);
	(new DataManager(sf)).create(regAtendimento);
	System.out.println("duvida registrada: " + regAtendimento.getId());
    }

    private static final String linha = "=============================";
}
