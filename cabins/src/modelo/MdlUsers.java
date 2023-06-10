package modelo;

import java.sql.Timestamp;

/**
 * @author ADSI
 */
public class MdlUsers {

    private int id;
    private String name;
    private String last_name;
    private String phone_number;
    private String identification_type;
    private String identification_number;
    private String email;
    private String password;
    private int age;
    private String state_record;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getIdentification_type() {
        return identification_type;
    }

    public void setIdentification_type(String identification_type) {
        this.identification_type = identification_type;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState_record() {
        return state_record;
    }

    public void setState_record(String state_record) {
        this.state_record = state_record;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }
    private Timestamp create_time;
    private Timestamp update_time;

    public MdlUsers() {
    }

    public MdlUsers(int id, String name, String last_name, String phone_number, String identification_type, String identification_number, String email, String password, int age, String state_record, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.identification_type = identification_type;
        this.identification_number = identification_number;
        this.email = email;
        this.password = password;
        this.age = age;
        this.state_record = state_record;
        this.create_time = create_time;
        this.update_time = update_time;
    }

}