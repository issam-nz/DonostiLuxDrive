package clases;

public class MasInfoCoche {
    private String marca;
    private String modelo;
    private int caballos;
    private String color;
    private int ano;
    private int precio_base;

    public MasInfoCoche(String marca, String modelo, int caballos, String color, int ano, int precio_base) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCaballos(caballos);
        this.setColor(color);
        this.setAno(ano);
        this.setPrecio_base(precio_base);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(int precio_base) {
        this.precio_base = precio_base;
    }

    MasInfoCoche coche1 = new MasInfoCoche("Ferrari", "812GTS", 600, "rojo", 1990, 1000);
    MasInfoCoche coche2 = new MasInfoCoche("Ferrari", "SF90STRADALE", 650, "rojo", 2002, 1200);
    MasInfoCoche coche3 = new MasInfoCoche("Rolls-Royce", "Spectre", 570, "amarillo", 2000, 1500);
    MasInfoCoche coche4 = new MasInfoCoche("Rolls-Royce", "Dawn", 550, "azul", 2005, 1100);
    MasInfoCoche coche5 = new MasInfoCoche("Bugatti", "Chiron", 600, "azul", 2010, 1550);
    MasInfoCoche coche6 = new MasInfoCoche("Mercedes", "AMGGT", 450, "gris", 2014, 1400);

}
