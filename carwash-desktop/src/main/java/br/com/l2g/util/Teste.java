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
