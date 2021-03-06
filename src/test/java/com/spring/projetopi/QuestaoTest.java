package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.AlternativaController;
import com.spring.projetopi.controller.PerguntaController;
import com.spring.projetopi.controller.QuestaoController;
import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.model.Questao;

@SpringBootTest
public class QuestaoTest {
	
	@Autowired
	QuestaoController questaoController;
	
	@Autowired
	PerguntaController perguntaController;
	
	@Autowired
	AlternativaController alternativaController;
	
	@Test
	public void createQuestao() {
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste");
		
		perguntaController.save(pergunta_1);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(false);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(true);
		alternativa_2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa_2);
		
		Alternativa alternativa_3 = new Alternativa();
		
		alternativa_3.setAlternativa(3);
		alternativa_3.setCorreto(false);
		alternativa_3.setDescricao("Teste alternativa 3");
		
		alternativaController.save(alternativa_3);

		Alternativa alternativa_4 = new Alternativa();
		
		alternativa_4.setAlternativa(4);
		alternativa_4.setCorreto(false);
		alternativa_4.setDescricao("Teste alternativa 4");
		
		alternativaController.save(alternativa_4);	
		
		Alternativa alternativa_5 = new Alternativa();
		
		alternativa_5.setAlternativa(5);
		alternativa_5.setCorreto(false);
		alternativa_5.setDescricao("Teste alternativa 5");
		
		alternativaController.save(alternativa_5);
		
		List <Alternativa> alternativas = new ArrayList<Alternativa>();
		
