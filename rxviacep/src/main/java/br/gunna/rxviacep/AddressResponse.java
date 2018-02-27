/**
 * MIT License
 * <p>
 * Copyright (c) 2018 Daniel Gunna
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package br.gunna.rxviacep;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AddressResponse {

    @SerializedName("cep")
    @Expose
    private String cep;
    @SerializedName("logradouro")
    @Expose
    private String logradouro;
    @SerializedName("complemento")
    @Expose
    private String complemento;
    @SerializedName("bairro")
    @Expose
    private String bairro;
    @SerializedName("localidade")
    @Expose
    private String localidade;
    @SerializedName("uf")
    @Expose
    private String uf;
    @SerializedName("unidade")
    @Expose
    private String unidade;
    @SerializedName("ibge")
    @Expose
    private String ibge;
    @SerializedName("gia")
    @Expose
    private String gia;
    @Expose
    @SerializedName("erro")
    private boolean error;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    private String fullAddress;

    /**
     * @return The cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep The cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return The logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro The logradouro
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return The complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento The complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return The bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro The bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return The localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * @param localidade The localidade
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * @return The uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf The uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return The unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade The unidade
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return The ibge
     */
    public String getIbge() {
        return ibge;
    }

    /**
     * @param ibge The ibge
     */
    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    /**
     * @return The gia
     */
    public String getGia() {
        return gia;
    }

    /**
     * @param gia The gia
     */
    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getFullAddress() {
        return logradouro + "," + bairro + "," + localidade + "," + uf;

    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}