package models;

public class Rate {

    private String base_code;                    // codigo da moeda que vai escolher como base
    private String target_code;                 // codigo da moeda que sera convertida
    private String conversion_rate;            //  valor a ser convertido
    private String conversion_result;         //   resultado do valor covertido
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public String getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(String conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public String getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(String conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate='" + conversion_rate + '\'' +
                ", conversion_result='" + conversion_result + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
