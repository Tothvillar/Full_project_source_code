public class user {
    private String user_name;
    private String passWord;
    private String Identification_number;
    private String phone_number;

    public user() {
    }

    public user(String user_name, String passWord, String Identification_number, String phone_number) {
        this.user_name = user_name;
        this.passWord = passWord;
        this.Identification_number = Identification_number;
        this.phone_number = phone_number;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        if (user_name.length()>=3&&user_name.length()<=15) {
            int i=0;
            while (i<=user_name.length()-1){
                if(user_name.charAt(i)>='0'&&user_name.charAt(i)<='9')
                {
                    i++;
                }else{
                    break;
                }

            }
            if (i==user_name.length()){
                System.out.println("对不起，用户名输入错误");
            }
            else {
                this.user_name = user_name;
            }
        }
        else {
            System.out.println("对不起，用户名输入错误");
        }
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getIdentification_number() {
        return Identification_number;
    }
    public void setIdentification_number(String Identification_number) {
        this.Identification_number = Identification_number;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String toString() {
        return "user{user_name = " + user_name + ", passWord = " + passWord + ", Identification_number = " + Identification_number + ", phone_number = " + phone_number + "}";
    }
    public void Change_password(String new_passWord){
        this.passWord=new_passWord;
    }
}
