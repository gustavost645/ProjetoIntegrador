/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.util;

import org.apache.http.client.methods.HttpGet;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class Teste {

    private static final String URL_BASE = "http://localhost:8888/api/v1/";
    private static final String URL_EMPRESA = URL_BASE + "empresa";
    private static final String TOKEN = "@pi123Yhdfg5ai6#";

    public static void main(String[] args) {

        try {
            listaEmpresas();
            //enviaEmpresa();
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void listaEmpresas() throws Exception {
        HttpGet get = new HttpGet(URL_EMPRESA);
        String resposta = Util.enviaRequest(get);
        List<Empresa> empresa = Arrays.asList(Util.jsonToObject(resposta, Empresa[].class));
        empresa.forEach(System.out::println);
    }

    private static void enviaEmpresa() throws Exception {
        HttpPost post = new HttpPost(URL_EMPRESA);
        Empresa empresa = criaEmpresa();
        String jsonEnvio = Util.objectToJson(empresa);
        post.setEntity(new StringEntity(jsonEnvio));
        String jsonResposta = Util.enviaRequest(post);
        Empresa vendaSalva = Util.jsonToObject(jsonResposta, Empresa.class);
        System.out.println(vendaSalva);

    }

    private static Empresa criaEmpresa() {
        Empresa empresa = new Empresa();
        
        empresa.setId(Long.parseLong("2"));
        empresa.setCpfCnpj("28323609000110");
        empresa.setInsEstadual("0150183500");
        empresa.setRegimeTributario("1");
        empresa.setRazaoSocial("GUILHERME LOPES KOLBE ");
        empresa.setNomeFantasia("ALAVANKE ASSESSORIA CONSULTORIA E REPRESENTACAO");
        empresa.setLogradouro("EST TRES VENDAS");
        empresa.setCep("96511000");
        empresa.setBairro("TRES VENDAS");
        empresa.setMunicipio("CACHOEIRA DO SUL");
        empresa.setCodMunicIbge("4303004");
        empresa.setNumero("4679");
        empresa.setComplemento("");
        empresa.setUf("RS");
        empresa.setEmail("ALAVANKEFOODSERVICE@GMAIL.COM");
        empresa.setTelefone("5197215215");
        empresa.setAmbiente("HOMOLOGACAO");
        //empresa.setCertificado("");
        empresa.setSenhaCertificado("1234");
        empresa.setToken("487dd6dac77d7d74d1e1db2096c0df91f7182a7a292aa581a481d6917a2904d7");
        empresa.setNsu("0000000000");
        
        return empresa;
    }

    /*private static void enviaVenda() throws Exception {
        HttpPost post = new HttpPost(URL_VENDA);
        Venda venda = criaVenda();
        String jsonEnvio = Util.objectToJson(venda);
        post.setEntity(new StringEntity(jsonEnvio));
        String jsonResposta = enviaRequest(post);
        Venda vendaSalva = Util.jsonToObject(jsonResposta, Venda.class);
        System.out.println(vendaSalva);
    }*/
 /*private static Venda criaVenda() {
        Venda venda = new Venda();
        venda.setDataVenda(LocalDateTime.now());
        venda.setValorTotal(BigDecimal.TEN);
        venda.setCnpj("99999999999999");

        Caixa caixa = new Caixa();
        caixa.setValorFechamento(BigDecimal.TEN);
        caixa.setValorAbertura(BigDecimal.TEN);
        caixa.setDataFechamento(LocalDate.now());
        caixa.setDataFechamento(LocalDate.now());
        caixa.setEstado(true);
        venda.setCaixa(caixa);

        VendaPagamento pagamento = new VendaPagamento();
        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setNome("Dinheiro");
        pagamento.setPagamento(tipoPagamento);
        pagamento.setValor(BigDecimal.TEN);
        venda.setPagamentos(Collections.singletonList(pagamento));

        VendaProduto vendaProduto = new VendaProduto();
        vendaProduto.setQuantidade(BigDecimal.ONE);
        vendaProduto.setTotal(BigDecimal.TEN);

        Produto produto = new Produto();
        produto.setNome("Produto");
        produto.setValor(BigDecimal.TEN);
        vendaProduto.setProduto(produto);
        venda.setProdutos(Collections.singletonList(vendaProduto));

        return venda;
    }*/
}
