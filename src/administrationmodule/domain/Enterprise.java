package administrationmodule.domain;

public class Enterprise {
    
    private Long enterprise_id;
    private String enterprise_name;
    private String enterprise_ruc;
    private String enterprise_description;
    private String enterprise_type;
    private int enterprise_first_facture_number;
    private int enterprise_second_facture_number;
    private int enterprise_third_facture_number;

    /**
     * @return the enterprise_id
     */
    public Long getEnterprise_id() {
        return enterprise_id;
    }

    /**
     * @param enterprise_id the enterprise_id to set
     */
    public void setEnterprise_id(Long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    /**
     * @return the enterprise_name
     */
    public String getEnterprise_name() {
        return enterprise_name;
    }

    /**
     * @param enterprise_name the enterprise_name to set
     */
    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    /**
     * @return the enterprise_ruc
     */
    public String getEnterprise_ruc() {
        return enterprise_ruc;
    }

    /**
     * @param enterprise_ruc the enterprise_ruc to set
     */
    public void setEnterprise_ruc(String enterprise_ruc) {
        this.enterprise_ruc = enterprise_ruc;
    }

    /**
     * @return the enterprise_description
     */
    public String getEnterprise_description() {
        return enterprise_description;
    }

    /**
     * @param enterprise_description the enterprise_description to set
     */
    public void setEnterprise_description(String enterprise_description) {
        this.enterprise_description = enterprise_description;
    }

    /**
     * @return the enterprise_type
     */
    public String getEnterprise_type() {
        return enterprise_type;
    }

    /**
     * @param enterprise_type the enterprise_type to set
     */
    public void setEnterprise_type(String enterprise_type) {
        this.enterprise_type = enterprise_type;
    }

    /**
     * @return the enterprise_first_facture_number
     */
    public int getEnterprise_first_facture_number() {
        return enterprise_first_facture_number;
    }

    /**
     * @param enterprise_first_facture_number the enterprise_first_facture_number to set
     */
    public void setEnterprise_first_facture_number(int enterprise_first_facture_number) {
        this.enterprise_first_facture_number = enterprise_first_facture_number;
    }

    /**
     * @return the enterprise_second_facture_number
     */
    public int getEnterprise_second_facture_number() {
        return enterprise_second_facture_number;
    }

    /**
     * @param enterprise_second_facture_number the enterprise_second_facture_number to set
     */
    public void setEnterprise_second_facture_number(int enterprise_second_facture_number) {
        this.enterprise_second_facture_number = enterprise_second_facture_number;
    }

    /**
     * @return the enterprise_third_facture_number
     */
    public int getEnterprise_third_facture_number() {
        return enterprise_third_facture_number;
    }

    /**
     * @param enterprise_third_facture_number the enterprise_third_facture_number to set
     */
    public void setEnterprise_third_facture_number(int enterprise_third_facture_number) {
        this.enterprise_third_facture_number = enterprise_third_facture_number;
    }
    
    
    
}