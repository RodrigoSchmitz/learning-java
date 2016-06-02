package br.com.globalcode.aw4.model;

import java.util.Date;

public class RegistroAtendimento {

    private Integer id;
    private String emailVisitante;
    private Date dataRegistro;
    private String textoDuvida;
    private Date dataResposta;
    private String textoResposta;

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public Date getDataResposta() {
        return dataResposta;
    }

    public String getEmailVisitante() {
        return emailVisitante;
    }

    public Integer getId() {
        return id;
    }

    public String getTextoDuvida() {
        return textoDuvida;
    }

    public String getTextoResposta() {
        return textoResposta;
    }

    public void setDataRegistro(Date date) {
        dataRegistro = date;
    }

    public void setDataResposta(Date date) {
        dataResposta = date;
    }

    public void setEmailVisitante(String string) {
        emailVisitante = string;
    }

    public void setId(Integer integer) {
        id = integer;
    }

    public void setTextoDuvida(String string) {
        textoDuvida = string;
    }

    public void setTextoResposta(String string) {
        textoResposta = string;
    }

    @Override
    public String toString() {

        return "{" + getId() + " " + getEmailVisitante() + " " + getTextoDuvida() + " " + getDataRegistro() + " " + getTextoResposta() + " " + getDataResposta() + "}";

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o instanceof RegistroAtendimento) {
            RegistroAtendimento outro = (RegistroAtendimento) o;
            return this.emailVisitante != null && this.emailVisitante.equals(outro.emailVisitante) && this.dataRegistro != null && this.dataRegistro.equals(outro.dataRegistro);
        }

        return false;

    }

    @Override
    public int hashCode() {

        int hc = 37 * (this.emailVisitante != null ? this.emailVisitante.hashCode() : 7);
        hc += 31 * (this.dataRegistro != null ? this.dataRegistro.hashCode()
                : 11);
        return hc;

    }
}
