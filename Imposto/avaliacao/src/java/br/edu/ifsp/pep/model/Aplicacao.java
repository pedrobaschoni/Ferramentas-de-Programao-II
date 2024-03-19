package br.edu.ifsp.pep.model;

public class Aplicacao {
    
    private Double valor;
    private Double porcentagem;
    private Integer dias;
    private String tipo;
    private Double impostoRenda = 0.0;
    private Double rendaBruta;
    private Double rendaLiquida;
    private Double valorRendido;

    public Aplicacao() {
    }

    public Aplicacao(Double valor, Double porcentagem, Integer dias, String tipo, Double impostoRenda, Double rendaBruta, Double rendaLiquida, Double valorRendido) {
        this.valor = valor;
        this.porcentagem = porcentagem;
        this.dias = dias;
        this.tipo = tipo;
        this.impostoRenda = impostoRenda;
        this.rendaBruta = rendaBruta;
        this.rendaLiquida = rendaLiquida;
        this.valorRendido = valorRendido;
    }

    
    
    public void calcularRendaBruta() {
        setRendaBruta(getValor() + (getValor() * (getPorcentagem() / 100)));
    }
    
    public void rendimento() {
        setValorRendido(getValor() * (getPorcentagem() / 100));
    }
    
    public void calcularImpostoRenda() {
        rendimento();
        
        if(this.dias <= 180) {
            setImpostoRenda(getValorRendido() - (getValorRendido() - (getValorRendido() * 0.225)));
        } else if(this.dias <= 360) {
            setImpostoRenda(getValorRendido() - (getValorRendido() - (getValorRendido() * 0.20)));
        } else if(this.dias <= 720) {
            setImpostoRenda(getValorRendido() - (getValorRendido() - (getValorRendido() * 0.175)));
        } else {
            setImpostoRenda(getValorRendido() - (getValorRendido() - (getValorRendido() * 0.15)));
        }
    }
    
    public void calcularRendaLiquida() {
        setRendaLiquida(getRendaBruta() - getImpostoRenda());
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getImpostoRenda() {
        return impostoRenda;
    }

    public void setImpostoRenda(Double impostoRenda) {
        this.impostoRenda = impostoRenda;
    }

    public Double getRendaBruta() {
        return rendaBruta;
    }

    public void setRendaBruta(Double rendaBruta) {
        this.rendaBruta = rendaBruta;
    }

    public Double getRendaLiquida() {
        return rendaLiquida;
    }

    public void setRendaLiquida(Double rendaLiquida) {
        this.rendaLiquida = rendaLiquida;
    }

    public Double getValorRendido() {
        return valorRendido;
    }

    public void setValorRendido(Double valorRendido) {
        this.valorRendido = valorRendido;
    }

    

    
    
    
}