		alternativas.add(alternativa_1);
		alternativas.add(alternativa_2);
		alternativas.add(alternativa_3);
		alternativas.add(alternativa_4);
		alternativas.add(alternativa_5);
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas);

		questaoController.save(questao_1);
		
		assertNotNull(questao_1.getQuestao_id());
		assertEquals(questao_1.getPergunta().getPergunta(), pergunta_1.getPergunta());
		
		for(int i = 0; i < questao_1.getAlternativas().size(); i++) {
			switch(i) {
			case 0:
				assertEquals(questao_1.getAlternativas().get(i).getAlternativa(), alternativa_1.getAlternativa());
				assertEquals(questao_1.getAlternativas().get(i).getDescricao(), alternativa_1.getDescricao());
				assertFalse(questao_1.getAlternativas().get(i).isCorreto());
				break;
			case 1:
				assertEquals(questao_1.getAlternativas().get(i).getAlternativa(), alternativa_2.getAlternativa());
				assertEquals(questao_1.getAlternativas().get(i).getDescricao(), alternativa_2.getDescricao());
				assertTrue(questao_1.getAlternativas().get(i).isCorreto());
				break;
			case 2:
				assertEquals(questao_1.getAlternativas().get(i).getAlternativa(), alternativa_3.getAlternativa());
				assertEquals(questao_1.getAlternativas().get(i).getDescricao(), alternativa_3.getDescricao());
				assertFalse(questao_1.getAlternativas().get(i).isCorreto());
				break;
			case 3:
				assertEquals(questao_1.getAlternativas().get(i).getAlternativa(), alternativa_4.getAlternativa());
				assertEquals(questao_1.getAlternativas().get(i).getDescricao(), alternativa_4.getDescricao());
				assertFalse(questao_1.getAlternativas().get(i).isCorreto());
				break;
			case 4:
				assertEquals(questao_1.getAlternativas().get(i).getAlternativa(), alternativa_5.getAlternativa());
				assertEquals(questao_1.getAlternativas().get(i).getDescricao(), alternativa_5.getDescricao());
				assertFalse(questao_1.getAlternativas().get(i).isCorreto());
				break;
			default:
				System.out.println("Erro");
				break;
			}
		}
	}
	
	@Test
	public void listQuestoes() {
		/* Criação das perguntas */
		Pergunta pergunta1 = new Pergunta();
		
		pergunta1.setPergunta("Pergunta Teste");
		
		perguntaController.save(pergunta1);
		
		/* Criação das alternativas */
		Alternativa alternativa1 = new Alternativa();
		
		alternativa1.setAlternativa(1);
		alternativa1.setCorreto(false);
		alternativa1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa1);

		Alternativa alternativa2 = new Alternativa();
		
		alternativa2.setAlternativa(2);
		alternativa2.setCorreto(true);
		alternativa2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa2);
		
		Alternativa alternativa3 = new Alternativa();
		
		alternativa3.setAlternativa(3);
		alternativa3.setCorreto(false);
		alternativa3.setDescricao("Teste alternativa 3");
		
		alternativaController.save(alternativa3);

		Alternativa alternativa4 = new Alternativa();
		
		alternativa4.setAlternativa(4);
		alternativa4.setCorreto(false);
		alternativa4.setDescricao("Teste alternativa 4");
		
		alternativaController.save(alternativa4);	
		
		Alternativa alternativa5 = new Alternativa();
		
		alternativa5.setAlternativa(5);
		alternativa5.setCorreto(false);
		alternativa5.setDescricao("Teste alternativa 5");
		
		alternativaController.save(alternativa5);
		
		List <Alternativa> alternativas1 = new ArrayList<Alternativa>();
		
		alternativas1.add(alternativa1);
		alternativas1.add(alternativa2);
		alternativas1.add(alternativa3);
		alternativas1.add(alternativa4);
		alternativas1.add(alternativa5);
		
		/* Criação da questão */
		Questao questao1 = new Questao();
		
		questao1.setPergunta(pergunta1);
		questao1.setAlternativas(alternativas1);

		questaoController.save(questao1);
		
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste");
		
		perguntaController.save(pergunta_1);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(false);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(true);
		alternativa_2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa_2);
		
		Alternativa alternativa_3 = new Alternativa();
		
		alternativa_3.setAlternativa(3);
		alternativa_3.setCorreto(false);
		alternativa_3.setDescricao("Teste alternativa 3");
		
		alternativaController.save(alternativa_3);

		Alternativa alternativa_4 = new Alternativa();
		
		alternativa_4.setAlternativa(4);
		alternativa_4.setCorreto(false);
		alternativa_4.setDescricao("Teste alternativa 4");
		
		alternativaController.save(alternativa_4);	
		
		Alternativa alternativa_5 = new Alternativa();
		
		alternativa_5.setAlternativa(5);
		alternativa_5.setCorreto(false);
		alternativa_5.setDescricao("Teste alternativa 5");
		
		alternativaController.save(alternativa_5);
		
		List <Alternativa> alternativas = new ArrayList<Alternativa>();
		
		alternativas.add(alternativa_1);
		alternativas.add(alternativa_2);
		alternativas.add(alternativa_3);
		alternativas.add(alternativa_4);
		alternativas.add(alternativa_5);
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas);

		questaoController.save(questao_1);
		
		List<Questao> questoes = questaoController.findAll();
		
		assertNotNull(questoes);
	}
	
	@Test
	public void findQuestaoById() {
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste");
		
		perguntaController.save(pergunta_1);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(false);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(true);
		alternativa_2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa_2);
		
		Alternativa alternativa_3 = new Alternativa();
		
		alternativa_3.setAlternativa(3);
		alternativa_3.setCorreto(false);
		alternativa_3.setDescricao("Teste alternativa 3");
		
		alternativaController.save(alternativa_3);

		Alternativa alternativa_4 = new Alternativa();
		
		alternativa_4.setAlternativa(4);
		alternativa_4.setCorreto(false);
		alternativa_4.setDescricao("Teste alternativa 4");
		
		alternativaController.save(alternativa_4);	
		
		Alternativa alternativa_5 = new Alternativa();
		
		alternativa_5.setAlternativa(5);
		alternativa_5.setCorreto(false);
		alternativa_5.setDescricao("Teste alternativa 5");
		
		alternativaController.save(alternativa_5);
		
		List <Alternativa> alternativas = new ArrayList<Alternativa>();
		
		alternativas.add(alternativa_1);
		alternativas.add(alternativa_2);
		alternativas.add(alternativa_3);
		alternativas.add(alternativa_4);
		alternativas.add(alternativa_5);
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas);

		questaoController.save(questao_1);
		
		Questao questao = questaoController.findById(questao_1.getQuestao_id());
		
		assertEquals(questao.getQuestao_id(), questao_1.getQuestao_id());
	}
}
