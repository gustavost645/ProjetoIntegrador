/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.util;

import br.com.l2g.model.Permissao;
import br.com.l2g.model.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.apache.http.HttpException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

/**
 *
 * @author Gustavo Steinhoefel teste
 */
public class Util {

    private static boolean permissao = false;

    public static String objectToJson(Object objeto) throws JsonProcessingException {
        return new ObjectMapper().registerModule(new JavaTimeModule())
                .setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(objeto);
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) throws JsonProcessingException {
        if (json == null) {
            return null;
        }
        return new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false).readValue(json, clazz);
    }

    public static String enviaRequest(HttpRequestBase metodo) throws IOException, HttpException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        metodo.setHeader("Content-type", "application/json");

        //metodo.setHeader(HttpHeaders.AUTHORIZATION, Util.criaTokenCriptorgrafado(TOKEN));
        CloseableHttpResponse response = httpClient.execute(metodo);

        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode != 200 && statusCode != 201) {
            throw new HttpException("Erro ao enviar requisição: " + statusCode);
        }

        return EntityUtils.toString(response.getEntity());
    }

    public static String geraMD5(String input) {
        String md5 = null;
        if (null == input) {
            return null;
        }
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            //Converts message digest value in base 16 (hex) 
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }

    public static boolean validaPermissaoAcesso(Usuario usuarioTelaPrincipal, String nomeClasseOrigem, JButton jButton1, JButton jButton2, JButton jButton3) {
        /*permissao = false;
        for (Permissao p : usuarioTelaPrincipal.getGrupoPermissao().getListaPermissao()) {
            if (p.getClasseNome().contains(nomeClasse) && p.getPermissaoListar()) {
                jButton1.setEnabled(p.getPermissaoSalvar());
                jButton2.setEnabled(p.getPermissaoAlterar());
                jButton3.setEnabled(p.getPermissaoExcluir());
                permissao = true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario sem acesso a esta tela!", "ERRO", JOptionPane.ERROR_MESSAGE);
                permissao = false;
            }

        }
        return permissao;*/
        return usuarioTelaPrincipal.getGrupoPermissao().getListaPermissao()
                .stream()
                .filter(c -> c.getClasseNome().equalsIgnoreCase(nomeClasseOrigem)).findAny().isPresent();
    }

    public static List listarProgramasSistema() {
        Reflections r = new Reflections(
                "br.com.l2g.views",
                new SubTypesScanner(false),
                ClasspathHelper.forClassLoader()
        );
        Set<Class<?>> classes = r.getSubTypesOf(Object.class);

        List<String> list = new ArrayList<>();
        for (Class<?> c : classes) {
            list.add(c.getName().split("\\$")[0]);
        }
        list = list.stream().distinct().collect(Collectors.toList());
        return list;
    }

}
