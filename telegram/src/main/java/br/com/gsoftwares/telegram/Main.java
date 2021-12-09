/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsoftwares.telegram;

import br.com.gsoftwares.telegram.model.Cidade;
import br.com.gsoftwares.telegram.model.Cliente;
import br.com.gsoftwares.telegram.model.Menu;
import br.com.gsoftwares.telegram.model.Servicos;
import br.com.gsoftwares.telegram.util.Environment;
import br.com.gsoftwares.telegram.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class Main {

    private static String msg;
    private static final String URL_BASE = Environment.DEV.url();
    private static final String URL_SERVICO = URL_BASE + "servico";
    private static final String URL_CLIENTE = URL_BASE + "cliente";

    private static TelegramBot bot;
    private static BaseResponse baseResponse;
    private static SendResponse sendResponse;

    private static boolean acessoMenu = false;
    private static boolean acessoMenuOpcoes = false;
    private static Boolean acessoCadastroCliente = false;
    private static boolean acessoCadastroServico = false;

    public static void main(String[] args) {

        //Criação do objeto bot com as informações de acesso
        bot = new TelegramBot("2031469018:AAHmndiv8Ek8cz1aVKinn12SZ7FQduZy64M");

        //objeto responsável por receber as mensagens
        GetUpdatesResponse updatesResponse;
        //objeto responsável por gerenciar o envio de respostas
        //SendResponse sendResponse;
        //objeto responsável por gerenciar o envio de ações do chat
        //BaseResponse baseResponse;

        String mensagemRetorno = "Não entendi.....";

        //controle de off-set, isto é, a partir deste ID será lido as mensagens pendentes na fila
        int m = 0;

        //loop infinito pode ser alterado por algum timer de intervalo curto
        while (true) {

            //executa comando no Telegram para obter as mensagens pendentes a partir de um off-set (limite inicial)
            updatesResponse = bot.execute(new GetUpdates().limit(100).offset(m));

            //lista de mensagens
            List<Update> updates = updatesResponse.updates();

            //análise de cada ação da mensagem
            for (Update msgUser : updates) {

                //atualização do off-set
                m = msgUser.updateId() + 1;

                System.out.println("Recebendo mensagem: " + msgUser.message().chat().username() + " - " + msgUser.message().text());

                boolean primeiraMsg = msgUser.message().messageId() == 1;
                Chat userName = msgUser.message().chat();

                if (acessoMenu == false || msgUser.message().text().trim().equalsIgnoreCase("menu")) {
                    Menu respMenu = chamaMenu(primeiraMsg, msgUser.message().text().trim(), userName);
                    mensagemRetorno = respMenu.getMensagem();
                    enviaRespostaCliente(msgUser, ChatAction.typing.name(), mensagemRetorno);
                }

                if (acessoMenu == true && acessoMenuOpcoes == true && acessoCadastroCliente == true) {

                    try {
                        Menu respMenu = chamaCadastroCliente(msgUser.message().text().trim(), userName);
                        mensagemRetorno = respMenu.getMensagem();
                        enviaRespostaCliente(msgUser, ChatAction.typing.name(), mensagemRetorno);
                        acessoMenu = false;
                        acessoMenuOpcoes = false;
                        acessoCadastroCliente = false;
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                if (acessoMenu == true && acessoMenuOpcoes == true && acessoCadastroServico == true) {
                    Menu respMenu = chamaCadastroServico(msgUser.message().text().trim(), userName);
                    mensagemRetorno = respMenu.getMensagem();
                    enviaRespostaCliente(msgUser, ChatAction.typing.name(), mensagemRetorno);

                }

                if (msgUser.message().text().trim().equalsIgnoreCase("sair") || msgUser.message().text().trim().equalsIgnoreCase("exit")) {
                    mensagemRetorno = "Atendimento finalizado";
                    enviaRespostaCliente(msgUser, ChatAction.typing.name(), mensagemRetorno);
                    acessoMenu = false;
                    acessoMenuOpcoes = false;
                    acessoCadastroCliente = false;
                }

                if (acessoMenu == true && acessoMenuOpcoes == false) {
                    String userMsg = msgUser.message().text().trim();
                    if (StringUtils.isNumeric(userMsg)) {
                        switch (userMsg) {
                            case "1":
                                Menu respMenu1 = chamaMenuCadCliente(userMsg, userName);
                                mensagemRetorno = respMenu1.getMensagem();
                                enviaRespostaCliente(msgUser, ChatAction.typing.name(), mensagemRetorno);
                                acessoMenuOpcoes = true;
                                break;
                            case "2":

                                break;
                            case "3":
                                Menu respMenu2 = chamaMenuServico(userMsg, userName);
                                mensagemRetorno = respMenu2.getMensagem();
                                enviaRespostaCliente(msgUser, ChatAction.typing.name(), mensagemRetorno);
                                acessoMenuOpcoes = true;
                                break;

                            case "4":
                                mensagemRetorno = "Atendimento finalizado";
                                enviaRespostaCliente(msgUser, ChatAction.typing.name(), mensagemRetorno);
                                acessoMenu = false;
                                acessoMenuOpcoes = false;
                                acessoCadastroCliente = false;
                                break;
                        }
                    }
                }

            }
        }
    }

    private static String criar_resposta(Update msgUser, boolean primeiraMsg) {
        try {
            String mensagem = msgUser.message().text();

            if (primeiraMsg == true || mensagem.equalsIgnoreCase("menu")) {

                msg = "Olá bem vindo a CarWash. Digite o numero do serviço desejado!\n";
                msg += informaServicos();
                acessoMenu = true;

            } else if (acessoMenu == false) {
                msg = "Olá vejo que não é novo por aqui, Digite menu para verificar as opções!\n";
                //msg += informaServicos();
                //token = true;
            }

            if (acessoMenu == true) {

                if (StringUtils.isNumeric(mensagem)) {
                    msg = "Você selecionou " + informaServicosPorID(mensagem) + ", Deseja Confirmar(s/n)";
                }

                if (mensagem.equalsIgnoreCase("s") || mensagem.equalsIgnoreCase("sim")) {
                    msg = "Serviço agendado";
                    acessoMenu = false;
                } else if (mensagem.equalsIgnoreCase("n") || mensagem.equalsIgnoreCase("nao")) {
                    msg = "Deseja verificar o menu novamente?\nDigite menu";
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            msg = "estamos com algum problema, por favor aguarde...";
        }

        return msg;
    }

    private static String informaServicos() throws Exception {
        String lista = "";

        HttpGet get = new HttpGet(URL_SERVICO);
        String resposta = Util.enviaRequest(get);
        List<Servicos> servicoList = Arrays.asList(Util.jsonToObject(resposta, Servicos[].class));
        lista = servicoList.stream().map(s -> String.valueOf(s.getIdServico()) + " - " + s.getNomeServico() + "\n").reduce(lista, String::concat);

        return lista;

    }

    private static String informaServicosPorID(String id) throws Exception {
        String lista = "";

        HttpGet get = new HttpGet(URL_SERVICO + "/" + id);
        String resposta = Util.enviaRequest(get);
        List<Servicos> servicoList = Arrays.asList(Util.jsonToObject(resposta, Servicos.class));
        lista = servicoList.stream().map(s -> s.getNomeServico()).reduce(lista, String::concat);

        return lista;

    }

    private static Menu chamaMenu(boolean primeiraMsg, String mensagem, Chat user) {
        if (primeiraMsg == true || mensagem.equalsIgnoreCase("menu")) {

            msg = "Bem vindo a CarWash. Digite o numero da opção desejada!\n";
            msg += "1 - Cadastro Cliente\n"
                    + "2 - Cadastro de Veiculo\n"
                    + "3 - Agendamento\n"
                    + "4 - Sair do Atendimento";
            acessoMenu = true;

        } else if (acessoMenu == false) {
            msg = "Olá " + user.firstName().trim() + " " + user.lastName().trim() + ", vejo que já não é novo por aqui, Digite o comando ( menu ) para verificar as opções!\n";
        }

        return new Menu(acessoMenu, msg);
    }

    private static Menu chamaMenuServico(String userMsg, Chat userName) {
        try {
            msg = "Segue lista de Serviços disponiveis.\n";
            msg += informaServicos();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Menu((acessoCadastroServico = true), msg);
    }

    private static Menu chamaMenuCadCliente(String userMsg, Chat userName) {
        msg = "Digite os seus dados para cadastro seguindo esta orientação.\n"
                + "nome:TESTE 123, \n"
                + "cep:95912879, \n"
                + "cpfCnpj:73142367047, \n"
                + "telefone:11111111111, \n"
                + "email:teste@teste.com.br, \n";

        return new Menu((acessoCadastroCliente = true), msg);
    }

    private static void enviaRespostaCliente(Update msgUser, String name, String mensagemRetorno) {
        //mensagemRetorno = criar_resposta(msgUser, primeiraMsg);
        //envio de "Escrevendo" antes de enviar a resposta
        baseResponse = bot.execute(new SendChatAction(msgUser.message().chat().id(), name));
        //verificação de ação de chat foi enviada com sucesso
        System.out.println("Resposta de Chat Action Enviada? " + baseResponse.isOk());

        //envio da mensagem de resposta
        sendResponse = bot.execute(new SendMessage(msgUser.message().chat().id(), mensagemRetorno));
        //verificação de mensagem enviada com sucesso
        System.out.println("Mensagem Enviada? " + sendResponse.isOk());
        mensagemRetorno = "";
    }

    private static Menu chamaCadastroCliente(String respostaCliente, Chat userName) throws Exception {

            HttpPost post = new HttpPost(URL_CLIENTE);
            Cliente empresa = criaCliente(respostaCliente);
            String jsonEnvio = Util.objectToJson(empresa);
            post.setEntity(new StringEntity(jsonEnvio));
            String jsonResposta = Util.enviaRequest(post);
            Optional retorno = Optional.ofNullable(Util.jsonToObject(jsonResposta, Cliente.class));

        return new Menu(retorno.isPresent(), "cliente Cadastrado com sucesso!");
    }

    private static Menu chamaCadastroServico(String mensagem, Chat userName) {

        if (StringUtils.isNumeric(mensagem)) {
            try {
                msg = "Você selecionou " + informaServicosPorID(mensagem) + ", Deseja Confirmar(s/n)";
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (mensagem.equalsIgnoreCase("s") || mensagem.equalsIgnoreCase("sim")) {
            msg = "Serviço agendado";
            acessoMenu = false;
            acessoMenuOpcoes = false;
            acessoCadastroServico = false;
            
        } else if (mensagem.equalsIgnoreCase("n") || mensagem.equalsIgnoreCase("nao")) {
            msg = "Deseja verificar o menu novamente?\nDigite menu";
        }
        mensagem = "";
        return new Menu((acessoCadastroServico = true), msg);
    }

    private static Cliente criaCliente(String msg) {
        Cliente cliente = new Cliente();
        
        String[] texto = msg.split(",");
        
        cliente.setNome(texto[0].replaceAll("nome:","").trim());
        cliente.setEndereco("Telegram");
        cliente.setNumero("1");
        cliente.setComplemento("");
        cliente.setBairro("Telegram");
        cliente.setCep(texto[1].replaceAll("cep:","").trim());
        cliente.setCpfCnpj(texto[2].replaceAll("cpfCnpj:","").trim());
        cliente.setTelefone(texto[3].replaceAll("telefone:","").trim());
        cliente.setEmail(texto[4].replaceAll("email:","").trim());
        Cidade cid = new Cidade();
        cid.setIdCidade(1);
        cliente.setCidade(cid);
        
        
        
        return cliente;
    }

}
